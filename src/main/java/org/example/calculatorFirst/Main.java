package org.example.calculatorFirst;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int a = scanner.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int b = scanner.nextInt();
                System.out.print("사칙연산 기호를 입력하세요: ");
                char s = scanner.next().charAt(0);
                scanner.nextLine();
                //처음에 nextLine으로 했었음. nextInt()는 개행문자를 그대로 둬서 nextLine()을 호출하면
                //내용을 없는 빈 줄을 얻게 되어. StringIndexOfBoundsException이 발생했음.
                //공백, 개행을 건너뛰고 다음 토큰을 읽기 때문에 next로 입력을 받을 수 있었다.
                //그런데 while문 작성하다가 또 문제가 생겼다. 이상하게 즉시
                    /*
                    종료하시려면 exit, 아니면 아무 키나 입력해주세요 :
                    첫 번째 숫자를 입력하세요:
                    가 뜨는 것이다. 그 이유는 개행문자가 그대로 남아. nextLine()이 버퍼에 있었던 개행문자를 읽었다.
                    그리고 즉시 if문이 false가 되어 다시 시작되었다. 즉 무한 반복하는 프로그램을 만든것.
                     */
                int result = switch (s) {
                    case '+' -> a + b;
                    case '-' -> a - b;
                    case '*' -> a * b;
                    case '/' -> {
                        if (b == 0) throw new ArithmeticException("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없다.");
                        yield a / b;
                    }
                    default -> throw new RuntimeException("지원하지 않는 연산자 : " + s);
                };
                System.out.println("결과 : " + result);
                System.out.print("종료하시려면 exit, 아니면 아무 키나 입력해주세요 : ");
            } while (!scanner.nextLine().equals("exit"));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
