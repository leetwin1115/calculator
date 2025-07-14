package lv3;

import java.util.Scanner;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathCalculator mathCalculator = new MathCalculator();
        MoneyCalculator moneyCalculator = new MoneyCalculator();

        while (true) {
            System.out.print("첫 번째 숫자(정수 또는 실수)를 입력하세요: ");
            double firstnum = scanner.nextDouble();

            System.out.print("두 번째 숫자(정수 또는 실수)를 입력하세요: ");
            double secondnum = scanner.nextDouble();

            System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
            char operator = scanner.next().charAt(0);

            try {
                double result = mathCalculator.calculate(firstnum, secondnum, operator);
                System.out.printf("결과: %.2f\n", result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("저장된 결과: " + mathCalculator.getResults());
            // "krw" 기능 추가
            System.out.print("추가 기능 선택 (결과 원화변환: krw, 조회: 조회, 필터 조회: filter, 종료: exit): ");
            String command = scanner.next();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;

            } else if (command.equalsIgnoreCase("조회")) {
                System.out.println("전체 연산 결과: " + mathCalculator.getResults());

            } else if (command.equalsIgnoreCase("filter")) {
                System.out.print("기준 값을 입력하세요: ");
                double value = scanner.nextDouble();
                System.out.println(value + "보다 큰 결과들: " + mathCalculator.getResultsGreaterThan(value));

            } else if (command.equalsIgnoreCase("krw")) {
                // 'krw' command 처리
                List<Double> results = mathCalculator.getResults();
                if (results.isEmpty()) {
                    System.out.println("환율을 계산할 결과가 없습니다.");
                } else {
                    double lastResult = results.get(results.size() - 1);
                    // 마지막 결과 USD -> KRW
                    double krwValue = moneyCalculator.toKrw(lastResult, CurrencyType.USD);

                    System.out.println("--- 환율 변환 결과 ---");
                    System.out.printf("USD %.2f -> KRW %.2f\n", lastResult, krwValue);
                    System.out.println("--------------------");
                }
            }
        }
        scanner.close();
    }
}