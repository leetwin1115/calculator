package lv3;

import java.util.List;
import java.util.ArrayList;

public abstract class Calculator {
    //속
    private final List<Double> results;
    //생
    public Calculator(List<Double> results) {
        this.results = results;
    }
    //기
    public List<Double> getResults() {
        return new ArrayList<>(this.results);
    }

    public void setResults(List<Double> newResults) {
        this.results.clear();
        if (newResults != null) {
            this.results.addAll(newResults);
        }
    }

    public void addResult(double result) {
        this.results.add(result);
    }
}