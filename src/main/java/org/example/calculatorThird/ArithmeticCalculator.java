package org.example.calculatorThird;


import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private List<Double> results = new ArrayList<>();

    public ArithmeticCalculator() {}

    public double calculate(T a, T b, OperationType type) {
        double a1 = a.doubleValue();
        double b1 = b.doubleValue();

        double temp = switch (type) {
            case ADD -> a1 + b1;
            case SUBTRACT -> a1 - b1;
            case MULTIPLY -> a1 * b1;
            case DIVIDE -> {
                if (b1 == 0) throw new ArithmeticException("Cannot divide by zero");
                yield a1 / b1;
            }
        };
        results.add(temp);
        return results.get(results.size() - 1);
    }

    public void removeResult() {
        if (results.isEmpty()) {
            throw new RuntimeException("결과가 없습니다.");
        }
        results.remove(results.size() - 1);
    }

    public List<Double> getResultsGreaterThan(double threshold) {
        return results.stream()
                .filter(result -> result > threshold)
                .toList();
    }

    public List<Double> getResults() {
        return results;
    }

    public void setResults(List<Double> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "result=" + results +
                '}';
    }
}
