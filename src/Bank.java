import java.util.Map;
import java.util.HashMap;
public class Bank {

    private Map<Integer, BankAccount> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public synchronized void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public synchronized BankAccount getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public synchronized boolean deposit(int accountNumber, double amount) {
      // Implement logic to check if account exists (use getAccount)
      BankAccount account = getAccount(accountNumber);
      if (account != null) {
          account.deposit(amount); // Delegate to the BankAccount for actual deposit logic
          return true;
      } else {
          return false; // Account not found
      }
  }

  public synchronized boolean withdraw(int accountNumber, double amount) {
    // Existing logic for account existence and balance check
    BankAccount account = getAccount(accountNumber);
    if (account != null && hasSufficientBalance(accountNumber, amount)) {
        account.withdraw(amount); // Delegate to the BankAccount for actual withdrawal logic
        return true;
    } else {
        return false;
    }
}

      
private synchronized boolean accountExists(int accountNumber) {
  return getAccount(accountNumber) != null; // Check if getAccount returns a valid account
}
      
      private synchronized boolean hasSufficientBalance(int accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            return account.getBalance() >= amount; // Check if balance is sufficient
        } else {
            return false; // Account not found
        }
    }
      
      private void debitBalance(int accountNumber, double amount) {
        // Implement logic to debit the account balance
      }
      

}