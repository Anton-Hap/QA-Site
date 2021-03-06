package modelspackage;

import framework.utilpackage.manager.TestDataManager;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;

    public User(String id) {
        setUser(TestDataManager.getFirstNameByNumber(id), TestDataManager.getLastNameByNumber(id),
                TestDataManager.getEmailByNumber(id), TestDataManager.getAgeByNumber(id), TestDataManager.getSalaryByNumber(id), TestDataManager.getDepartmentByNumber(id));
    }

    private void setUser(String firstName, String lastName, String email, String age, String salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
