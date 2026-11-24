# Budget Planner

A budget planner with an anonymous start. Backend: Java (Spring Boot). Frontend: Svelte with TypeScript.

## Run the released version

Requirements: Java 25 and Node.js.

1. Download `backend-*.jar` and `frontend-dist.zip` from the latest release.
2. Start the backend: `java -jar backend-0.0.1-SNAPSHOT.jar` (it runs on port 8080).
3. Unzip `frontend-dist.zip` into a folder and run `npx serve -l 5173 .` inside it.
4. Open http://localhost:5173

## Run for development

- Backend: `cd backend` then `mvnw spring-boot:run`
- Frontend: `cd frontend`, `npm install`, `npm run dev`

## Documentation

- `docs/user-stories.md`: product backlog
- `docs/sprint-plan.md`: sprint planning
- `docs/release-notes.md`: released user stories
- `docs/smoke-test.md`: smoke test results