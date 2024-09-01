package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.Constant.LOTTO_WINNING_NUMBER_INPUT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinningNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3","1,2,2,3,4,5"})
    @DisplayName("중복을 제외한 로또 번호 개수가 6이 아니면 예외를 던진다.")
    void constructor_test1(String input) {
        assertThatThrownBy(() -> new LottoWinningNumber(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(LOTTO_WINNING_NUMBER_INPUT_EXCEPTION);
    }
}