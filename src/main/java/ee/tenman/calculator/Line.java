package ee.tenman.calculator;

import ee.tenman.calculator.command.Operator;

import java.math.BigDecimal;

public class Line {
    private Operator operator;
    private BigDecimal value;

    public Operator getOperator() {
        return operator;
    }

    public BigDecimal getNumber() {
        return value;
    }

    public Line(String string) {
        String[] strings = string.split(" ");
        this.operator = Operator.valueOf(strings[0].toUpperCase());
        this.value = new BigDecimal(strings[1]);
    }
}