package lotto.model;

public class PurchaseAmount {
    private int amount;

    public PurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위로 입력 가능합니다.");
        }
        this.amount = amount;
    }
}
