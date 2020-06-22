package ee.tenman.calculator.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ee.tenman.calculator.command.Operator.ADD;
import static ee.tenman.calculator.command.Operator.APPLY;
import static ee.tenman.calculator.command.Operator.DIVIDE;
import static ee.tenman.calculator.command.Operator.MULTIPLY;
import static ee.tenman.calculator.command.Operator.SUBTRACT;
import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(ADD, new AddCommand()),
                Arguments.of(MULTIPLY, new MultiplyCommand()),
                Arguments.of(DIVIDE, new DivideCommand()),
                Arguments.of(SUBTRACT, new SubtractCommand())
        );
    }

    @ParameterizedTest
    @MethodSource(value = "dataProvider")
    void getCommand(Operator operator, Command expectedCommand) {
        assertThat(operator.getCommand()).isInstanceOf(expectedCommand.getClass());
    }

    @Test
    void getCommandForApply() {
        assertThat(APPLY.getCommand()).isNull();
    }
}