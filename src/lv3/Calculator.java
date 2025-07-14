package lv3;

import java.util.List;
import java.util.ArrayList;

public abstract class Calculator {
    private final List<Double> results;

    public Calculator(List<Double> results) {
        this.results = results;
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

    public void addResult(double result) {
        this.results.add(result);
    }
}