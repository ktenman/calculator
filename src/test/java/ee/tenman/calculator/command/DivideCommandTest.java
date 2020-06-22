package ee.tenman.calculator.command;

import ee.tenman.calculator.Calculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class DivideCommandTest {

    Command divideCommand = new DivideCommand()
            .withFirstNumber(BigDecimal.valueOf(21))
            .withSecondNumber(BigDecimal.valueOf(7));

    @Test
    void calculate() {
        Calculator calculator = new Calculator();

        BigDecimal result = divideCommand.calculate(calculator);

        assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(3));
    }

    @Test
    void testToString() {
        String toString = divideCommand.toString();

        assertThat(toString).isEqualTo("21 / 7");
    }
}