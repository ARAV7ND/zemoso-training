public class PermanentEmployee extends Employee{
    public PermanentEmployee(int employeeId, String employeeName, double minSalary) {
        super(employeeId, employeeName, minSalary);
    }
    public double getMinimumSalary(){
        return super.minSalary;
    }
    public double getBonus(){
        return super.minSalary * 0.05;
    }
}

