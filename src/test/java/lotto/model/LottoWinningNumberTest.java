package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.Constant.ALREADY_CONTAINS_WINNING_NUMBER_EXCEPTION;
import static lotto.Constant.LOTTO_WINNING_NUMBER_INPUT_EXCEPTION;
import static lotto.Constant.LOTTO_WINNING_BONUS_NUMBER_RANGE_INPUT_EXCEPTION;
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

    @Test
    @DisplayName("45가 넘는 수가 들어오면 예외를 던진다.")
    void constructor_test2() {
        String input = "1,2,3,4,5,46";
        assertThatThrownBy(() -> new LottoWinningNumber(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(LOTTO_WINNING_NUMBER_INPUT_EXCEPTION);
    }

    @Test
    @DisplayName("45가 넘는 수가 들어오면 예외를 던진다.")
    void initBonusNumber_test1() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber("1,2,3,4,5,6");
        int input = 46;
        assertThatThrownBy(() -> lottoWinningNumber.initBonusNumber(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(LOTTO_WINNING_BONUS_NUMBER_RANGE_INPUT_EXCEPTION);
    }

    @Test
    @DisplayName("로또 번호에 있는 숫자가 들어오면 예외를 던진다.")
    void initBonusNumber_test2() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber("1,2,3,4,5,6");
        int input = 1;
        assertThatThrownBy(() -> lottoWinningNumber.initBonusNumber(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ALREADY_CONTAINS_WINNING_NUMBER_EXCEPTION);
    }
}