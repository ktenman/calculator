package ee.tenman.calculator.command;

import ee.tenman.calculator.Calculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyCommandTest {

    Command multiplyCommand = new MultiplyCommand()
            .withFirstNumber(BigDecimal.valueOf(8))
            .withSecondNumber(BigDecimal.valueOf(7));

    @Test
    void calculate() {
        Calculator calculator = new Calculator();

        BigDecimal result = multiplyCommand.calculate(calculator);

        assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(56));
    }

    @Test
    void testToString() {
        String toString = multiplyCommand.toString();

        assertThat(toString).isEqualTo("8 * 7");
    }
}