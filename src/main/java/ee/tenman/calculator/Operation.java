package ee.tenman.calculator;

import ee.tenman.calculator.command.AddCommand;
import ee.tenman.calculator.command.DivideCommand;
import ee.tenman.calculator.command.MultiplyCommand;
import ee.tenman.calculator.command.SubtractCommand;

import java.math.BigDecimal;

public interface Operation {
    BigDecimal calculate(AddCommand addCommand);
    BigDecimal calculate(MultiplyCommand multiplyCommand);
    BigDecimal calculate(SubtractCommand subtractCommand);
    BigDecimal calculate(DivideCommand divideCommand);

    interface Executor {
        BigDecimal calculate(Operation operation);
    }
}
