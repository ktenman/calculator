package ee.tenman.calculator.command;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public enum Operator {
    ADD('+'),
    DIVIDE('/'),
    MULTIPLY('*'),
    SUBTRACT('-'),
    APPLY(' ');

    private static final Map<Operator, Command> COMMANDS = ImmutableMap.of(
            ADD, new AddCommand(),
            DIVIDE, new DivideCommand(),
            MULTIPLY, new MultiplyCommand(),
            SUBTRACT, new SubtractCommand());

    private char operatorSymbol;

    Operator(final char operatorSymbol) {
        this.operatorSymbol = operatorSymbol;
    }

    public char getOperatorSymbol() {
        return this.operatorSymbol;
    }

    public Command getCommand() {
        return COMMANDS.getOrDefault(this, null);
    }
}