package ExTentor.ExTenta2017;

import java.util.Optional;

public class up3 {
    
}

interface Company {
    public Optional<Department> getDepartment(String code);
}

interface Department {
    public Optional<Employee> getEmployee(int id);

}

interface Employee {
    public String getName();

}

class FindName {

    public String findName(Company company, String deptCode, int empCode) {
        return company.getDepartment(deptCode) //Optional<Department>
                        .flatMap(d -> d.getEmployee(empCode)) //Optional<Employee>
                        .map(o -> o.getName().orElse("Not Found"));
}