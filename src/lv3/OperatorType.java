package lv3;

import java.util.function.BiFunction;

public enum OperatorType {
    PLUS('+', (firstnum, secondnum) -> firstnum + secondnum),
    MINUS('-', (firstnum, secondnum) -> firstnum - secondnum),
    MULTIPLY('*', (firstnum, secondnum) -> firstnum * secondnum),
    DIVIDE('/', (firstnum, secondnum) -> {
        if (secondnum == 0) {
            throw new ArithmeticException("나눗셈에서 분모는 0이 될 수 없습니다.");
        }
        return firstnum / secondnum;
    });

    private final char symbol;
    private final BiFunction<Double, Double, Double> expression;

    OperatorType(char symbol, BiFunction<Double, Double, Double> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public double apply(double firstnum, double secondnum) {
        return this.expression.apply(firstnum, secondnum);
    }
}