package ee.tenman.calculator.command;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CommandBuilderTest {

    @Test
    void build() {
        Command command = new CommandBuilder()
                .withFirstNumber(BigDecimal.valueOf(11.223))
                .withOperation(Operator.ADD)
                .withSecondNumber(BigDecimal.valueOf(16.77))
                .build();

        assertThat(command).isInstanceOf(AddCommand.class)
                .extracting(Command::getFirstNumber, Command::getSecondNumber)
                .contains(BigDecimal.valueOf(11.223), BigDecimal.valueOf(16.77));
    }
}