package org.example.calculator;


import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> result = new ArrayList<>();

    public Calculator() {}

    public int calc(int a, int b, char type) {
        int temp = switch (type) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) throw new ArithmeticException();
                yield a / b;
            }
            default -> throw new RuntimeException("지원하지 않는 연산자 : " + type);
        };
        result.add(temp);
        return result.get(result.size() - 1);
    }

    public void removeResult() {
        if (result.isEmpty()) {
            throw new RuntimeException("결과가 없습니다.");
        }
        result.remove(result.size() - 1);
    }

    public ArrayList<Integer> getResult() {
        return result;
    }

    public void setResult(ArrayList<Integer> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "result=" + result +
                '}';
    }
}
