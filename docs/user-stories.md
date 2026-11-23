# Budget Planner: User Story Backlog

Format: **ID** (Priority, Story Points): As a *role*, I want *feature*, so that *benefit*.
Stories marked **[Sprint 1]** are planned for the first sprint (25.11. to 27.11.).

Priority: High / Medium / Low. Story Points: 1, 2, 3, 5.

---

## Epic 1: Anonymous Usage

- **US-01 [Sprint 1]** (High, 2): As a visitor, I want to use the app without registering, so that I can try it immediately.
  *Acceptance:* On first start I can add entries without entering any personal data.
- **US-02 [Sprint 1]** (High, 3): As an anonymous user, I want to receive a random ID, so that my data is assigned to me without revealing my name.
  *Acceptance:* The backend generates a UUID and stores no personal data.
- **US-03** (Medium, 2): As an anonymous user, I want to delete all my data at any time, so that I stay in control of my data.
  *Acceptance:* A delete button permanently removes all my entries and my ID.
- **US-04** (Medium, 2): As an anonymous user, I want to see a notice that my data is anonymous, so that I understand what is stored about me.
  *Acceptance:* A short privacy notice is shown on first start.
- **US-05** (Low, 3): As an anonymous user, I want my session to be remembered on my device, so that I do not lose my data when I close the browser.
  *Acceptance:* After reopening the app on the same device, my entries are still visible.

## Epic 2: Income and Expenses

- **US-06 [Sprint 1]** (High, 2): As a user, I want to add an income entry with amount, date and description, so that I can see how much money I receive.
  *Acceptance:* A valid entry appears in my transaction list; invalid amounts are rejected.
- **US-07 [Sprint 1]** (High, 3): As a user, I want to add an expense with amount, date and category, so that I know what I spend money on.
  *Acceptance:* I can choose a category from a fixed list; the expense appears in my list.
- **US-08 [Sprint 1]** (High, 2): As a user, I want to see my current balance, so that I know how much money I have left.
  *Acceptance:* Balance equals total income minus total expenses and updates after every change.
- **US-09 [Sprint 1]** (High, 2): As a user, I want to see a list of all my transactions, so that I have an overview of my finances.
  *Acceptance:* The list shows date, description, category and amount, newest first.
- **US-10** (Medium, 2): As a user, I want to edit a transaction, so that I can correct mistakes.
  *Acceptance:* Changed values are saved and the balance is recalculated.
- **US-11** (Medium, 1): As a user, I want to delete a transaction, so that I can remove wrong entries.
  *Acceptance:* The transaction disappears and the balance is recalculated.
- **US-12** (Medium, 3): As a user, I want to filter transactions by month, so that I can focus on one period.
  *Acceptance:* Selecting a month shows only transactions of that month.
- **US-13** (Medium, 3): As a user, I want to search transactions by description, so that I can find a specific entry quickly.
  *Acceptance:* Typing text filters the list to matching entries.
- **US-14** (Low, 5): As a user, I want to add recurring transactions (e.g. rent), so that I do not have to enter them every month.
  *Acceptance:* A recurring entry is created automatically at the chosen interval.
- **US-15** (Low, 2): As a user, I want to attach a note to a transaction, so that I can remember details later.
  *Acceptance:* An optional note is saved and shown in the transaction details.

## Epic 3: Categories and Budgets

- **US-16** (High, 2): As a user, I want predefined categories (food, rent, transport, leisure), so that I can start without setup.
  *Acceptance:* At least four default categories exist after first start.
- **US-17** (Medium, 2): As a user, I want to create my own category, so that the app fits my needs.
  *Acceptance:* A new category with a unique name can be selected for transactions.
- **US-18** (Medium, 2): As a user, I want to rename a category, so that I can keep my categories tidy.
  *Acceptance:* Existing transactions show the new name.
- **US-19** (Low, 3): As a user, I want to delete a category, so that I can remove unused ones.
  *Acceptance:* Deleting is only possible if no transaction uses it, or transactions are moved to "Other".
- **US-20** (Medium, 3): As a user, I want to set a monthly budget per category, so that I do not overspend.
  *Acceptance:* A budget amount can be saved per category and month.
- **US-21** (Medium, 3): As a user, I want to see how much of each budget is used, so that I know how much I can still spend.
  *Acceptance:* Each category shows spent amount, budget and remaining amount.
- **US-22** (Medium, 3): As a user, I want a warning when I exceed a budget, so that I can react in time.
  *Acceptance:* A visible warning appears when spending exceeds the category budget.
- **US-23** (Low, 2): As a user, I want to assign a color to a category, so that I can recognize it quickly.
  *Acceptance:* The chosen color is shown next to the category everywhere.

## Epic 4: Savings Goals

- **US-24** (Medium, 3): As a user, I want to create a savings goal with a target amount, so that I have something to work towards.
  *Acceptance:* A goal with name and target amount is saved and listed.
- **US-25** (Medium, 2): As a user, I want to set a target date for a goal, so that I know how fast I need to save.
  *Acceptance:* The goal shows the deadline and the days remaining.
- **US-26** (Medium, 3): As a user, I want to add money to a savings goal, so that I can track my progress.
  *Acceptance:* The saved amount increases and the balance is reduced accordingly.
- **US-27** (Medium, 2): As a user, I want to see a progress bar for each goal, so that I see my progress at a glance.
  *Acceptance:* The bar shows the percentage of the target reached.
- **US-28** (Low, 2): As a user, I want to edit or delete a goal, so that I can adapt my plans.
  *Acceptance:* Changes are saved; deleting returns saved money to the balance.
- **US-29** (Low, 3): As a user, I want a message when I reach a goal, so that I feel rewarded.
  *Acceptance:* A congratulation message appears when saved amount reaches the target.

## Epic 5: Reports and Charts

- **US-30** (Medium, 3): As a user, I want a monthly summary of income and expenses, so that I understand my month.
  *Acceptance:* The summary shows total income, total expenses and difference.
- **US-31** (Medium, 5): As a user, I want a pie chart of expenses by category, so that I see where my money goes.
  *Acceptance:* The chart shows each category's share of total expenses.
- **US-32** (Low, 5): As a user, I want a line chart of my balance over time, so that I see trends.
  *Acceptance:* The chart shows the balance per day or month.
- **US-33** (Low, 3): As a user, I want to compare two months, so that I can see if I improved.
  *Acceptance:* Two selected months are shown side by side with the difference.
- **US-34** (Low, 3): As a user, I want to see my biggest expenses, so that I can find savings potential.
  *Acceptance:* A list shows the top five expenses of the selected period.
- **US-35** (Low, 2): As a user, I want to see my average monthly spending, so that I can plan better.
  *Acceptance:* The average is calculated from all months with data.
- **US-36** (Low, 3): As a user, I want to select a custom date range for reports, so that I can analyze any period.
  *Acceptance:* All report views respect the selected start and end date.

## Epic 6: Login and Account

- **US-37** (Medium, 5): As an anonymous user, I want to create an account with a pseudonym and password, so that I can access my data from other devices.
  *Acceptance:* Registration needs no email or real name; the password is stored as a hash.
- **US-38** (Medium, 3): As a user, I want to log in with pseudonym and password, so that I can access my account.
  *Acceptance:* Correct credentials give access; wrong credentials show an error.
- **US-39** (Medium, 5): As an anonymous user, I want to upgrade to an account and keep my existing data, so that I do not lose my entries.
  *Acceptance:* After registration, all entries of my anonymous ID belong to my account.
- **US-40** (Medium, 2): As a user, I want to log out, so that nobody else can use my account on a shared device.
  *Acceptance:* After logout, protected pages require login again.
- **US-41** (Low, 3): As a user, I want to change my password, so that I can keep my account secure.
  *Acceptance:* The old password is required; the new password is stored as a hash.
- **US-42** (Low, 3): As a user, I want to change my pseudonym, so that I can stay anonymous even if my name leaked.
  *Acceptance:* The new pseudonym must be unique and replaces the old one.
- **US-43** (Low, 3): As a user, I want to delete my account and all data, so that I can leave the service completely.
  *Acceptance:* Account and all linked data are removed permanently after confirmation.
- **US-44** (Low, 5): As a user, I want a recovery code, so that I can regain access if I forget my password without giving an email.
  *Acceptance:* A one-time recovery code is shown at registration and can reset the password.

## Epic 7: Friends and Sharing

- **US-45** (Low, 3): As a user, I want to create an invitation code, so that I can invite a friend without sharing my name.
  *Acceptance:* A unique code is generated and expires after use or after seven days.
- **US-46** (Low, 3): As a user, I want to enter a friend's code, so that we become connected.
  *Acceptance:* A valid code creates a connection for both users.
- **US-47** (Low, 2): As a user, I want to see my friends by pseudonym, so that I know who I am connected to.
  *Acceptance:* The friend list shows pseudonyms only.
- **US-48** (Low, 2): As a user, I want to remove a friend, so that I can end a connection.
  *Acceptance:* After removal, the other person no longer sees my shared data.
- **US-49** (Low, 3): As a user, I want to choose exactly which data I share, so that my private finances stay private.
  *Acceptance:* Only quest progress is shared by default; balances are never shared.
- **US-50** (Low, 2): As a user, I want to block a user, so that I am not contacted again.
  *Acceptance:* A blocked user cannot send invitations or see my shared data.

## Epic 8: Quests and To-dos

- **US-51** (Low, 3): As a user, I want to create a personal to-do (e.g. "cancel insurance"), so that I do not forget financial tasks.
  *Acceptance:* A to-do with title and optional due date is saved.
- **US-52** (Low, 1): As a user, I want to mark a to-do as done, so that I see what is finished.
  *Acceptance:* Done to-dos are visually marked and can be hidden.
- **US-53** (Low, 3): As a user, I want to create a shared to-do list with a friend, so that we can organize tasks together.
  *Acceptance:* Both users can see and edit the shared list.
- **US-54** (Low, 5): As a user, I want to create a quest with a friend (e.g. "spend max. 50 EUR on food this week"), so that we motivate each other.
  *Acceptance:* A quest has a goal, a period and participants.
- **US-55** (Low, 3): As a user, I want to see the quest progress of all participants, so that we know how we are doing.
  *Acceptance:* Progress is shown as percentage without revealing exact amounts.
- **US-56** (Low, 3): As a user, I want to accept or decline a quest invitation, so that I decide what I join.
  *Acceptance:* Only accepted quests appear in my quest list.
- **US-57** (Low, 3): As a user, I want to earn badges for completed quests, so that I feel rewarded.
  *Acceptance:* A badge is added to my profile when a quest is completed.
- **US-58** (Low, 3): As a user, I want a streak counter for days without exceeding my budget, so that I stay motivated.
  *Acceptance:* The counter increases daily and resets when a budget is exceeded.

## Epic 9: Settings, Privacy and Export

- **US-59** (Medium, 2): As a user, I want to choose my currency, so that amounts are shown correctly.
  *Acceptance:* All amounts use the selected currency symbol.
- **US-60** (Low, 2): As a user, I want to switch between light and dark mode, so that the app is comfortable to use.
  *Acceptance:* The selected theme is applied and remembered.
- **US-61** (Medium, 3): As a user, I want to export my transactions as CSV, so that I can use them in other tools.
  *Acceptance:* The CSV file contains all transactions with date, category and amount.
- **US-62** (Medium, 3): As a user, I want to download all data stored about me, so that I can see what the app knows about me.
  *Acceptance:* A file with all my stored data is generated on request.
- **US-63** (Low, 2): As a user, I want to see a privacy page, so that I understand how my data is handled.
  *Acceptance:* A page explains which data is stored and that no real names are required.

---

## Summary

| Epic | Stories |
|---|---|
| 1. Anonymous Usage | 5 |
| 2. Income and Expenses | 10 |
| 3. Categories and Budgets | 8 |
| 4. Savings Goals | 6 |
| 5. Reports and Charts | 7 |
| 6. Login and Account | 8 |
| 7. Friends and Sharing | 6 |
| 8. Quests and To-dos | 8 |
| 9. Settings, Privacy and Export | 5 |
| **Total** | **63** |

Sprint 1 scope: US-01, US-02, US-06, US-07, US-08, US-09 (total 14 story points).
