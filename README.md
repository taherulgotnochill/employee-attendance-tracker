# Employee Attendance Tracker

A Data Structures and Algorithms (DSA) project demonstrating employee management and daily attendance tracking.

**Student:** Mohammad Taherul Raza  
**ERP ID:** RU_25-10809  
**Project Guide:** Ms. Naina Singh  
**University:** Rungta International Skills University  
**Session:** 2026–27

## Project contents

```text
employee-attendance-tracker/
├── java/
│   └── EmployeeAttendanceTracker.java
├── prototype/
│   └── index.html
├── docs/
│   └── Employee_Attendance_Tracker_Interim_Report.pdf
├── presentation/
│   └── Employee_Attendance_Tracker_Presentation.pptx
├── README.md
└── .gitignore
```

## DSA concepts

- **Array:** stores employee objects in the Java implementation.
- **HashMap:** maps employee IDs to array indexes for average-case fast lookup.
- **Nested HashMap:** stores each employee's date-wise attendance status.
- **Searching:** retrieves employee details using the employee ID.

## Java implementation

The Java console program supports:
1. Add employee
2. View all employees
3. Mark attendance
4. Search employee by ID
5. View attendance report
6. Update attendance
7. Delete employee

### Run

Requires a Java JDK (JDK 17 or later recommended).

```bash
cd java
javac EmployeeAttendanceTracker.java
java EmployeeAttendanceTracker
```

## Browser prototype

Open `prototype/index.html` in a modern browser. No server is required.

The prototype demonstrates:
- Dashboard summary
- Employee registration and directory
- Search by employee ID or name
- Mark and update attendance by date
- Attendance reports

The prototype stores its demo data in browser `localStorage`.

## Important implementation note

The Java console application and browser prototype are separate components in this version. They do not yet share a backend or database. The Java implementation stores records in memory while it runs; the browser prototype stores its demo data locally in the browser.

## Project documents

- Interim report: `docs/Employee_Attendance_Tracker_Interim_Report.pdf`
- Presentation: `presentation/Employee_Attendance_Tracker_Presentation.pptx`

## Future enhancements

- Connect the browser interface to a Java backend using APIs.
- Add MySQL or SQLite persistence.
- Add authentication and role-based access.
- Add monthly reports and CSV/PDF export.
- Add leave and late-arrival tracking.
