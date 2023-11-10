import java.util.HashSet;
import java.util.Set;

public class Ticket {

    //    protected int range;

    //the last serialnumber
    protected static Set<Ticket> allTickets = new HashSet<>();
    protected static int lastSerialNumber = 1;
    protected int serialNumber;
    protected LottoType ticketType;
    protected Set<Integer> pickedNumbers = new HashSet<>();
    protected int numberOfWinnings;
    protected int moneyWinnings;
    protected Player player;


    public Ticket() {
        this.serialNumber = Ticket.lastSerialNumber++;
        Ticket.allTickets.add(this);
            }

    public Ticket(LottoType ticketType) {
        this.serialNumber = Ticket.lastSerialNumber++;
        this.ticketType = ticketType;
        Ticket.allTickets.add(this);
            }

    public Ticket(LottoType ticketType, Player player) {
        this.serialNumber = Ticket.lastSerialNumber++;
        this.ticketType = ticketType;
        this.player = player;
        this.player.getTickets().add(this);
        Ticket.allTickets.add(this);
    }

    public Ticket pick(Integer number) {
        if (!this.pickedNumbers.contains(number)) {
            this.pickedNumbers.add(number);
        }
        return this;
    }

    public static int getLastSerialNumber() {
        return lastSerialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public LottoType getTicketType() {
        return ticketType;
    }

    public void setTicketType(LottoType ticketType) {
        this.ticketType = ticketType;
    }

    public Set<Integer> getPickedNumbers() {
        return pickedNumbers;
    }

    public int getNumberOfWinnings() {
        return numberOfWinnings;
    }

    public void setNumberOfWinnings(int numberOfWinnings) {
        this.numberOfWinnings = numberOfWinnings;
    }

    public int getMoneyWinnings() {
        return moneyWinnings;
    }

    public void setMoneyWinnings(int moneyWinnings) {
        this.moneyWinnings = moneyWinnings;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "serialNumber=" + serialNumber +
                ", ticketType=" + ticketType +
                ", pickedNumbers=" + pickedNumbers +
                ", numberOfWinnings=" + numberOfWinnings +
                ", moneyWinnings=" + moneyWinnings +
                '}';
    }
}
