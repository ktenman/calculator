package ee.tenman.calculator;

import ee.tenman.calculator.command.AddCommand;
import ee.tenman.calculator.command.DivideCommand;
import ee.tenman.calculator.command.MultiplyCommand;
import ee.tenman.calculator.command.SubtractCommand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static ee.tenman.calculator.command.Operator.ADD;
import static ee.tenman.calculator.command.Operator.DIVIDE;
import static ee.tenman.calculator.command.Operator.MULTIPLY;
import static ee.tenman.calculator.command.Operator.SUBTRACT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

class CalculationServiceTest {

    CalculationService calculationService = new CalculationService();

    @TestInstance(PER_CLASS)
    @Nested
    class Calculate {

        Stream<Arguments> dataProvider() {
            return Stream.of(
                    Arguments.of(List.of("subtract 8", "divide 2", "add 2", "multiply 10", "apply 5000"), "24980"),
                    Arguments.of(List.of("apply 21"), "21"),
                    Arguments.of(List.of("add 2", "add 2", "apply 21"), "25")
            );
        }

        @ParameterizedTest
        @MethodSource(value = "dataProvider")
        void testCalculation(List<String> lines, BigDecimal expectedResult) {

            BigDecimal calculatedResult = calculationService.calculate(lines);

            assertThat(calculatedResult).isEqualByComparingTo(expectedResult);
        }
    }

    @Nested
    class InitializeCalculator {

        @Test
        void successfullyInitializeCalculator() {
            List<String> lines = List.of("multiply 9", "apply 5");

            Calculator calculator = calculationService.initializeCalculator(lines);

            assertThat(calculator.getCurrentResult()).isEqualByComparingTo(BigDecimal.valueOf(5));
        }

        @Test
        void throwExceptionIfLessThanOneLine() {
            List<String> lines = Collections.emptyList();

            Throwable thrown = catchThrowable(() -> calculationService.initializeCalculator(lines));

            assertThat(thrown).isInstanceOf(CalculatorApplicationException.class)
                    .hasMessage("At least one line required.");
        }

        @Test
        void throwExceptionIfApplyIsMissing() {
            List<String> lines = List.of("multiply 9");

            Throwable thrown = catchThrowable(() -> calculationService.initializeCalculator(lines));

            assertThat(thrown).isInstanceOf(CalculatorApplicationException.class)
                    .hasMessage("Last line should contain 'apply'.");
        }
    }
}