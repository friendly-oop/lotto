package lotto.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.Constant.ALREADY_CONTAINS_WINNING_NUMBER_EXCEPTION;
import static lotto.Constant.LOTTO_NUMBER_COUNT;
import static lotto.Constant.LOTTO_WINNING_NUMBER_INPUT_EXCEPTION;
import static lotto.Constant.LOTTO_WINNING_BONUS_NUMBER_RANGE_INPUT_EXCEPTION;
import static lotto.Constant.MAX_LOTTO_NUMBER;
import static lotto.Constant.MIN_LOTTO_NUMBER;
import static lotto.Constant.SPLIT_COMMA;

public class LottoWinningNumber {
    private Set<Integer> numbers;
    private Integer bonusNumber;

    public LottoWinningNumber(String input) {
        Set<Integer> numbers = Arrays.stream(input.split(SPLIT_COMMA))
            .map(Integer::parseInt)
            .filter(number -> checkLottoNumberInRange(number))
            .collect(Collectors.toSet());

        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_WINNING_NUMBER_INPUT_EXCEPTION);
        }

        this.numbers = numbers;
    }

    public void initBonusNumber(int bonusNumber) {
        if(!checkLottoNumberInRange(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_WINNING_BONUS_NUMBER_RANGE_INPUT_EXCEPTION);
        }

        if(this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ALREADY_CONTAINS_WINNING_NUMBER_EXCEPTION);
        }

        this.bonusNumber = bonusNumber;
    }

    private static boolean checkLottoNumberInRange(Integer number) {
        return number <= MAX_LOTTO_NUMBER && number >= MIN_LOTTO_NUMBER;
    }
}
