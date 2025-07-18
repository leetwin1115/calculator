package lv3;
//속 CurrencyType
public enum CurrencyType {
    // 각 통화와 USD 대비 환율
    USD("달러", 1.0),
    KRW("원", 1381), // 2025년 기준 예시 환율
    EUR("유로", 0.856),
    JPY("엔", 147.3);

    private final String name;
    private final double rateToUsd;
    //생
    CurrencyType(String name, double rateToUsd) {
        this.name = name;
        this.rateToUsd = rateToUsd;
    }
    //기
    public String getName() {
        return name;
    }


     //amount 변환할 금액, from 시작 통화 타입, to 바뀔 통화 타입, return 변환된 금액
    public static double convert(double amount, CurrencyType from, CurrencyType to) {
        double amountInUsd = amount / from.rateToUsd;
        return amountInUsd * to.rateToUsd;
    }
}