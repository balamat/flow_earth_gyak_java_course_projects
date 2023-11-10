import java.util.Set;

public interface Game {

    //generate the new winning numbers;
    public void raffle();

    //gather the number of winning tickets of each category
    public void summarize();

    //set the number of winning numbers of a given ticket
    public int validate(Ticket ticket);

}
