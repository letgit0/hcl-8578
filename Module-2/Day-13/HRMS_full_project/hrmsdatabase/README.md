# HRMS Spring Boot backend

## Requirements
- JDK 17+
- MySQL Server running
- IntelliJ IDEA or Maven

## Run
1. Open this folder as a Maven project.
2. Edit `src/main/resources/application.properties` and replace `YOUR_MYSQL_PASSWORD` with your local MySQL password.
3. Run `HrmsdatabaseApplication.java` (or `mvn spring-boot:run`). The database `abeshclhrms` is created automatically if the MySQL account has permission.
4. API base URL: `http://localhost:8080/api`.

## API endpoints
- `GET /api/employees/health` - health check
- `GET /api/employees` - list employees
- `POST /api/employees` - create employee; JSON keys: `emp_id`, `emp_name`, `stack`, `designation`, `email`
- `GET /api/employees/{id}` - employee by ID
- `GET /api/employees/verify?id=101&email=person@example.com` - verifies employee ID and email using `@RequestParam`
- `DELETE /api/employees/{id}` - delete employee
- `GET /api/attendance` - list attendance
- `POST /api/attendance` - mark attendance with JSON `{"employeeId":101,"date":"2026-10-28","comment":"Present"}`

The email/ID verification endpoint checks a matching database record. It is not an email OTP system and does not send email.
