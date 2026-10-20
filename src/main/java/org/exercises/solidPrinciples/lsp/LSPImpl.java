package org.exercises.solidPrinciples.lsp;

public class LSPImpl {
    void main() {
        Client client = new Client();
        client.addWithdrawableAccount(new SalaryAccount());
        client.addWithdrawableAccount(new SavingsAccount());
        client.addDepositOnlyAccount(new FixedDepositAccount());

        client.processTransactions();
    }
}
