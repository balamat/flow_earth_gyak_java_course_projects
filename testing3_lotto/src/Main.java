import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String[] randomFirstName = new String[]{"Péter", "Árpád", "Normann", "Ábel", "Elek", "Bence", "Tibor", "Béla", "Sándor", "László", "Károly", "Ferenc", "Nimród", "Klára", "Judit", "Orsolya", "Anasztázia", "Margit", "Nóra", "Jázmin", "Sára", "Katalin", "Evelin", "Hajnalka"};
        String[] randomLastName = new String[]{"Kovács", "Fazekas", "Érték", "Nagy", "Magyar", "Elekes", "Pálinkás", "Maradi", "Mádéfalvi", "Marton", "Kis", "Horváth", "Salamon", "Halasi", "Lakatos"};
        int minMoney = 10000;
        int maxMoney = 30000;

        //generating random players
        for (int i = 0; i < 350; i++) {
            String fullName = randomLastName[ThreadLocalRandom.current().nextInt(0, randomLastName.length)] + " " + randomFirstName[ThreadLocalRandom.current().nextInt(0, randomFirstName.length)];
            new Player(fullName, ThreadLocalRandom.current().nextInt(minMoney, maxMoney + 1));
        }

        Lottozo lottozoKiskunhalas = new Lottozo();
        Lottery lottery5Week42 = new Lottery(LottoType.ÖTÖSLOTTÓ, new Random());
        Lottery lottery6Week42 = new Lottery(LottoType.HATOSLOTTÓ, new Random());

        Iterator playerIterator = Player.allPlayer.iterator();
        while (playerIterator.hasNext()) {
            Ticket ticket = lottozoKiskunhalas.buyTicket((Player) playerIterator.next(), lottery6Week42);
            while (ticket.getPickedNumbers().size() <5 ) {
                ticket.pick(new Random().nextInt(1, ticket.getTicketType().getUpperLimitOfRange()));
            }
        }

        lottery5Week42.raffle();
        System.out.println(lottery5Week42.getWinningNumbers());
        lottery5Week42.validateAll();
        lottery5Week42.summarize();
        lottery5Week42.calculateWinnings();

        Player.allPlayer.forEach(pl -> pl.distributeWins());
        Player.allPlayer.forEach(System.out::println);

        lottery5Week42.modifyPool();

        System.out.println("-------------------------------------------------");
        List<Player> collectionOfWinners2 = Player.allPlayer.stream().filter(player -> player.getTickets().stream().findFirst().get().getNumberOfWinnings() == 2).collect(Collectors.toList());
        collectionOfWinners2.forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        List<Player> collectionOfWinners3OrMore = Player.allPlayer.stream().filter(player -> player.getTickets().stream().findFirst().get().getNumberOfWinnings() >= 3).collect(Collectors.toList());
        collectionOfWinners3OrMore.forEach(System.out::println);


    }
}