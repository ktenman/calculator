package ee.tenman.calculator.command;

import java.math.BigDecimal;

public class CommandBuilder {
    private BigDecimal firstNumber;
    private BigDecimal secondNumber;
    private Operator operator;

    public CommandBuilder withFirstNumber(BigDecimal firstNumber) {
        this.firstNumber = firstNumber;
        return this;
    }

    public CommandBuilder withSecondNumber(BigDecimal secondNumber) {
        this.secondNumber = secondNumber;
        return this;
    }

    public CommandBuilder withOperation(Operator operator) {
        this.operator = operator;
        return this;
    }

    public Command build() {
        return this.operator.getCommand()
                .withFirstNumber(this.firstNumber)
                .withSecondNumber(this.secondNumber);
    }

}
