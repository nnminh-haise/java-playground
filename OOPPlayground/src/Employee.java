import java.time.LocalDate;

public class Employee extends Human {
    private double salary;
    protected LocalDate hireDate;

    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        this.hireDate = LocalDate.of(year, month, day);
    }

    public String getDescription() {
        return "I'm an employee!";
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public LocalDate getHireDate() {
        return this.hireDate;
    }

    public String toString() {
        return "Hired date: " + this.hireDate + " | Name: " + super.getName() + " | Salary: " + this.salary;
    }
}