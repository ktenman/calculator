package ee.tenman.calculator.command;

import ee.tenman.calculator.Operation.Executor;

import java.math.BigDecimal;

public abstract class Command implements Executor {
    private BigDecimal firstNumber;
    private BigDecimal secondNumber;

    public Command withFirstNumber(BigDecimal number) {
        this.firstNumber = number;
        return this;
    }

    public Command withSecondNumber(BigDecimal number) {
        this.secondNumber = number;
        return this;
    }

    public BigDecimal getFirstNumber() {
        return firstNumber;
    }

    public BigDecimal getSecondNumber() {
        return secondNumber;
    }

}
