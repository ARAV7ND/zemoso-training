import Interfaces.IDepartment;

public class Development implements IDepartment {
    @Override
    public String getDepartmentDetails() {
        return "Development";
    }
}
