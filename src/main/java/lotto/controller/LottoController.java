package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMaker;
import lotto.model.LottoWinningNumber;
import lotto.model.PurchaseAmount;
import lotto.view.LottoPrinter;
import lotto.view.LottoScanner;

import java.util.List;

public class LottoController {
    private final LottoPrinter printer;
    private final LottoScanner scanner;
    private PurchaseAmount purchaseAmount;
    private List<Lotto> lottos;
    private LottoWinningNumber lottoWinningNumber;

    public LottoController() {
        this.printer = new LottoPrinter();
        this.scanner = new LottoScanner();
    }

    public void purchaseLotto() {
        printer.printPurchaseInputMessage();
        this.purchaseAmount = scanner.scanPurchaseAmount();
        printer.printPurchaseMessage(purchaseAmount.getLottoCount());
        this.lottos = LottoMaker.makeLottoList(this.purchaseAmount);
        for(Lotto lotto : this.lottos) {
            printer.printLottoNumbers(lotto);
        }
    }

    public void makeWinningLottoNumber() {
        printer.printLottoWinningNumberInputMessage();
        this.lottoWinningNumber = scanner.scanLottoWinningNumber();
        printer.printLottoWinningBonusNumberInputMessage();
        scanner.scanLottoWinningBonusNumber(this.lottoWinningNumber);
    }
}
