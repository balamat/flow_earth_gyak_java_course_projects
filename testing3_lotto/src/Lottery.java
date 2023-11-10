import java.util.*;

public class Lottery implements Game {

    private static int initialPool = 10000;
    protected int pool;
    protected int income;
    private Set<Integer> winningNumbers = new HashSet<>();
    protected LottoType lottoType;
    protected Map<Integer, Integer> countWinPerCase = new HashMap<>();
    protected static int lastRoundNumber = 1;
    protected int roundNumber;
    Random random;


    public Lottery(LottoType ticketType, Random random) {
        this.lottoType = ticketType;
        this.roundNumber = Lottery.lastRoundNumber++;
        this.random = random;
        this.pool += Lottery.initialPool;
    }

    public Lottery(Random random) {
        this.random = random;
    }

    @Override
    public void raffle() {
        this.winningNumbers.clear();
        while (winningNumbers.size() < this.lottoType.getNumberOfChoosenNumbers()) {
            int tempRnd = this.random.nextInt(1, this.lottoType.getUpperLimitOfRange());
            if (!winningNumbers.contains(tempRnd)) {
                winningNumbers.add(tempRnd);
            }
        }
    }

    @Override
    public void summarize() {
        Ticket.allTickets
                .forEach(ticket -> {
                    int nmb = this.countWinPerCase.getOrDefault(ticket.getNumberOfWinnings(), 0);
                    nmb++;
                    this.countWinPerCase.put(ticket.getNumberOfWinnings(), nmb);
                });
    }


    public void modifyPool() {
        this.pool = initialPool - (Ticket.allTickets.stream()
                .map(i -> i.getMoneyWinnings() - i.getTicketType().getTicketPrice())
                .mapToInt(k -> k)
                .sum());
    }

    /**
     * check how many picked numbers of a ticket match the lottery numbers
     *
     * @param ticket
     * @return the number of hits
     */
    @Override
    public int validate(Ticket ticket) {
        Set<Integer> intersection = new HashSet<>();
        intersection.clear();
        intersection.addAll(this.winningNumbers);
        intersection.retainAll(ticket.getPickedNumbers());
        ticket.setNumberOfWinnings(intersection.size());
        this.income += ticket.getTicketType().getTicketPrice();
        return intersection.size();
    }


    public void validateAll() {
        Ticket.allTickets.forEach(ticket -> validate(ticket));
    }

    public void calculateWinnings() {
        for (Ticket ticket : Ticket.allTickets
        ) {
            Integer winCasePerHit = this.countWinPerCase.get(ticket.getNumberOfWinnings());
            double payByHit = this.income * this.lottoType.getPercentageOfIncome()[ticket.getNumberOfWinnings()];
            double pay = payByHit / winCasePerHit;

            if (ticket.getNumberOfWinnings() == this.lottoType.getNumberOfChoosenNumbers()) {
                pay += (pool / this.countWinPerCase.get(this.lottoType.getNumberOfChoosenNumbers()));
            }
            ticket.setMoneyWinnings((int) pay);
        }
    }

    public void setLottoType(LottoType lottoType) {
        this.lottoType = lottoType;
    }

    public LottoType getLottoType() {
        return lottoType;
    }

    public Map<Integer, Integer> getCountWinPerCase() {
        return countWinPerCase;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
