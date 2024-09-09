package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        if (distinctNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String printLottoNumbers() {
        return this.numbers.stream().sorted().toList().toString();
    }

    public WinningType checkWinning(LottoWinningNumber winningNumber) {
        int matchNumberCount = 0;
        boolean isMatchedBonusNumber = false;

        for (Integer number : numbers) {
            if(winningNumber.check(number)) matchNumberCount++;
            if(!isMatchedBonusNumber) {
                isMatchedBonusNumber = winningNumber.checkBonusNumber(number);
            }
        }

        if (matchNumberCount < 4 && isMatchedBonusNumber) {
            matchNumberCount++;
            isMatchedBonusNumber = false;
        }

        return WinningType.find(matchNumberCount,isMatchedBonusNumber);
    }
}
