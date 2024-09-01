package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.Constant.LOTTO_NUMBER_COUNT;
import static lotto.Constant.LOTTO_WINNING_NUMBER_INPUT_EXCEPTION;
import static lotto.Constant.SPLIT_COMMA;

public class LottoWinningNumber {

    public LottoWinningNumber(String input) {
        Set<Integer> numbers = Arrays.stream(input.split(SPLIT_COMMA))
            .map(Integer::parseInt)
            .collect(Collectors.toSet());

        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_WINNING_NUMBER_INPUT_EXCEPTION);
        }
    }
}
