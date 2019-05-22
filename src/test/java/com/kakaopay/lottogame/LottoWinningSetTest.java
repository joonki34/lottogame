package com.kakaopay.lottogame;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author david.chung
 * @since 2019-05-22
 */
public class LottoWinningSetTest {
    @org.junit.Test
    public void 당첨번호알기() {
        LottoWinningSet lottoWinningSet = new LottoWinningSet();
        Assert.assertEquals(6, lottoWinningSet.getNumbers().size());
    }

    @org.junit.Test
    public void 보너스번호알기() {
        LottoWinningSet lottoWinningSet = new LottoWinningSet();
        Assert.assertTrue( lottoWinningSet.getBonusNumber() != null);
    }

    @Test
    public void 당첨번호_중복_없음() {
        new LottoWinningSet("1,2,3,4,5,6", 7);
        Assert.assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호_중복_있으면_에러() {
        new LottoWinningSet("1,2,3,4,5,6", 5);
    }
}
