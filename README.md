# Employee Attendance Tracker

**DSA concepts:** Array, HashMap, Searching  
**Language:** Java (console implementation)  
**Prototype:** HTML, CSS and JavaScript (browser-based interactive mock-up)

## 1. Run the Java DSA project

You need Java JDK 17 or later.

```bash
cd java
javac EmployeeAttendanceTracker.java
java EmployeeAttendanceTracker
```

The console program supports:
1. Add employee
2. View employees
3. Mark attendance for the current date
4. Search employee by ID
5. View an employee attendance report
6. Update an attendance record
7. Delete employee

## 2. Open the visual prototype

Open `prototype/index.html` in Chrome, Edge, or Firefox. No server or installation is required.

The prototype supports adding/deleting employees, searching by ID/name, marking or updating attendance by date, dashboard totals, and individual attendance reports. Its demo data is saved in the browser's localStorage.

## 3. Where the DSA concepts appear

- **Array:** `Employee[] employees` stores employee objects in the Java implementation.
- **HashMap:** `employeeIndex` maps an employee ID to their array index for fast lookup. `attendance` maps employee IDs to their date-wise attendance records.
- **Searching:** `searchEmployee()` searches using the HashMap key (employee ID). The prototype also demonstrates a simple filter search by ID/name.

## 4. Complexity (Java implementation)

| Operation | Expected time |
|---|---:|
| Add employee | O(1) average |
| Search employee by ID | O(1) average |
| Mark/update attendance | O(1) average |
| View all employees | O(n) |
| Delete employee | O(n) due to array shifting and index rebuilding |

`n` = number of employees. HashMap operations are average-case estimates.

## 5. Important prototype note

The browser prototype is a front-end demonstration and stores its sample data locally in the browser. The Java console program is the separate DSA implementation. They are not connected to each other and do not use a shared database.

## 6. Suggested project explanation

"The Employee Attendance Tracker is designed to maintain employee details and daily attendance. An array stores employee records, while a HashMap maps employee IDs to their positions and attendance information. This makes searching and attendance updates efficient. The project also provides employee management and attendance reports."
