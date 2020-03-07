package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LottosGenerator {
    private static final List<LottoNumber> lottoNumbersInBox = LottoNumberBox.get();
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int ONE = 1;

    static Lottos generateAutomatically(int lottosSize) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottosSize; i++) {
            Set<LottoNumber> lottoNumbers = generateLottoNumbersAutomatically();
            lottos.add(new Lotto(lottoNumbers));
        }
        return new Lottos(lottos);
    }

    private static Set<LottoNumber> generateLottoNumbersAutomatically() {
        Collections.shuffle(lottoNumbersInBox);
        return new HashSet<>(
                Collections.unmodifiableCollection(lottoNumbersInBox.subList(ONE, ONE + LOTTO_NUMBER_SIZE)));
    }

    static Lottos generateManually(List<Set<LottoNumber>> lottoNumbersBasket) {
        List<Lotto> lottos = new ArrayList<>();
        for (Set<LottoNumber> lottoNumbers : lottoNumbersBasket) {
            lottos.add(new Lotto(lottoNumbers));
        }
        return new Lottos(lottos);
    }
}
