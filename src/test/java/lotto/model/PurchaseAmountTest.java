package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Constant.PURCHASE_AMOUNT_INPUT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {
    @Test
    @DisplayName("1000원 단위가 아닌 금액이 들어오면 예외를 던진다.")
    void constructor_test1() {
        int input = 1200;
        assertThatThrownBy(() -> new PurchaseAmount(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(PURCHASE_AMOUNT_INPUT_EXCEPTION);
    }

}
