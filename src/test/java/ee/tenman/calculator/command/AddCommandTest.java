package ee.tenman.calculator.command;

import ee.tenman.calculator.Calculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static org.assertj.core.api.Assertions.assertThat;

class AddCommandTest {

    Command addCommand = new AddCommand().withFirstNumber(ONE).withSecondNumber(TEN);

    @Test
    void calculate() {
        Calculator calculator = new Calculator();

        BigDecimal result = addCommand.calculate(calculator);

        assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(11));
    }

    @Test
    void testToString() {
        String toString = addCommand.toString();

        assertThat(toString).isEqualTo("1 + 10");
    }
}