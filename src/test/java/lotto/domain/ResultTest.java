package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class ResultTest {
    @Test
    void Result_생성() {
        WinningRanks winningRanks = new WinningRanks(new HashMap() {{
            put(Rank.FOURTH, 2);
            put(Rank.FIFTH, 3);
        }});

        Money purchaseAmount = new Money(14_000);

        assertThat(new Result(winningRanks, purchaseAmount)).isNotNull();
    }


}
