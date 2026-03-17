package lr2;

public class Task7BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("40817810000000000001", 1000.0);

        System.out.println("Счет: " + account.getAccountNumber());
        System.out.println("Начальный баланс: " + account.getBalance());

        account.deposit(500.0);
        account.withdraw(300.0);
        account.withdraw(1500.0); // пример недостатка средств

        System.out.println("Итоговый баланс: " + account.getBalance());
    }
}
