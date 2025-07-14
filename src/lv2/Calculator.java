package lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Double> results;

    public Calculator() {
        this.results = new ArrayList<>();
    }

    public double calculate(int firstnum, int secondnum, char operator) {
        double result;

        switch (operator) {
            case '+':
                result = firstnum + secondnum;
                break;
            case '-':
                result = firstnum - secondnum;
                break;
            case '*':
                result = firstnum * secondnum;
                break;
            case '/':
                if (secondnum == 0) {
                    throw new ArithmeticException("오류: 0은 분모가 될 수 없습니다.");
                }
                result = (double) firstnum / secondnum;
                break;
            default:
                throw new IllegalArgumentException("오류: 잘못된 연산 기호입니다.");
        }
        results.add(result);
        return result;
    }

    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        } else {
            System.out.println("삭제할 연산 결과가 없습니다.");
        }
    }

    public List<Double> getResults() {
        return new ArrayList<>(this.results);
    }

    public void setResults(List<Double> newResults) {
        this.results.clear();
        if (newResults != null) {
            this.results.addAll(newResults);
        }
    }
}