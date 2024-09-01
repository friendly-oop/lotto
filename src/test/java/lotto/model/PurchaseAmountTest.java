package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {
    @Test
    @DisplayName("1000원 단위가 아닌 금액이 들어오면 예외를 던진다.")
    void constructor_test1() {
        int input = 1200;
        assertThatThrownBy(() -> new PurchaseAmount(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 구입 금액은 1000원 단위로 입력 가능합니다.");
    }

}
