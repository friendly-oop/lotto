package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.model.LottoWinningNumber;
import lotto.model.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoCalculatorTest {
    LottoCalculator lottoCalculator = new LottoCalculator();

    @DisplayName("당첨 통계를 리턴한다.")
    @Test
    void constructor_test1() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber("1,2,3,4,5,6");
        lottoWinningNumber.initBonusNumber(8);

        Lotto lotto1 = new Lotto(List.of(1, 2, 31, 10, 11, 12));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto lotto6 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);

        LottoStatistics statistics = lottoCalculator.calculate(lottos, lottoWinningNumber);
        System.out.println(statistics.getRateOfReturn());

        assertAll(
            () -> assertThat(statistics.getThreeWinningCount()).isEqualTo(1),
            () -> assertThat(statistics.getFourWinningCount()).isEqualTo(1),
            () -> assertThat(statistics.getFiveWinningCount()).isEqualTo(1),
            () -> assertThat(statistics.getFiveWithBonusWinningCount()).isEqualTo(1),
            () -> assertThat(statistics.getSixWinningCount()).isEqualTo(1),
            () -> assertThat(statistics.getTotalWinningPrice()).isEqualTo(2031555000L),
            () -> assertThat(statistics.getRateOfReturn()).isEqualTo(new BigDecimal("33859250.0"))
        );
    }
}