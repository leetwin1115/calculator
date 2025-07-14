package lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstnum = scanner.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondnum = scanner.nextInt();
            scanner.nextLine();

            System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
            String operator = scanner.nextLine();

            double result = 0;
            boolean isError = false;

            switch (operator) {
                case "+":
                    result = firstnum + secondnum;
                    break;
                case "-":
                    result = firstnum - secondnum;
                    break;
                case "*":
                    result = firstnum * secondnum;
                    break;
                case "/":
                    // 분모가 0인 경우 오류
                    if (secondnum == 0) {
                        System.out.println("오류: 나눗셈 연산에서 분모(두 번째 정수)에 0입니다.");
                        isError = true;
                    } else {
                        result = (double) firstnum / secondnum;
                    }
                    break;

                default:
                    System.out.println("오류: 유효하지 않은 사칙연산 기호입니다.");
                    isError = true;
                    break;
            }
            if (!isError) {
                System.out.println("결과: " + result);
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String command = scanner.next();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
    }
}