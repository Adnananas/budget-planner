const BASE = 'http://localhost:8080/api';

export type TransactionType = 'INCOME' | 'EXPENSE';

export interface Transaction {
    id: string;
    type: TransactionType;
    amount: number;
    date: string;
    description: string | null;
    category: string | null;
}

export interface NewTransaction {
    type: TransactionType;
    amount: number;
    date: string | null;
    description: string;
    category: string | null;
}

async function request<T>(path: string, options: RequestInit = {}, userId?: string): Promise<T> {
    const headers: Record<string, string> = { 'Content-Type': 'application/json' };
    if (userId) headers['X-User-Id'] = userId;

    const response = await fetch(`${BASE}${path}`, { ...options, headers });
    const body = await response.json().catch(() => ({}));
    if (!response.ok) {
        throw new Error(body.error ?? `Request failed (${response.status})`);
    }
    return body as T;
}

export async function createUser(): Promise<string> {
    const result = await request<{ id: string }>('/users', { method: 'POST' });
    return result.id;
}

export function getTransactions(userId: string): Promise<Transaction[]> {
    return request<Transaction[]>('/transactions', {}, userId);
}

export async function getBalance(userId: string): Promise<number> {
    const result = await request<{ balance: number }>('/balance', {}, userId);
    return result.balance;
}

export function addTransaction(userId: string, data: NewTransaction): Promise<Transaction> {
    return request<Transaction>('/transactions', { method: 'POST', body: JSON.stringify(data) }, userId);
}