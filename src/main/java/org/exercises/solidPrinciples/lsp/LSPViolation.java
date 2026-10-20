package org.exercises.solidPrinciples.lsp;

import lombok.*;
import org.exercises.exceptions.CannotWithdraw;

import java.util.ArrayList;
import java.util.List;

public class LSPViolation {
    private interface Account {
        void deposit(int amount);
        void withdraw(int amount);
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    private class SalaryAccount implements Account{
        int balance;

        @Override
        public void withdraw(int amount) {
            balance-=amount;
            IO.println("Withdrawing amount...");
        }

        @Override
        public void deposit(int amount) {
            balance+=amount;
            IO.println("Depositing amount...");
        }
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    private class SavingsAccount implements Account{
        int balance;

        @Override
        public void withdraw(int amount) {
            balance-=amount;
            IO.println("Withdrawing amount...");
        }

        @Override
        public void deposit(int amount) {
            balance+=amount;
            IO.println("Depositing amount...");
        }
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    private class FixedDepositAccount implements Account{
        int balance;

        @Override
        public void withdraw(int amount) {
            //makes withdraw method from parent un-usable, hence narrowing down parent's features - LSP violation
            throw new CannotWithdraw();
        }

        @Override
        public void deposit(int amount) {
            balance+=amount;
            IO.println("Depositing amount...");
        }
    }

    @Getter
    @Setter
    @ToString
    private class Client {
        List<Account> accounts;

        Client() {
            this.accounts = new ArrayList<>();
        }
        void addAccount(Account account) {
            accounts.add(account);
        }

        void processTransactions() {
            for(Account account: accounts) {
                //adding such logic to client makes it tightly coupled with the account types - breaks OCP
                account.deposit(100);
                try {
                    account.withdraw(20); //client should only interact with the interface and is unaware of different account types and their properties
                } catch (CannotWithdraw cw) {
                    IO.println("Cannot withdraw from account");
                }
            }
        }
    }

    void main() {
        Client client = new Client();

        client.addAccount(new SalaryAccount());
        client.addAccount(new FixedDepositAccount());

        client.processTransactions();
    }
}
