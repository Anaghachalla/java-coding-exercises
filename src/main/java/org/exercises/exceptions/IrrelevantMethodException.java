package org.exercises.exceptions;

public class IrrelevantMethodException extends RuntimeException{
    @Override
    public String toString() {
        return "Method irrelevant to class";
    }

}
