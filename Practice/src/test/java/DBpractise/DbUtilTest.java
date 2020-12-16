package DBpractise;

import DBpractise.DBModels.CustEmployee;
import DBpractise.DBModels.Employee;
import DBpractise.DBModels.OrderDetails;
import DBpractise.DBModels.Product;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities1.DBUtil.DBUtil;
import utilities1.DBUtil.DBUtilV2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class DbUtilTest {
    @BeforeClass
    public static void setUp() {
        DBUtil.openConnection();
    }

    @AfterClass
    public static void tearDown() {
        DBUtil.closeConnection();
    }

    static String queryToGetEmpAnTheirCust = "" +
            "SELECT T1.firstName, T1.lastName, T2.customerName\n" +
            "FROM employees T1\n" +
            "LEFT JOIN customers T2 \n" +
            "ON employeeNumber = salesRepEmployeeNumber\n" +
            "WHERE T2.customerName = ?;";

    static String queryEmployee = "Select * FROM employees WHERE employeeNumber = ?" ;
    static String q = "Select * FROM employees WHERE employeeNumber = 1002";
    static String qToGetNumOfEmployees = "SELECT count(*) AS num FROM employees;";
    static String qToGetEmpId = "SELECT employeeNumber FROM employees WHERE lastName = ? AND firstName = ?;";
    static String qGetEmployeeID = "SELECT employeeNumber FROM employees WHERE lastName = ? AND firstName = ?;";
    static String qGetEmployeeLastName = "SELECT * FROM employees WHERE lastName = ?;";
    static String qGetEmployeeFirstName = "SELECT * FROM employees WHERE firstName = ?;";
    static String qToGetEmployees = "SELECT employeeNumber, lastName, firstName, email FROM employees;";
    static String qLargestPayment = "SELECT *\n" +
            "FROM customers\n" +
            "WHERE customerNumber = \n" +
            "(\n" +
            "SELECT customerNumber \n" +
            "FROM payments \n" +
            "WHERE amount = \n" +
            "(\n" +
            "SELECT MAX(amount)\n" +
            "FROM payments\n" +
            ")\n" +
            ");";

    @Test
    public void test1() {
        long expectedNumberOfEmployees = 23;
        long actualNumberOfEmployees = (Long) DBUtil.query(qToGetNumOfEmployees).get(0).get("num");
        Assert.assertTrue("Number of employees is wrong", Objects.equals(expectedNumberOfEmployees, actualNumberOfEmployees));
    }

    @Test
    public void test2() {
        int empNumExpected = 1002;
        int empNumActual = (Integer) DBUtil.queryWithParam(qToGetEmpId,  "Murphy", "Diane").get(0).get("employeeNumber");
        Assert.assertEquals("ID doesn't match", empNumExpected, empNumActual);
    }
    @Test
    public void test3(){

        List<Employee> employees = DBUtilV2.query(qToGetEmployees, Employee.class);

        for (Employee e : employees) {
            System.out.println(e);
        }

//        int expectedEmployeeLastName = 1611;
//        int actualEmployeeLastName = (Integer) DBUtil.queryWithParam(qGetEmployeeID,"Fixter","Andy").get(0).get("employeeNumber");
//        Assert.assertEquals("",expectedEmployeeLastName,actualEmployeeLastName);

    }
    @Test
    public void test4(){
        String expectedLastName= "Fixter";
        String actualLastName = (String) DBUtil.queryWithParam(qGetEmployeeLastName,"Fixter").get(0).get("lastName");
        Assert.assertEquals(expectedLastName,actualLastName);

    } @Test
    public void test5(){
        String expectedFirstName= "Andy";
        String actualFirstName = (String) DBUtil.queryWithParam(qGetEmployeeFirstName,"Andy").get(0).get("firstName");
        Assert.assertEquals(expectedFirstName,actualFirstName);
    }

    @Test
    public void test(){
        double expectedCreditLimit = 227600.00;
        double actualCreditLimit = (double) DBUtil.queryWithParam(qLargestPayment).get(0).get("creditLimit");
        Assert.assertEquals(expectedCreditLimit, actualCreditLimit, 0.0);
        System.out.println(DBUtil.queryWithParam(qLargestPayment).get(0).get("creditLimit"));

    }

    @Test
    public void test6() {
        //We deleted a specific Employee with id 1338 through UI
        Assert.assertTrue(Employee.getById(1338) == null);
    }

    @Test
    public void test7() {
        Assert.assertTrue(Employee.getByLastName("Andy") == null);
    }

    @Test
    public void test8() {
       Employee.getAll().forEach(System.out::println);

    }
    @Test
    public void test9() {
        Employee.getEmployeeNumbers().forEach(System.out::println);
    }

    @Test
    public void test10() {
        OrderDetails.getAll().forEach(System.out::println);
    }

    @Test
    public void test11() {
        OrderDetails.getBy("customerName", "Toms Spezialitäten, Ltd").forEach(System.out::println);
    }

    @Test
    public void test12() {
        // was created by other steps (Data table for UI or retrieved using API)
        // Created from API or DataTable
        CustEmployee fromUI = new CustEmployee("Alpha Cognac", "Gerard", "Hernandez");
        CustEmployee fromDB = CustEmployee.getByCustomerName(fromUI.getCustName()).get(0);
        Assert.assertTrue(fromDB != null);
        Assert.assertEquals("Objects are not equal!", fromUI, fromDB);
    }
    @Test
    public void prodTest() {

        Product.getAll().forEach(System.out::println);
//        List<Product> products = Product.getAll();
//        for (Product p : products) {
//            System.out.println(p);
//        }
    }

    @Test
    public void prodById1() {
        Product p1 = Product.getByIdFormApi("101");
        Product p2 = Product.getById("101");
        Assert.assertEquals(p1, p2);
    }

    @Test
    public void prodById2() {
        Product p1 = Product.getByIdFormApi("102");
        Product p2 = Product.getById("102");
        Assert.assertEquals(p1, p2);


    }

    @Test
    public void custEmployee(){
        CustEmployee.getAll().forEach(System.out::println);
    }




    //    @Test
//    public void productsByProdLine(String prodLIne) {
//        List<Product> motorcycles = Product.getByProdLine(prodLIne);
//        WebDriver driver = new ChromeDriver();
//        LoginPage.login("user", "password");
//        LoginPage.goProductsPage();
//        LoginPage.search(prodLIne);
//
//        List<WebElement> motorcyclesNames = driver.findElements(By.cssSelector(".h6.cmp-bike-cards__title"));
//        for (Product motorcycle : motorcycles) {
//            if (motorcyclesNames.contains(motorcycle.getProd_name()))
//                motorcycles.remove(motorcycle);
//        }
//        Assert.assertTrue("Products not listed IN UI:" + motorcycles, motorcycles.isEmpty());
//    }
//
//    @Test
//    public void validateMOtorcycles() {
//        validateProductExistsInUiByProdLine("Motorcycle");
//    }
//
//    @Test
//    public void validatePlanes() {
//        validateProductExistsInUiByProdLine("Planes");
//    }
//
//    @Test
//    public void validateShips() {
//        validateProductExistsInUiByProdLine("Ships");
//    }

//    private void validateProductExistsInUiByProdLine(String prodLine) {
//            List<Product> motorcycles = Product.getByProdLine(prodLIne);
//            WebDriver driver = new ChromeDriver();
//            LoginPage.login("user", "password");
//            LoginPage.goProductsPage();
//            LoginPage.search(prodLIne);
//
//            List<WebElement> motorcyclesNames = driver.findElements(By.cssSelector(".h6.cmp-bike-cards__title"));
//            for (Product motorcycle : motorcycles) {
//                if (motorcyclesNames.contains(motorcycle.getProd_name()))
//                    motorcycles.remove(motorcycle);
//            }
//            Assert.assertTrue("Products not listed IN UI:" + motorcycles, motorcycles.isEmpty());
//        }

}
