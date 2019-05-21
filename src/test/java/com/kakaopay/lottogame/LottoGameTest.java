package com.kakaopay.lottogame;

import org.junit.Assert;

import java.util.List;

/**
 * @author david.chung
 * @since 2019-05-20
 */
public class LottoGameTest {
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void 천원미만으로사기() {
        LottoGame game = new LottoGame();
        // Buy
        game.buyLottos(500);
    }

    @org.junit.Test
    public void 한개사기() {
        LottoGame game = new LottoGame();
        // Buy
        List<Lotto> lottos = game.buyLottos(1000);
        Assert.assertEquals(1, lottos.size());
    }

    // 구현한 다음에 테스트 케이스를 추가해버림. ㅠㅠ
    @org.junit.Test
    public void 애매하게한개사기() {
        LottoGame game = new LottoGame();
        // Buy
        List<Lotto> lottos = game.buyLottos(1500);
        Assert.assertEquals(1, lottos.size());
    }

    @org.junit.Test
    public void 두개사기() {
        LottoGame game = new LottoGame();
        // Buy
        List<Lotto> lottos = game.buyLottos(2000);
        Assert.assertEquals(2, lottos.size());
    }
}
