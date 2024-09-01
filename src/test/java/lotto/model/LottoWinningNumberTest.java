package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Constant.LOTTO_WINNING_NUMBER_INPUT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinningNumberTest {
    @Test
    @DisplayName("콤마를 기준으로 나누었을 때 길이가 6인 배열이 나오지 않으면 예외를 던진다.")
    void constructor_test1() {
        String input = "1,2,3";
        assertThatThrownBy(() -> new LottoWinningNumber(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(LOTTO_WINNING_NUMBER_INPUT_EXCEPTION);
    }
}