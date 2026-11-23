<script lang="ts">
  import { onMount } from 'svelte';
  import {
    createUser,
    getTransactions,
    getBalance,
    addTransaction,
    type Transaction,
    type TransactionType,
  } from './lib/api';

  const categories = ['Food', 'Rent', 'Transport', 'Leisure', 'Other'];

  let userId = $state('');
  let transactions = $state<Transaction[]>([]);
  let balance = $state(0);
  let error = $state('');

  let type = $state<TransactionType>('EXPENSE');
  let amount = $state('');
  let date = $state('');
  let description = $state('');
  let category = $state(categories[0]);

  async function refresh() {
    transactions = await getTransactions(userId);
    balance = await getBalance(userId);
  }

  onMount(async () => {
    try {
      let id = localStorage.getItem('userId');
      if (!id) {
        id = await createUser();
        localStorage.setItem('userId', id);
      }
      userId = id;
      await refresh();
    } catch (e) {
      error = e instanceof Error ? e.message : 'Backend not reachable';
    }
  });

  async function submit(event: Event) {
    event.preventDefault();
    error = '';
    try {
      await addTransaction(userId, {
        type,
        amount: Number(amount),
        date: date || null,
        description,
        category: type === 'EXPENSE' ? category : null,
      });
      amount = '';
      description = '';
      await refresh();
    } catch (e) {
      error = e instanceof Error ? e.message : 'Something went wrong';
    }
  }

  function format(value: number): string {
    return value.toFixed(2) + ' €';
  }
</script>

<main>
  <h1>Budget Planner</h1>
  <p class="hint">Anonymous session, no registration needed.</p>

  <section class="balance" class:negative={balance < 0}>
    <span>Current balance</span>
    <strong>{format(balance)}</strong>
  </section>

  {#if error}
    <p class="error">{error}</p>
  {/if}

  <form onsubmit={submit}>
    <h2>Add transaction</h2>

    <label>
      Type
      <select bind:value={type}>
        <option value="INCOME">Income</option>
        <option value="EXPENSE">Expense</option>
      </select>
    </label>

    <label>
      Amount (€)
      <input type="number" step="0.01" min="0" bind:value={amount} required />
    </label>

    <label>
      Date
      <input type="date" bind:value={date} />
    </label>

    <label>
      Description
      <input type="text" bind:value={description} />
    </label>

    {#if type === 'EXPENSE'}
      <label>
        Category
        <select bind:value={category}>
          {#each categories as c}
            <option value={c}>{c}</option>
          {/each}
        </select>
      </label>
    {/if}

    <button type="submit">Add</button>
  </form>

  <section>
    <h2>Transactions</h2>
    {#if transactions.length === 0}
      <p class="hint">No transactions yet.</p>
    {:else}
      <table>
        <thead>
          <tr><th>Date</th><th>Description</th><th>Category</th><th class="num">Amount</th></tr>
        </thead>
        <tbody>
          {#each transactions as t (t.id)}
            <tr>
              <td>{t.date}</td>
              <td>{t.description ?? ''}</td>
              <td>{t.category ?? '-'}</td>
              <td class="num" class:income={t.type === 'INCOME'}>
                {t.type === 'INCOME' ? '+' : '-'}{format(t.amount)}
              </td>
            </tr>
          {/each}
        </tbody>
      </table>
    {/if}
  </section>
</main>

<style>
  main { max-width: 640px; margin: 0 auto; padding: 1rem; text-align: left; }
  .hint { opacity: 0.7; }
  .balance { display: flex; justify-content: space-between; align-items: center;
    padding: 1rem; border-radius: 8px; background: #e8f5e9; color: #1b5e20; font-size: 1.2rem; }
  .balance.negative { background: #ffebee; color: #b71c1c; }
  .error { color: #b71c1c; }
  form { display: grid; gap: 0.75rem; margin: 1.5rem 0; }
  label { display: grid; gap: 0.25rem; }
  input, select, button { padding: 0.5rem; font-size: 1rem; }
  table { width: 100%; border-collapse: collapse; }
  th, td { padding: 0.4rem; border-bottom: 1px solid #8884; text-align: left; }
  .num { text-align: right; }
  .income { color: #2e7d32; }
</style>