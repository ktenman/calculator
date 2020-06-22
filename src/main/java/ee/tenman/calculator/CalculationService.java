package ee.tenman.calculator;

import ee.tenman.calculator.command.Command;
import ee.tenman.calculator.command.CommandBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import static ee.tenman.calculator.command.Operator.APPLY;

public class CalculationService {

    private static final Logger LOG = Logger.getLogger(CalculationService.class.getName());
    private static final int MINIMUM_LENGTH_OF_INPUT_FILE = 1;

    BigDecimal calculate(List<String> lines) {
        Calculator calculator = initializeCalculator(lines);

        lines.subList(0, lines.size() - 1).stream()
                .map(Line::new)
                .map(line -> {
                    Command command = new CommandBuilder()
                            .withFirstNumber(calculator.getCurrentResult())
                            .withOperation(line.getOperator())
                            .withSecondNumber(line.getNumber())
                            .build();
                    BigDecimal currentResult = command.calculate(calculator);
                    calculator.updateCurrentResult(currentResult);
                    return command + " = " + currentResult;
                })
                .forEach(LOG::info);

        return calculator.getCurrentResult();
    }

    Calculator initializeCalculator(List<String> lines) {
        if (lines.size() < MINIMUM_LENGTH_OF_INPUT_FILE) {
            throw new CalculatorApplicationException("At least one line required.");
        }
        int lastRowIndex = lines.size() - 1;
        Line lastLine = new Line(lines.get(lastRowIndex));
        if (lastLine.getOperator() != APPLY) {
            throw new CalculatorApplicationException("Last line should contain 'apply'.");
        }
        return new Calculator().withInitialValue(lastLine.getNumber());
    }
}
