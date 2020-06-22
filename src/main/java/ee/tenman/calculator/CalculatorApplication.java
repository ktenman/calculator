package ee.tenman.calculator;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CalculatorApplication {

    private static final Logger LOG = Logger.getLogger(CalculatorApplication.class.getName());
    private BigDecimal calculatedResult;

    public BigDecimal getCalculatedResult() {
        return calculatedResult;
    }

    public static void main(String... arguments) throws Exception {
        new CalculatorApplication(arguments);
    }

    public CalculatorApplication(String... arguments) throws IOException {
        if (arguments.length != 1) {
            throw new CalculatorApplicationException("Please insert file name path.");
        }
        Path path = Paths.get(arguments[0]);
        List<String> lines = Files.readAllLines(path, UTF_8);
        calculatedResult = new CalculationService().calculate(lines);
        LOG.info(() -> calculatedResult.toString());
    }

}
