package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.PurchaseAmount;

public class LottoScanner {
    private LottoScanner() {}

    public PurchaseAmount scanPurchaseAmount() {
        String input = Console.readLine();
        return new PurchaseAmount(Integer.parseInt(input));
    }
}
