package com.kakaopay.lottogame;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author david.chung
 * @since 2019-05-22
 */
public class LottoWinningStatisticsTest {
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
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(10));
        numbers.add(new LottoNumber(11));
        numbers.add(new LottoNumber(12));
        LottoNumber bonusNumber = new LottoNumber(30);
        LottoWinningSet winningSet = new LottoWinningSet(numbers, bonusNumber);

        LottoWinningStatistics statistics = new LottoWinningStatistics(Collections.singletonList(lotto), winningSet);
        Assert.assertEquals(LottoRanking.FIFTH, statistics.getRankings().get(0));
        Assert.assertEquals((double) 1000 / LottoRanking.FIFTH.getAmount(), statistics.getRevenueRate(1000), DELTA);
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
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(4));
        numbers.add(new LottoNumber(11));
        numbers.add(new LottoNumber(12));
        LottoNumber bonusNumber = new LottoNumber(30);
        LottoWinningSet winningSet = new LottoWinningSet(numbers, bonusNumber);

        LottoWinningStatistics statistics = new LottoWinningStatistics(Collections.singletonList(lotto), winningSet);
        Assert.assertEquals(LottoRanking.FOURTH, statistics.getRankings().get(0));
        Assert.assertEquals((double) 1000 / LottoRanking.FOURTH.getAmount(), statistics.getRevenueRate(1000), DELTA);
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
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(4));
        numbers.add(new LottoNumber(5));
        numbers.add(new LottoNumber(12));
        LottoNumber bonusNumber = new LottoNumber(30);
        LottoWinningSet winningSet = new LottoWinningSet(numbers, bonusNumber);

        LottoWinningStatistics statistics = new LottoWinningStatistics(Collections.singletonList(lotto), winningSet);
        Assert.assertEquals(LottoRanking.THIRD, statistics.getRankings().get(0));
        Assert.assertEquals((double) 1000 / LottoRanking.THIRD.getAmount(), statistics.getRevenueRate(1000), DELTA);
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
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(4));
        numbers.add(new LottoNumber(5));
        numbers.add(new LottoNumber(12));
        LottoNumber bonusNumber = new LottoNumber(6);
        LottoWinningSet winningSet = new LottoWinningSet(numbers, bonusNumber);

        LottoWinningStatistics statistics = new LottoWinningStatistics(Collections.singletonList(lotto), winningSet);
        Assert.assertEquals(LottoRanking.SECOND, statistics.getRankings().get(0));
        Assert.assertEquals((double) 1000 / LottoRanking.SECOND.getAmount(), statistics.getRevenueRate(1000), DELTA);
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
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(4));
        numbers.add(new LottoNumber(5));
        numbers.add(new LottoNumber(6));
        LottoNumber bonusNumber = new LottoNumber(8);
        LottoWinningSet winningSet = new LottoWinningSet(numbers, bonusNumber);

        LottoWinningStatistics statistics = new LottoWinningStatistics(Collections.singletonList(lotto), winningSet);
        Assert.assertEquals(LottoRanking.FIRST, statistics.getRankings().get(0));
        Assert.assertEquals((double) 1000 / LottoRanking.FIRST.getAmount(), statistics.getRevenueRate(1000), DELTA);

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
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(34));
        numbers.add(new LottoNumber(45));
        numbers.add(new LottoNumber(56));
        numbers.add(new LottoNumber(12));
        LottoNumber bonusNumber = new LottoNumber(60);
        LottoWinningSet winningSet = new LottoWinningSet(numbers, bonusNumber);

        LottoWinningStatistics statistics = new LottoWinningStatistics(Collections.singletonList(lotto), winningSet);
        Assert.assertEquals(LottoRanking.BUST, statistics.getRankings().get(0));
        Assert.assertEquals(0, statistics.getRevenueRate(1000), DELTA);
    }
}
