package DBpractise.DBModels;

import lombok.Data;
import lombok.NoArgsConstructor;
import utilities1.DBUtil.DBUtilV2;

import java.util.List;

@Data
@NoArgsConstructor
public class Employee {

    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String email;
    private final static String queryToGetByNumber = "Select employeeNumber, lastName, firstName, email FROM employees where employeeNumber = ?;";
    private final static String queryAll = "Select employeeNumber, lastName, firstName, email FROM employees;";
    private static String qGetEmployeeLastName = "SELECT * FROM employees WHERE lastName = ?;";
    private static String getAllEmployeesNumbers = "SELECT employeeNumber FROM employees;";

    public static List<Employee> getEmployeeNumbers() {
       return DBUtilV2.query(getAllEmployeesNumbers,Employee.class);

    }

    public static List<Employee> getAll() {
        return DBUtilV2.query(queryAll, Employee.class);
    }

    public static Employee getById(int id) {
        List<Employee> employeeList = DBUtilV2.query(queryToGetByNumber, Employee.class, id);
        if (employeeList.isEmpty()) return null;
        else return employeeList.get(0);
    }

    public static Employee getByLastName(String name) {
        List<Employee> employeeList = DBUtilV2.query(qGetEmployeeLastName, Employee.class, name);
        if (employeeList.isEmpty())
            return null;
        else return employeeList.get(0);
    }

    //    public Employee(ResultSet rs) throws SQLException {
//        this.employeeNumber = rs.getInt("employeeNumber");
//        this.lastName = rs.getString("lastName");
//        //...
//    }

//    public static List<Employee> generateAll(ResultSet resultSet) throws SQLException {
//        List<Employee> ls = new ArrayList<>();
//        while (resultSet.next()) {
//            ls.add(new Employee(resultSet));
//        }
//        return ls;
//    }


}
