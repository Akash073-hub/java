public class program1 {
    static class BankAccount {
        private int balance = 1000;
        public int getBalance() {
            return balance;
        }
        public synchronized void withdraw(int amount) {
            String threadName = Thread.currentThread().getName();
            if (balance >= amount) {
                try {
                    System.out.println(threadName + " is checking balance: $" + balance);
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                balance -= amount;
                System.out.println(threadName + " successfully withdrew $" + amount + ". New Balance: $" + balance);
            } else {
                System.out.println(threadName + " failed to withdraw $" + amount + ". Insufficient balance ($" + balance + ").");
            }
        }
    }
    static class WithdrawalTask implements Runnable {
        private BankAccount account;
        private int amount;
        public WithdrawalTask(BankAccount account, int amount) {
            this.account = account;
            this.amount = amount;
        }
        @Override
        public void run() {
            account.withdraw(this.amount);
        }
    }

    public static void main(String[] args) {

        BankAccount sharedAccount = new BankAccount();
        System.out.println("Initial Account Balance: $" + sharedAccount.getBalance());
        System.out.println("----------------------------------------");
        WithdrawalTask person1Task = new WithdrawalTask(sharedAccount, 600);
        Thread threadA = new Thread(person1Task, "Person_A");
        WithdrawalTask person2Task = new WithdrawalTask(sharedAccount, 500);
        Thread threadB = new Thread(person2Task, "Person_B");
        threadA.start();
        threadB.start();
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted.");
        }

        System.out.println("----------------------------------------");
        System.out.println("Final Account Balance: $" + sharedAccount.getBalance());
        if (sharedAccount.getBalance() >= 0) {
            System.out.println("Result: Synchronization successful, balance is safe.");
        } else {
            System.out.println("Result: ERROR! Synchronization failed, balance is negative.");
        }
    }
}
