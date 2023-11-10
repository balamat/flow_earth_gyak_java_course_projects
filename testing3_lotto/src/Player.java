import java.util.HashSet;
import java.util.Set;

public class Player {
    public static Set<Player> allPlayer = new HashSet<>();
    private int money;
    private String name;
    private Set<Ticket> tickets = new HashSet<>();


    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        allPlayer.add(this);
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean hasEnoughMoney(int money) {
        return money <= this.money;
    }

    public void distributeWins() {
        this.tickets.forEach(ticket -> this.money += ticket.getMoneyWinnings());
    }

    public void distributeAllWins() {
        for (Player player : allPlayer
        ) {
            player.tickets.forEach(ticket -> this.money += ticket.getMoneyWinnings());
        }
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Player{" +
                "money=" + money +
                ", name='" + name + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
