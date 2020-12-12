package domains;

import com.github.javafaker.Faker;

public class testClass {
    Faker faker = new Faker();
     String em = faker.internet().emailAddress();
    String na = faker.name().firstName();
    String pass = faker.internet().password();

    public String email = em;
    public String name = na;
    public String password = pass;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
