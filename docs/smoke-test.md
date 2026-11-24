# Smoke Test: v1.0.0

**Date:** ____
**Tester:** ____
**Version:** downloaded from the GitHub release (not from the IDE)

| # | Check | Expected | Result |
|---|---|---|---|
| 1 | Start backend with `java -jar` | Starts without errors, port 8080 | |
| 2 | Start frontend from `frontend-dist.zip` | Page opens at http://localhost:5173 | |
| 3 | First open without login | Balance shows 0.00 € | |
| 4 | Add income of 100 € | Balance shows 100.00 € | |
| 5 | Add expense of 30 € (Food) | Balance shows 70.00 € | |
| 6 | Look at the list | Both entries are shown | |
| 7 | Add amount 0 | Error message is shown | |
| 8 | Reload the page | Data is still there | |

**Overall result:** passed / failed

## v1.0.1 (TT.MM.2026)

Hotfix release, built from `release/1.0`.

### Fixed

- Amounts with more than two decimal places are rounded to two decimals (HALF_UP).
- Amounts that round to zero are rejected.