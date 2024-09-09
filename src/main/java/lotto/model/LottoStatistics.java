package lotto.model;

import java.math.BigDecimal;

public class LottoStatistics {
    private final long totalWinningPrice;
    private final int threeWinningCount;
    private final int fourWinningCount;
    private final int fiveWinningCount;
    private final int fiveWithBonusWinningCount;
    private final int sixWinningCount;
    private final BigDecimal rateOfReturn;

    public LottoStatistics(long totalWinningPrice, int threeWinningCount, int fourWinningCount, int fiveWinningCount, int fiveWithBonusWinningCount, int sixWinningCount, BigDecimal rateOfReturn) {
        this.totalWinningPrice = totalWinningPrice;
        this.threeWinningCount = threeWinningCount;
        this.fourWinningCount = fourWinningCount;
        this.fiveWinningCount = fiveWinningCount;
        this.fiveWithBonusWinningCount = fiveWithBonusWinningCount;
        this.sixWinningCount = sixWinningCount;
        this.rateOfReturn = rateOfReturn;
    }

    public int getFiveWinningCount() {
        return fiveWinningCount;
    }

    public int getFiveWithBonusWinningCount() {
        return fiveWithBonusWinningCount;
    }

    public int getFourWinningCount() {
        return fourWinningCount;
    }

    public BigDecimal getRateOfReturn() {
        return rateOfReturn;
    }

    public int getSixWinningCount() {
        return sixWinningCount;
    }

    public int getThreeWinningCount() {
        return threeWinningCount;
    }

    public long getTotalWinningPrice() {
        return totalWinningPrice;
    }
}
