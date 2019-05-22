package com.kakaopay.lottogame;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

/**
 * @author david.chung
 * @since 2019-05-22
 */
public class LottoWinningStatisticsTest {
    private static final int BUY_AMOUNT = 1000;
    private static final double DELTA = 1e-15;

    @Test
    public void 세개일치() {
        // 로또 생성
        Lotto lotto = new Lotto(new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6));

        // 당첨 번호 생성
        LottoWinningSet winningSet = new LottoWinningSet("1,2,3,10,11,12", 30);

        LottoWinningStatistics statistics = new LottoWinningStatistics(BUY_AMOUNT, Collections.singletonList(lotto), winningSet);
        Assert.assertEquals(LottoRanking.FIFTH, statistics.getRankings().get(0));
        Assert.assertEquals((double) BUY_AMOUNT / LottoRanking.FIFTH.getAmount(), statistics.getRevenueRate(), DELTA);
    }

    @Test
    public void 네개일치() {
        // 로또 생성
        Lotto lotto = new Lotto(new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6));

        // 당첨 번호 생성
        LottoWinningSet winningSet = new LottoWinningSet("1,2,3,4,11,12", 30);

        LottoWinningStatistics statistics = new LottoWinningStatistics(BUY_AMOUNT, Collections.singletonList(lotto), winningSet);
        Assert.assertEquals(LottoRanking.FOURTH, statistics.getRankings().get(0));
        Assert.assertEquals((double) BUY_AMOUNT / LottoRanking.FOURTH.getAmount(), statistics.getRevenueRate(), DELTA);
    }

    @Test
    public void 다섯개일치() {
        // 로또 생성
        Lotto lotto = new Lotto(new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6));

        // 당첨 번호 생성
        LottoWinningSet winningSet = new LottoWinningSet("1,2,3,4,5,12", 30);

        LottoWinningStatistics statistics = new LottoWinningStatistics(BUY_AMOUNT, Collections.singletonList(lotto), winningSet);
        Assert.assertEquals(LottoRanking.THIRD, statistics.getRankings().get(0));
        Assert.assertEquals((double) BUY_AMOUNT / LottoRanking.THIRD.getAmount(), statistics.getRevenueRate(), DELTA);
    }

    @Test
    public void 다섯개와보너스볼일치() {
        // 로또 생성
        Lotto lotto = new Lotto(new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6));

        // 당첨 번호 생성
        LottoWinningSet winningSet = new LottoWinningSet("1,2,3,4,5,12", 6);

        LottoWinningStatistics statistics = new LottoWinningStatistics(BUY_AMOUNT, Collections.singletonList(lotto), winningSet);
        Assert.assertEquals(LottoRanking.SECOND, statistics.getRankings().get(0));
        Assert.assertEquals((double) BUY_AMOUNT / LottoRanking.SECOND.getAmount(), statistics.getRevenueRate(), DELTA);
    }

    @Test
    public void 여섯개일치() {
        // 로또 생성
        Lotto lotto = new Lotto(new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6));

        // 당첨 번호 생성
        LottoWinningSet winningSet = new LottoWinningSet("1,2,3,4,5,6", 8);

        LottoWinningStatistics statistics = new LottoWinningStatistics(BUY_AMOUNT, Collections.singletonList(lotto), winningSet);
        Assert.assertEquals(LottoRanking.FIRST, statistics.getRankings().get(0));
        Assert.assertEquals((double) BUY_AMOUNT / LottoRanking.FIRST.getAmount(), statistics.getRevenueRate(), DELTA);

    }

    @Test
    public void 두개일치() {
        // 로또 생성
        Lotto lotto = new Lotto(new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6));

        // 당첨 번호 생성
        LottoWinningSet winningSet = new LottoWinningSet("1,2,34,45,56,12", 60);

        LottoWinningStatistics statistics = new LottoWinningStatistics(BUY_AMOUNT, Collections.singletonList(lotto), winningSet);
        Assert.assertEquals(LottoRanking.BUST, statistics.getRankings().get(0));
        Assert.assertEquals(0, statistics.getRevenueRate(), DELTA);
    }
}
