package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class WinningRanks {
    private static final int WINNING_AMOUNT = 1;
    private static final int DEFAULT_WINNING_TICKET_SIZE = 0;
    private Map<Rank, Integer> winningRanks;

    WinningRanks(Map<Rank, Integer> winningRanks) {
        this.winningRanks = winningRanks;
    }

    public Map<Rank, Integer> getWinningRanks() {
        return winningRanks;
    }

    /* winningTicketSize은 각 Rank별 당첨된 티켓 수를 의미한다. */
    Map<Rank, Integer> addWinningRanks(Rank rank) {
        Integer winningTicketSize = winningRanks.get(rank);
        if (Objects.isNull(winningTicketSize)) {
            winningTicketSize = DEFAULT_WINNING_TICKET_SIZE;
        }

        winningRanks.put(rank, winningTicketSize + WINNING_AMOUNT);
        return winningRanks;
    }

    Money calculateTotalWinningMoney() {
        Money totalWinningMoney = new Money();
        for (Rank rank : winningRanks.keySet()) {
            int size = winningRanks.get(rank);
            Money winningMoney = rank.calculateWinningMoney().multiply(size);
            totalWinningMoney = totalWinningMoney.add(winningMoney);
        }
        return totalWinningMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningRanks that = (WinningRanks) o;
        return Objects.equals(winningRanks, that.winningRanks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningRanks);
    }
}
