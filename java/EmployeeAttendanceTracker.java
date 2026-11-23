import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Employee Attendance Tracker
 * DSA: Array, HashMap, Searching
 *
 * Compile: javac EmployeeAttendanceTracker.java
 * Run:     java EmployeeAttendanceTracker
 */
public class EmployeeAttendanceTracker {
    private static final int CAPACITY = 100;
    private static final Employee[] employees = new Employee[CAPACITY];
    private static final HashMap<Integer, Integer> employeeIndex = new HashMap<>();
    
    private static final HashMap<Integer, HashMap<String, String>> attendance = new HashMap<>();
    private static int employeeCount = 0;
    private static final Scanner sc = new Scanner(System.in);

    static class Employee {
        int id;
        String name;
        String department;

        Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }
    }

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("====================================");
        System.out.println("     EMPLOYEE ATTENDANCE TRACKER");
        System.out.println("====================================");

        while (running) {
            showMenu();
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> markAttendance();
                case 4 -> searchEmployee();
                case 5 -> viewAttendanceReport();
                case 6 -> updateAttendance();
                case 7 -> deleteEmployee();
                case 0 -> {
                    running = false;
                    System.out.println("Thank you for using the tracker!");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    private static void showMenu() {
        System.out.println("\n----------- MAIN MENU -----------");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Mark Attendance");
        System.out.println("4. Search Employee");
        System.out.println("5. Attendance Report");
        System.out.println("6. Update Attendance");
        System.out.println("7. Delete Employee");
        System.out.println("0. Exit");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void addEmployee() {
        if (employeeCount == CAPACITY) {
            System.out.println("Employee storage is full.");
            return;
        }

        int id = readInt("Employee ID: ");
        if (employeeIndex.containsKey(id)) {
            System.out.println("An employee with this ID already exists.");
            return;
        }

        System.out.print("Employee name: ");
        String name = sc.nextLine().trim();
        System.out.print("Department: ");
        String department = sc.nextLine().trim();

        if (name.isEmpty() || department.isEmpty()) {
            System.out.println("Name and department cannot be empty.");
            return;
        }

        employees[employeeCount] = new Employee(id, name, department);
        employeeIndex.put(id, employeeCount);
        attendance.put(id, new HashMap<>());
        employeeCount++;
        System.out.println("Employee added successfully.");
    }

    private static void viewEmployees() {
        if (employeeCount == 0) {
            System.out.println("No employees registered.");
            return;
        }

        System.out.println("\nID\tNAME\t\tDEPARTMENT");
        System.out.println("----------------------------------------");
        for (int i = 0; i < employeeCount; i++) {
            Employee e = employees[i];
            System.out.printf("%d\t%-16s%s%n", e.id, e.name, e.department);
        }
    }

    private static void markAttendance() {
        int id = readInt("Employee ID: ");
        Integer index = employeeIndex.get(id);
        if (index == null) {
            System.out.println("Employee not found.");
            return;
        }

        String date = LocalDate.now().toString();
        System.out.print("Status (P = Present, A = Absent): ");
        String status = sc.nextLine().trim().toUpperCase();

        if (!status.equals("P") && !status.equals("A")) {
            System.out.println("Enter only P or A.");
            return;
        }

        attendance.get(id).put(date, status.equals("P") ? "Present" : "Absent");
        System.out.println("Attendance saved for " + employees[index].name + " on " + date + ".");
    }

    private static void searchEmployee() {
        int id = readInt("Enter employee ID to search: ");
        Integer index = employeeIndex.get(id);
        if (index == null) {
            System.out.println("Employee not found.");
            return;
        }

        Employee e = employees[index];
        System.out.println("\nEmployee found:");
        System.out.println("ID: " + e.id);
        System.out.println("Name: " + e.name);
        System.out.println("Department: " + e.department);
    }

    private static void viewAttendanceReport() {
        int id = readInt("Enter employee ID for report: ");
        Integer index = employeeIndex.get(id);
        if (index == null) {
            System.out.println("Employee not found.");
            return;
        }

        Employee e = employees[index];
        HashMap<String, String> records = attendance.get(id);
        int present = 0;
        int absent = 0;

        System.out.println("\nAttendance report for " + e.name + " (ID: " + id + ")");
        if (records.isEmpty()) {
            System.out.println("No attendance records yet.");
            return;
        }

        System.out.println("DATE\t\tSTATUS");
        for (Map.Entry<String, String> record : records.entrySet()) {
            System.out.println(record.getKey() + "\t" + record.getValue());
            if (record.getValue().equals("Present")) present++;
            else absent++;
        }
        System.out.println("Present days: " + present);
        System.out.println("Absent days: " + absent);
        System.out.println("Recorded days: " + (present + absent));
    }

    private static void updateAttendance() {
        int id = readInt("Employee ID: ");
        if (!employeeIndex.containsKey(id)) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("Date (YYYY-MM-DD): ");
        String date = sc.nextLine().trim();
        HashMap<String, String> records = attendance.get(id);
        if (!records.containsKey(date)) {
            System.out.println("No attendance record exists for that date.");
            return;
        }

        System.out.print("New status (P = Present, A = Absent): ");
        String status = sc.nextLine().trim().toUpperCase();
        if (!status.equals("P") && !status.equals("A")) {
            System.out.println("Enter only P or A.");
            return;
        }

        records.put(date, status.equals("P") ? "Present" : "Absent");
        System.out.println("Attendance updated successfully.");
    }

    private static void deleteEmployee() {
        int id = readInt("Employee ID to delete: ");
        Integer index = employeeIndex.get(id);
        if (index == null) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < employeeCount - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[employeeCount - 1] = null;
        employeeCount--;
        attendance.remove(id);
        rebuildEmployeeIndex();
        System.out.println("Employee deleted successfully.");
    }

    private static void rebuildEmployeeIndex() {
        employeeIndex.clear();
        for (int i = 0; i < employeeCount; i++) {
            employeeIndex.put(employees[i].id, i);
        }
    }
}
