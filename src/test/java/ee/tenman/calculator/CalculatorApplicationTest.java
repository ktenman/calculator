package ee.tenman.calculator;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CalculatorApplicationTest {

    @Test
    void throwExceptionWhenFileNamePathMissing() throws IOException {

        Throwable thrown = catchThrowable(CalculatorApplication::new);

        assertThat(thrown).isInstanceOf(CalculatorApplicationException.class)
                .hasMessage("Please insert file name path.");
    }

    @Test
    void testCalculatorWithFile() throws IOException {

        CalculatorApplication calculatorApplication = new CalculatorApplication("input.txt");

        assertThat(calculatorApplication.getCalculatedResult()).isEqualByComparingTo(BigDecimal.valueOf(15));
    }
}