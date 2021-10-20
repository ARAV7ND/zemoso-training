import Interfaces.IDepartment;

public class HumanResource implements IDepartment {
    @Override
    public String getDepartmentDetails() {
        return "Human Resouces";
    }
}
