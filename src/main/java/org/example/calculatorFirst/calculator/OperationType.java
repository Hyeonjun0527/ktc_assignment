package org.example.calculatorFirst.calculator;

public enum OperationType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;

    OperationType(char symbol) {
        this.symbol = symbol;
    };

    public char getSymbol() {
        return symbol;
    }

    public static OperationType fromSymbol(char symbol) {
        for (OperationType type : OperationType.values()) {
            if (type.getSymbol() == symbol) {
                return type;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자: " + symbol);
    }


}
