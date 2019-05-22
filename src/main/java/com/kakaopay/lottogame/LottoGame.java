package com.kakaopay.lottogame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author david.chung
 * @since 2019-05-20
 */
public class LottoGame {
    private static final int MIN_BUY_AMOUNT = 1000;
    private List<Lotto> lottos;

    public List<Lotto> buyLottos(int amount) {
        if (amount < MIN_BUY_AMOUNT) {
            throw new IllegalArgumentException();
        }
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < getTotalLottoCount(amount); i++) {
            result.add(new Lotto());
        }

        this.lottos = result;

        return this.lottos;
    }

    private int getTotalLottoCount(int amount) {
        return amount / 1000;
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        Scanner scanner = new Scanner(System.in);

        // 로또 구매
        System.out.println("구입금액을 입력해 주세요");
        int amount = scanner.nextInt();
        List<Lotto> lottos = lottoGame.buyLottos(amount);

        System.out.println(lottos.size() + "개를 구매했습니다.");
        System.out.println(lottos.stream()
                                 .map(Lotto::toString)
                                 .collect(Collectors.joining("\n")));
        System.out.println();


        // 로또 추첨
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbersString = scanner.next();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        LottoWinningSet winningSet = new LottoWinningSet(numbersString, bonusNumber);
        System.out.println();

        // 당첨 통계
        LottoWinningStatistics statistics = new LottoWinningStatistics(amount, lottos, winningSet);
        System.out.println(statistics.buildStatisticsResultString());
    }
}
