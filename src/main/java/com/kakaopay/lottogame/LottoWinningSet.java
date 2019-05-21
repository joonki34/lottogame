package com.kakaopay.lottogame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author david.chung
 * @since 2019-05-20
 */
public class LottoWinningSet {
    private static final int WIN_TOTAL_COUNT = 7;
    private Set<LottoNumber> numbers;
    private LottoNumber bonusNumber;

    public LottoWinningSet() {
    }

    // 테스트용 코드
    LottoWinningSet(Set<LottoNumber> numbers,
                    LottoNumber bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    LottoWinningSet(String numberString,
                    int bonusNumber) {
        this.numbers = new HashSet<>(Arrays.asList(numberString.split(","))).stream()
                                                                            .map(number -> new LottoNumber(Integer.parseInt(number)))
                                                                            .collect(Collectors.toSet());
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public void pick() {
        List<LottoNumber> numbers = RandomNumberGenerator.generateRandomLottoNumbers(WIN_TOTAL_COUNT)
                                                         .stream()
                                                         .map(LottoNumber::new)
                                                         .collect(Collectors.toList());


        this.numbers = new HashSet<>(numbers.subList(0, 6));
        this.bonusNumber = numbers.get(6);
    }

    public Set<LottoNumber> getNumbers() {
        return this.numbers;
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }
}
