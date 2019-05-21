package com.kakaopay.lottogame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author david.chung
 * @since 2019-05-20
 */
public class Lotto {
    private static final int TOTAL_COUNT = 6;
    private Set<LottoNumber> numbers;

    public Lotto() {
        this.numbers = new HashSet<>();
        generateRandomLottoNumbers();
    }


    // 테스트용 코드
    Lotto(LottoNumber... numbers) {
        this.numbers = new HashSet<>();
        this.numbers.addAll(Arrays.asList(numbers));
    }

    private void generateRandomLottoNumbers() {
        this.numbers = RandomNumberGenerator.generateRandomLottoNumbers(TOTAL_COUNT)
                                            .stream()
                                            .map(LottoNumber::new)
                                            .collect(Collectors.toSet());
    }

    public Set<LottoNumber> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return this.numbers.stream()
                           .map(LottoNumber::toString)
                           .collect(Collectors.joining(", ", "[", "]"));
    }
}
