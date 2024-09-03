package lotto.model;

import static lotto.Constant.PURCHASE_AMOUNT_INPUT_EXCEPTION;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private int amount;

    public PurchaseAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_INPUT_EXCEPTION);
        }
        this.amount = amount;
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }
}
