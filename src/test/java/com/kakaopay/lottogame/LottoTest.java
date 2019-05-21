package com.kakaopay.lottogame;

import org.junit.Assert;

/**
 * @author david.chung
 * @since 2019-05-22
 */
public class LottoTest {
    @org.junit.Test
    public void 각6개의숫자는랜덤이고중복없음() {
        for (int i = 0; i < 100000; i++) {
            Lotto lotto = new Lotto();
            Assert.assertEquals(6, lotto.getNumbers().size());
            Assert.assertEquals(6, lotto.getNumbers().stream().distinct().count());
        }
    }
}
