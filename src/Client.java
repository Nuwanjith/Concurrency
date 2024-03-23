public class Client implements Runnable {

    private Bank bank;
    private int accountNumber;

    public Client(Bank bank, int accountNumber) {
        this.bank = bank;
        this.accountNumber = accountNumber;
    }

    @Override
    public void run() {
        BankAccount account = bank.getAccount(accountNumber);

        if (account != null) {
            // Simulate transactions (deposit, withdrawal, balance check)
            account.deposit(100);
            account.withdraw(50);
            System.out.println("Balance for account " + accountNumber + ": " + account.getBalance());
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }
}