package com.kakaopay.lottogame;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author david.chung
 * @since 2019-05-22
 */
public class LottoWinningStatistics {
    private int buyAmount;
    private List<LottoRanking> rankings;

    public LottoWinningStatistics(int buyAmount,
                                  List<Lotto> lottos,
                                  LottoWinningSet winningSet) {
        this.buyAmount = buyAmount;
        this.rankings = calculateRankings(lottos, winningSet);
    }

    private List<LottoRanking> calculateRankings(List<Lotto> lottos, LottoWinningSet winningSet) {
        return lottos.stream()
                     .map(lotto -> calculdateRanking(lotto, winningSet))
                     .collect(Collectors.toList());
    }

    private LottoRanking calculdateRanking(Lotto lotto,
                                           LottoWinningSet winningSet) {

        int matchCount = (int) lotto.getNumbers()
                                    .stream()
                                    .filter(lottoNumber -> winningSet.getNumbers().contains(lottoNumber))
                                    .count();

        boolean isBonusNumberMatched = lotto.getNumbers()
                                            .stream()
                                            .anyMatch(lottoNumber -> winningSet.getBonusNumber().equals(lottoNumber));

        return decideRanking(matchCount, isBonusNumberMatched);
    }


    private LottoRanking decideRanking(int matchCount,
                                       boolean isBonusMatched) {
        Optional<LottoRanking> foundOptional = Arrays.stream(LottoRanking.values())
                                                     .filter(ranking -> ranking.getMatchRule().apply(matchCount, isBonusMatched))
                                                     .findFirst();

        return foundOptional.orElse(LottoRanking.BUST);
    }

    public List<LottoRanking> getRankings() {
        return rankings;
    }

    long getRankingCount(LottoRanking targetRanking) {
        return this.rankings.stream().filter(ranking -> ranking == targetRanking).count();
    }

    public double getRevenueRate() {
        long sum = rankings.stream().mapToLong(LottoRanking::getAmount).sum();
        if (sum == 0) {
            return 0;
        }
        return (double) this.buyAmount / sum;
    }

    public String buildStatisticsResultString() {
        return new StringBuilder()
                .append("당첨 통계\n")
                .append("--------\n")
                .append(buildRankingString(LottoRanking.FIFTH))
                .append(buildRankingString(LottoRanking.FOURTH))
                .append(buildRankingString(LottoRanking.THIRD))
                .append(buildRankingString(LottoRanking.SECOND))
                .append(buildRankingString(LottoRanking.FIRST))
                .append("총 수익률은 " + getRevenueRate() + "입니다.\n")
                .toString();
    }

    private String buildRankingString(LottoRanking ranking) {
        return ranking.getDescription() + "-" + getRankingCount(ranking) + "개\n";
    }
}
