import Interfaces.IDepartment;
import Interfaces.IEmployee;

import java.util.*;

public class Main {
    static Map<Integer, IDepartment> departmentMap = new HashMap<>();
    static List<IEmployee> employeeList = new ArrayList<>();

    public static void displayEmployeeTypes(){
        System.out.println("1.Permanent Employee\n2.Temporary Employee\n3.Contract Based Employee");
    }

    public static void displayDepartmentTypes(){
        System.out.println("1.Finance\n2.Human Resource\n3.Development");
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Employees : ");
        int noOfEmployees = scanner.nextInt();
        while (noOfEmployees-- > 0) {
            System.out.println("Enter Employee Id : ");
            int employeeId = scanner.nextInt();
            System.out.println("Enter Employee " + employeeId + " Name :");
            String employeeName = scanner.next();
            System.out.println("Enter Minimum salary :");
            double employeeSalary = scanner.nextDouble();
            System.out.println("Choose the option from below : ");
            System.out.println("-------------------------------");
            displayEmployeeTypes();
            int option = scanner.nextInt();
            while (option != 1 && option != 2 && option != 3) {
                System.out.println("Please choose the correct option :");
                System.out.println("---------------------------------");
                displayEmployeeTypes();
                option = scanner.nextInt();
            }
            switch (option) {
                case 1 :
                    employeeList.add(new PermanentEmployee(employeeId,employeeName,employeeSalary));
                    break;
                case 2:
                    employeeList.add(new TemporaryEmployee(employeeId,employeeName,employeeSalary));
                    break;
                case 3:
                    employeeList.add(new ContractBasedEmployee(employeeId,employeeName,employeeSalary));
                    break;
            }

            System.out.println("choose the Department from below");
            System.out.println("---------------------------------");
            displayDepartmentTypes();
            int departmentOption = scanner.nextInt();
            while (departmentOption != 1 && departmentOption != 2 && departmentOption != 3) {
                System.out.println("Please choose the correct option from below");
                departmentOption = scanner.nextInt();
            }
            switch (departmentOption) {
                case 1:
                    departmentMap.put(employeeId, new Finance());
                    break;
                case 2:
                    departmentMap.put(employeeId, new HumanResource());
                    break;
                case 3:
                    departmentMap.put(employeeId, new Development());
                    break;
            }
        }
    }

    public static void displayEmployeeList(){
        for(var employee : employeeList){
            if(employee instanceof Employee){
                Employee emp = (Employee)employee;
                System.out.println("Employee Id : "+emp.employeeId+", Employee Name : "+emp.employeeName
                        +", Department : "+departmentMap.get(emp.employeeId).getDepartmentDetails()+", Minimum salary : "+emp.getMinimumSalary()+", Bonus : "+emp.getBonus());
            }else{
                ContractBasedEmployee emp = (ContractBasedEmployee)employee;
                System.out.println("Employee Id : "+emp.employeeId+", Employee Name : "+emp.employeeName
                        +", Department : "+departmentMap.get(emp.employeeId).getDepartmentDetails()+", Minimum salary : "+emp.getMinimumSalary());
            }
        }
    }

    public static void main(String[] args) {
        getInput();
        displayEmployeeList();
    }
}
// logger SLF4J
