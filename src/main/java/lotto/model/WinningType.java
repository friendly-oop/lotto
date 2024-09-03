package lotto.model;

public enum WinningType {
    THREE(3, false),
    FOUR(4, false),
    FIVE(5, false),
    FIVE_WITH_BONUS(5, true),
    SIX(6, false);


    private final int matchNumberCount;
    private final boolean isMatchedBonusNumber;

    WinningType(int matchNumberCount, boolean isMatchedBonusNumber) {
        this.matchNumberCount = matchNumberCount;
        this.isMatchedBonusNumber = isMatchedBonusNumber;
    }
}
