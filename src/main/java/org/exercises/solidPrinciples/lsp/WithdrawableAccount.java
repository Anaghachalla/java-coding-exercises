package org.exercises.solidPrinciples.lsp;

public interface WithdrawableAccount extends DepositOnlyAccount {
    void withdraw(int balance);
}
