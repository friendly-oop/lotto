package lotto.model;

import java.util.Arrays;
import java.util.List;

import static lotto.Constant.LOTTO_NUMBER_COUNT;
import static lotto.Constant.LOTTO_WINNING_NUMBER_INPUT_EXCEPTION;
import static lotto.Constant.SPLIT_COMMA;

public class LottoWinningNumber {

    public LottoWinningNumber(String input) {
        String[] numbers = input.split(SPLIT_COMMA);
        if (numbers.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_WINNING_NUMBER_INPUT_EXCEPTION);
        }
    }
}
