package org.exercises.exceptions;

public class CannotWithdraw extends RuntimeException {
    @Override
    public String toString() {
        return "Cannot withdraw from Fixed Deposit Account";
    }
}
