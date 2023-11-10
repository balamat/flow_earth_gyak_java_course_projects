import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {
    Ticket testTicket;      //Ticket objektum, mint adattag

    @BeforeEach
    void setUp() {
        this.testTicket = new Ticket(LottoType.ÖTÖSLOTTÓ);
        this.testTicket.pick(1).pick(2).pick(3).pick(4).pick(5);
    }

    @Test
    void TicketLottery5ShouldBeHavePerfectSize() {
        assertEquals(5, testTicket.getPickedNumbers().size(), "Nem megfelelő hosszú a random sorsjegy!");
    }


}
