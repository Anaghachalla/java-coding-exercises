package org.exercises.solidPrinciples.lsp;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FixedDepositAccount implements DepositOnlyAccount {
    int balance;

    @Override
    public void deposit(int amount) {
        balance+=amount;
        IO.println("Depositing amount...");
    }
}
