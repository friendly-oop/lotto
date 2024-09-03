package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoWinningNumber;
import lotto.model.PurchaseAmount;

public class LottoScanner {
    public PurchaseAmount scanPurchaseAmount() {
        String input = Console.readLine();
        return new PurchaseAmount(Integer.parseInt(input));
    }

    public LottoWinningNumber scanLottoWinningNumber() {
        String input = Console.readLine();
        return new LottoWinningNumber(input);
    }

    public void scanLottoWinningBonusNumber(LottoWinningNumber winningNumber) {
        String input = Console.readLine();
        winningNumber.initBonusNumber(Integer.parseInt(input));
    }
}
