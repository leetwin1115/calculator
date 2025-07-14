package lv2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstnum = scanner.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondnum = scanner.nextInt();

            System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
            char operator = scanner.next().charAt(0);

            try {
                double result = calculator.calculate(firstnum, secondnum, operator);
                System.out.println("결과: " + result);

            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("저장된 연산 결과 수: " + calculator.getResults().size());
            System.out.print("추가 기능을 선택하세요 (결과 조회: inquiry, 가장 오래된 결과 삭제: remove, 종료: exit) : ");
            String command = scanner.next();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            } else if (command.equalsIgnoreCase("inquiry")) {
                System.out.println("저장된 연산 결과: " + calculator.getResults());
            } else if (command.equalsIgnoreCase("remove")) {
                calculator.removeFirstResult();
                System.out.println("가장 오래된 결과가 삭제되었습니다.");
            }
        }

        scanner.close();
    }
}
