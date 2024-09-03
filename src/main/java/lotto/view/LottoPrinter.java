package lotto.view;

public class LottoPrinter {
    private final String PURCHASE_INPUT_MESSAGE = "구입금액을 입력해주세요.";
    private final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private final String LOTTO_WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String LOTTO_WINNING_BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final String LOTTO_STATISTICS_START_MESSAGE = "당첨 통계\n---";

    public void printPurchaseInputMessage() {
        System.out.println(PURCHASE_INPUT_MESSAGE);
    }

    public void printPurchaseMessage(int count) {
        System.out.println(String.format(PURCHASE_MESSAGE, count));
    }

    public void printLottoWinningNumberInputMessage() {
        System.out.println(LOTTO_WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void printLottoWinningBonusNumberInputMessage() {
        System.out.println(LOTTO_WINNING_BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printLottoStatisticsMessage() {
        System.out.println(LOTTO_STATISTICS_START_MESSAGE);
        // TODO 로또 통계 작업 추가
    }
}
