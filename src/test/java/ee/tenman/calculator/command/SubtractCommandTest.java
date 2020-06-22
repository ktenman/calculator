package ee.tenman.calculator.command;

import ee.tenman.calculator.Calculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractCommandTest {

    Command subtractCommand = new SubtractCommand()
            .withFirstNumber(BigDecimal.valueOf(91.371))
            .withSecondNumber(BigDecimal.valueOf(7.547));

    @Test
    void calculate() {
        Calculator calculator = new Calculator();

        BigDecimal result = subtractCommand.calculate(calculator);

        assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(83.824));
    }

    @Test
    void testToString() {
        String toString = subtractCommand.toString();

        assertThat(toString).isEqualTo("91.371 - 7.547");
    }
}