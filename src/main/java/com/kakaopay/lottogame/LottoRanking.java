package com.kakaopay.lottogame;

import java.util.function.BiFunction;

/**
 * @author david.chung
 * @since 2019-05-22
 */
public enum LottoRanking {
    FIFTH((matchCount, isBonusMatched) -> matchCount == 3, 5000L, "3개 일치 (5000원)"),
    FOURTH((matchCount, isBonusMatched) -> matchCount == 4, 50000L, "4개 일치 (50000원)"),
    THIRD((matchCount, isBonusMatched) -> matchCount == 5 && !isBonusMatched, 1500000L, "5개 일치 (1500000원)"),
    SECOND((matchCount, isBonusMatched) -> matchCount == 5 && isBonusMatched, 30000000L, "5개 일치, 보너스 볼 일치 (30000000원)"),
    FIRST((matchCount, isBonusMatched) -> matchCount == 6, 2000000000L, "6개 일치 (2000000000원)"),
    BUST((matchCount, isBonusMatched) -> matchCount < 3, 0L, "탈락")
    ;

    private BiFunction<Integer, Boolean, Boolean> matchRule;
    private Long amount;
    private String description;

    LottoRanking(BiFunction<Integer, Boolean, Boolean> matchRule,
                 Long amount,
                 String description) {
        this.matchRule = matchRule;
        this.amount = amount;
        this.description = description;
    }

    public Long getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public static LottoRanking check(Lotto lotto,
                                     LottoWinningSet winningSet) {

        int matchCount = 0;
        boolean isBonusNumberMatched = false;

        for (LottoNumber number : lotto.getNumbers()) {
            if (winningSet.getNumbers().contains(number)) {
                matchCount++;
            }

            if (!isBonusNumberMatched && winningSet.getBonusNumber().equals(number)) {
                isBonusNumberMatched = true;
            }
        }

        return getRank(matchCount, isBonusNumberMatched);
    }

    public static LottoRanking getRank(int matchCount, boolean isBonusMatched) {
        for(LottoRanking ranking : LottoRanking.values()) {
            if(ranking.matchRule.apply(matchCount, isBonusMatched)) {
                return ranking;
            }
        }
        return BUST;
    }
}