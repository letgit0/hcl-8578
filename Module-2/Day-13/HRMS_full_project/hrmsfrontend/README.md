# HRMS React frontend

## Requirements
- Node.js 20+ recommended
- Spring Boot backend running at `http://localhost:8080`

## Run
1. Open this folder in VS Code / terminal.
2. Run `npm install`
3. Run `npm run dev`
4. Open the Vite URL, usually `http://localhost:5173`.

The frontend calls the backend at `http://localhost:8080/api`. If you change the backend port, update `API` at the top of `src/App.jsx`.

Features: employee registration/list/search/delete, employee ID + email verification using backend `@RequestParam`, and attendance marking/listing.
