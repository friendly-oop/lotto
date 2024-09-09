package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 2개 이하로 일치하면 null을 가진 WinningType을 리턴한다.")
    @Test
    void checkWinning_test1() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber("1,2,3,4,5,6");
        lottoWinningNumber.initBonusNumber(8);

        Lotto lotto = new Lotto(List.of(1, 2, 31, 10, 11, 12));

        WinningType winningType = lotto.checkWinning(lottoWinningNumber);

        assertThat(winningType).isNull();
    }

    @DisplayName("당첨 번호가 3개 일치하면 WinningType.THREE를 리턴한다.")
    @Test
    void checkWinning_test2() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber("1,2,3,4,5,6");
        lottoWinningNumber.initBonusNumber(8);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));

        WinningType winningType = lotto.checkWinning(lottoWinningNumber);

        assertThat(winningType).isEqualTo(WinningType.THREE);
    }

    @DisplayName("당첨 번호가 2개 일치하고 보너스 번호가 일치하면 WinningType.THREE를 리턴한다.")
    @Test
    void checkWinning_test3() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber("1,2,3,4,5,6");
        lottoWinningNumber.initBonusNumber(8);

        Lotto lotto = new Lotto(List.of(1, 2, 8, 10, 11, 12));

        WinningType winningType = lotto.checkWinning(lottoWinningNumber);

        assertThat(winningType).isEqualTo(WinningType.THREE);
    }

    @DisplayName("당첨 번호가 4개 일치하면 WinningType.FOUR를 리턴한다.")
    @Test
    void checkWinning_test4() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber("1,2,3,4,5,6");
        lottoWinningNumber.initBonusNumber(8);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 11, 12));

        WinningType winningType = lotto.checkWinning(lottoWinningNumber);

        assertThat(winningType).isEqualTo(WinningType.FOUR);
    }

    @DisplayName("당첨 번호가 3개 일치하고 보너스 번호가 일치하면 WinningType.FOUR를 리턴한다.")
    @Test
    void checkWinning_test5() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber("1,2,3,4,5,6");
        lottoWinningNumber.initBonusNumber(8);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 11, 12));

        WinningType winningType = lotto.checkWinning(lottoWinningNumber);

        assertThat(winningType).isEqualTo(WinningType.FOUR);
    }

    @DisplayName("당첨 번호가 5개 일치하면 WinningType.FIVE를 리턴한다.")
    @Test
    void checkWinning_test6() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber("1,2,3,4,5,6");
        lottoWinningNumber.initBonusNumber(8);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 12));

        WinningType winningType = lotto.checkWinning(lottoWinningNumber);

        assertThat(winningType).isEqualTo(WinningType.FIVE);
    }

    @DisplayName("당첨 번호가 5개 일치하고 보너스 번호가 일치하면 WinningType.FIVE_WITH_BONUS를 리턴한다.")
    @Test
    void checkWinning_test7() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber("1,2,3,4,5,6");
        lottoWinningNumber.initBonusNumber(8);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        WinningType winningType = lotto.checkWinning(lottoWinningNumber);

        assertThat(winningType).isEqualTo(WinningType.FIVE_WITH_BONUS);
    }

    @DisplayName("당첨 번호가 6개가 일치하면 WinningType.SIX를 리턴한다.")
    @Test
    void checkWinning_test8() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber("1,2,3,4,5,6");
        lottoWinningNumber.initBonusNumber(8);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        WinningType winningType = lotto.checkWinning(lottoWinningNumber);

        assertThat(winningType).isEqualTo(WinningType.SIX);
    }
}