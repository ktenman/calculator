package ee.tenman.calculator;

import ee.tenman.calculator.command.AddCommand;
import ee.tenman.calculator.command.DivideCommand;
import ee.tenman.calculator.command.MultiplyCommand;
import ee.tenman.calculator.command.SubtractCommand;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator implements Operation {

    private BigDecimal currentResult = BigDecimal.ZERO;

    public Calculator withInitialValue(BigDecimal initialValue) {
        this.currentResult = initialValue;
        return this;
    }

    public BigDecimal getCurrentResult() {
        return currentResult;
    }

    public void updateCurrentResult(BigDecimal currentResult) {
        this.currentResult = currentResult;
    }

    @Override
    public BigDecimal calculate(AddCommand addCommand) {
        return addCommand.getFirstNumber().add(addCommand.getSecondNumber());
    }

    @Override
    public BigDecimal calculate(MultiplyCommand multiplyCommand) {
        return multiplyCommand.getFirstNumber().multiply(multiplyCommand.getSecondNumber());
    }

    @Override
    public BigDecimal calculate(SubtractCommand subtractCommand) {
        return subtractCommand.getFirstNumber().subtract(subtractCommand.getSecondNumber());
    }

    @Override
    public BigDecimal calculate(DivideCommand divideCommand) {
        return divideCommand.getFirstNumber().divide(divideCommand.getSecondNumber(), RoundingMode.HALF_UP);
    }
}
