package lr2;

public class BankAccount implements BankAccountOperations {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Пополнение на " + amount + ". Новый баланс: " + balance);
        } else {
            System.out.println("Сумма пополнения должна быть положительной");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Сумма снятия должна быть положительной");
        } else if (amount > balance) {
            System.out.println("Недостаточно средств. Текущий баланс: " + balance);
        } else {
            balance -= amount;
            System.out.println("Снятие " + amount + ". Новый баланс: " + balance);
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
