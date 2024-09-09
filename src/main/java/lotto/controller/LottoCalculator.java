package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.model.LottoWinningNumber;
import lotto.model.WinningType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;

public class LottoCalculator {
    private final EnumMap<WinningType, Integer> winningAmountTypes = new EnumMap<>(WinningType.class);

    public LottoCalculator() {
        setWinningTypes();
    }

    private void setWinningTypes() {
        this.winningAmountTypes.put(WinningType.THREE, 5000);
        this.winningAmountTypes.put(WinningType.FOUR, 50000);
        this.winningAmountTypes.put(WinningType.FIVE, 1500000);
        this.winningAmountTypes.put(WinningType.FIVE_WITH_BONUS, 30000000);
        this.winningAmountTypes.put(WinningType.SIX, 2000000000);
    }

    public LottoStatistics calculate(List<Lotto> lottos, LottoWinningNumber winningNumber) {
        int threeWinningCount = 0;
        int fourWinningCount = 0;
        int fiveWinningCount = 0;
        int fiveWithBonusWinningCount = 0;
        int sixWinningCount = 0;
        long totalWinningPrice = 0L;

        for (Lotto lotto : lottos) {
            WinningType winningType = lotto.checkWinning(winningNumber);
            if (winningType == WinningType.THREE) {
                threeWinningCount++;
                totalWinningPrice += winningAmountTypes.get(WinningType.THREE);
            }

            if (winningType == WinningType.FOUR) {
                fourWinningCount++;
                totalWinningPrice += winningAmountTypes.get(WinningType.FOUR);
            }

            if (winningType == WinningType.FIVE) {
                fiveWinningCount++;
                totalWinningPrice += winningAmountTypes.get(WinningType.FIVE);
            }

            if (winningType == WinningType.FIVE_WITH_BONUS) {
                fiveWithBonusWinningCount++;
                totalWinningPrice += winningAmountTypes.get(WinningType.FIVE_WITH_BONUS);
            }

            if (winningType == WinningType.SIX) {
                sixWinningCount++;
                totalWinningPrice += winningAmountTypes.get(WinningType.SIX);
            }
        }

        BigDecimal rateOfReturn = calculateRateOfReturn(totalWinningPrice, lottos.size() * 1000L);

        return new LottoStatistics(totalWinningPrice, threeWinningCount, fourWinningCount, fiveWinningCount, fiveWithBonusWinningCount, sixWinningCount, rateOfReturn);
    }

    private BigDecimal calculateRateOfReturn(Long totalWinningPrice, Long purchasePrice) {
        BigDecimal bdWinningPrice = new BigDecimal(totalWinningPrice);
        BigDecimal bdPurchasePrice = new BigDecimal(purchasePrice);

        return bdWinningPrice.divide(bdPurchasePrice, 1, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
    }
}
