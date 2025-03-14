import java.util.*;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName) {
        Employee employee = new Employee(employeeName);
        employees.add(employee);
    }

    public void listEmployees() {
        System.out.println("Employees in " + name + " department:");
        for (Employee emp : employees) {
            System.out.println(" - " + emp.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void clearEmployees() {
        employees.clear();
    }
}

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        Department department = new Department(departmentName);
        departments.add(department);
    }

    public Department getDepartment(String departmentName) {
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) {
                return dept;
            }
        }
        return null;
    }

    public void listDepartments() {
        System.out.println("Departments in " + name + ":");
        for (Department dept : departments) {
            System.out.println(" - " + dept.getName());
        }
    }

    public void deleteCompany() {
        System.out.println("Deleting company '" + name + "' and all its departments and employees...");
        for (Department dept : departments) {
            dept.clearEmployees();
        }
        departments.clear();
    }
}

public class CompanyAndDepartments {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        company.addDepartment("Development");
        company.addDepartment("Human Resources");

        Department devDepartment = company.getDepartment("Development");
        Department hrDepartment = company.getDepartment("Human Resources");

        if (devDepartment != null) {
        devDepartment.addEmployee("Alice");
        devDepartment.addEmployee("Bob");
    }

        if (hrDepartment != null) {
        hrDepartment.addEmployee("Charlie");
    }

        company.listDepartments();

        if (devDepartment != null) devDepartment.listEmployees();
        if (hrDepartment != null) hrDepartment.listEmployees();

    // Deleting the company
        company.deleteCompany();
}
}
