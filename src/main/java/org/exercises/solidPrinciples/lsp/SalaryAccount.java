package org.exercises.solidPrinciples.lsp;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SalaryAccount implements WithdrawableAccount{
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
