package lotto.model;

import static lotto.Constant.PURCHASE_AMOUNT_INPUT_EXCEPTION;

public class PurchaseAmount {
    private int amount;

    public PurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_INPUT_EXCEPTION);
        }
        this.amount = amount;
    }
}
