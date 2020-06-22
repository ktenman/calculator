package ee.tenman.calculator.command;

import ee.tenman.calculator.Operation;

import java.math.BigDecimal;

import static ee.tenman.calculator.command.Operator.SUBTRACT;
public class SubtractCommand extends Command {
    @Override
    public BigDecimal calculate(Operation operation) {
        return operation.calculate(this);
    }

    @Override
    public String toString() {
        return getFirstNumber() + " " + SUBTRACT.getOperatorSymbol() + " " + getSecondNumber();
    }
}
