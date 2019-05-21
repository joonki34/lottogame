package com.kakaopay.lottogame;

import java.util.Objects;

/**
 * @author david.chung
 * @since 2019-05-20
 */
public class LottoNumber {
    private Integer number;

    public LottoNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
