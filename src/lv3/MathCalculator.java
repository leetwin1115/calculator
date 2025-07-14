package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MathCalculator extends Calculator {

    public MathCalculator() {
        super(new ArrayList<>());
    }

    public <T extends Number> double calculate(T firstnum, T secondnum, char operatorSymbol) {
        OperatorType operator = getOperatorType(operatorSymbol);

        double result = operator.apply(firstnum.doubleValue(), secondnum.doubleValue());

        super.addResult(result);
        return result;
    }

    public List<Double> getResultsGreaterThan(double value) {
        return super.getResults().stream()
                .filter(result -> result > value)
                .collect(Collectors.toList());
    }

    private OperatorType getOperatorType(char operatorSymbol) {
        for (OperatorType type : OperatorType.values()) {
            if (type.name().equalsIgnoreCase(getOperatorName(operatorSymbol))) {
                return type;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 연산자 기호입니다.");
    }

    private String getOperatorName(char operatorSymbol) {
        return switch (operatorSymbol) {
            case '+' -> "PLUS";
            case '-' -> "MINUS";
            case '*' -> "MULTIPLY";
            case '/' -> "DIVIDE";
            default -> throw new IllegalArgumentException("유효하지 않은 연산자 기호입니다.");
        };
    }
}