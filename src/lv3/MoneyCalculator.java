package lv3;

public class MoneyCalculator {

     //amount 변환금액, sourceMoney 현재 통화 타입, return 원화(KRW)로 변환된금액
    public double toKrw(double amount, CurrencyType sourceMoney) {
        return CurrencyType.convert(amount, sourceMoney, CurrencyType.KRW);
    }
}