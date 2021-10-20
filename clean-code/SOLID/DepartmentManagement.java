import Interfaces.IDepartment;
//high level model
public class DepartmentManagement {


//    violation of dependency inversion
//    private HumanResource department;
//    public DepartmentManagement(HumanResource department) {
//        this.department = department;
//    }

    private IDepartment department;
    public  DepartmentManagement(IDepartment department){
        this.department = department;
    }

    public String getDepartment(){
        return department.getDepartmentDetails();
    }
}
