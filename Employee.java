public class Employee extends Person {

    private double salary;
    private String job;

    public Employee(int id, String name, double salary, String job) {
        super(id, name);
        this.salary = salary;
        this.job = job;
    }

    public double getSalary() { return salary; }
    public String getJob() { return job; }

    public void setSalary(double salary) { this.salary = salary; }
    public void setJob(String job) { this.job = job; }

    @Override
    public void printDetails() {
        System.out.println(id + " | " + name + " | " + job + " | $" + salary);
    }
}