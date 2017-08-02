package mongo;

/**
 * Created by ajay on 14-Jun-17.
 */
public class Account {
    String account_type;
    long balance;
    String currency;

    public Account(String account_type, long balance, String currency){
        this.account_type  = account_type;
        this.balance = balance;
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_type='" + account_type + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
