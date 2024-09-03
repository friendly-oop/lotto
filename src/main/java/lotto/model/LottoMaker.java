package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.LOTTO_NUMBER_COUNT;
import static lotto.Constant.MAX_LOTTO_NUMBER;
import static lotto.Constant.MIN_LOTTO_NUMBER;

public class LottoMaker {
    private LottoMaker() {}

    public static List<Lotto> makeLottoList(PurchaseAmount amount) {
        int lottoCount = amount.getLottoCount();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT)));
        }

        return lottos;
    }
}
