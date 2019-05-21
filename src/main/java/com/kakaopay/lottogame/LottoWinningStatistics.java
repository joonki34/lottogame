package com.kakaopay.lottogame;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author david.chung
 * @since 2019-05-22
 */
public class LottoWinningStatistics {
    private List<LottoRanking> rankings;

    public LottoWinningStatistics(List<Lotto> lottos,
                                  LottoWinningSet winningSet) {
        this.rankings = lottos.stream()
                              .map(lotto -> LottoRanking.check(lotto, winningSet))
                              .collect(Collectors.toList());
    }

    public List<LottoRanking> getRankings() {
        return rankings;
    }

    public long getRankingCount(LottoRanking targetRanking) {
        return this.rankings.stream().filter(ranking -> ranking == targetRanking).count();
    }

    public double getRevenueRate(int amount) {
        long sum = rankings.stream().mapToLong(LottoRanking::getAmount).sum();
        if(sum == 0) {
            return 0;
        }
        return (double) amount / sum;
    }
}
