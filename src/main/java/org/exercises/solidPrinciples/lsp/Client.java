package org.exercises.solidPrinciples.lsp;

import lombok.*;
import org.exercises.exceptions.CannotWithdraw;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
class Client {
    List<DepositOnlyAccount> depositOnlyAccounts;
    List<WithdrawableAccount> withdrawableAccounts;

    Client() {
        this.depositOnlyAccounts = new ArrayList<>();
        this.withdrawableAccounts = new ArrayList<>();
    }
    public void addDepositOnlyAccount(DepositOnlyAccount account) {
        depositOnlyAccounts.add(account);
    }

    public void addWithdrawableAccount(WithdrawableAccount account) {
        withdrawableAccounts.add(account);
    }

    public void processTransactions() {
        for(DepositOnlyAccount account: depositOnlyAccounts) {
            account.deposit(100);
        }

        for(WithdrawableAccount account: withdrawableAccounts) {
            account.deposit(100);
            account.withdraw(20);
        }
    }
}