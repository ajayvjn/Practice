package mongo;

import java.util.List;

/**
 * Created by ajay on 14-Jun-17.
 */
public class Person {
    String first_name;
    String middle_name;
    String last_name;
    int emp_number;

    List<Account> accounts;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int getEmp_number() {
        return emp_number;
    }

    public void setEmp_number(int emp_number) {
        this.emp_number = emp_number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", emp_number=" + emp_number +
                ", accounts=" + accounts +
                '}';
    }
}
