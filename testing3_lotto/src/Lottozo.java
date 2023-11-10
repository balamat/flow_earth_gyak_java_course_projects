import java.util.List;

public class Lottozo {

    public Ticket buyTicket(Player player, Lottery lottery) {
        if (player.hasEnoughMoney(lottery.getLottoType().getTicketPrice())) {
            player.setMoney(player.getMoney() - lottery.getLottoType().getTicketPrice());
            return new Ticket(lottery.getLottoType(), player);
        } else {
            System.out.println("Nincs " + player.getName() + " játékosnak újabb lottószelvényre pénze! Game over!");
            return null;
        }
    }


}
