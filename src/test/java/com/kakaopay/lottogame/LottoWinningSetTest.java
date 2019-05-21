package com.kakaopay.lottogame;

import org.junit.Assert;

/**
 * @author david.chung
 * @since 2019-05-22
 */
public class LottoWinningSetTest {
    @org.junit.Test
    public void 당첨번호알기() {
        LottoWinningSet lottoWinningSet = new LottoWinningSet();
        lottoWinningSet.pick();
        Assert.assertEquals(6, lottoWinningSet.getNumbers().size());
    }

    @org.junit.Test
    public void 보너스번호알기() {
        LottoWinningSet lottoWinningSet = new LottoWinningSet();
        lottoWinningSet.pick();
        Assert.assertTrue( lottoWinningSet.getBonusNumber() != null);
    }
}
