import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LotteryTest {
    Random mockRandom = mock(Random.class);
    Lottery testLotto;

    Ticket mockTicket = mock(Ticket.class);

    @BeforeEach
    void setUp() {
        this.testLotto = new Lottery(mockRandom);
        this.testLotto.setLottoType(LottoType.ÖTÖSLOTTÓ);
        this.testLotto.pool = 10000;
        when(this.mockRandom.nextInt(1, this.testLotto.lottoType.getUpperLimitOfRange()))
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(4)
                .thenReturn(5);
        this.testLotto.raffle();
    }

    @Test
    void setUpAndValidate6Hits() {
        this.testLotto = new Lottery(mockRandom);
        this.testLotto.setLottoType(LottoType.HATOSLOTTÓ);
        when(this.mockRandom.nextInt(1, this.testLotto.lottoType.getUpperLimitOfRange()))
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(4)
                .thenReturn(5)
                .thenReturn(6);
        this.testLotto.raffle();

        Ticket testTicket = new Ticket(LottoType.HATOSLOTTÓ);
        for (int i = 1; i <= this.testLotto.lottoType.getNumberOfChoosenNumbers(); i++) {
            testTicket.pick(i);
        }
        assertEquals(6, this.testLotto.validate(testTicket));
    }

    @Test
    void validate5Hits() {
        Ticket testTicket = new Ticket(this.testLotto.lottoType);
        for (int i = 1; i <= this.testLotto.lottoType.getNumberOfChoosenNumbers(); i++) {
            testTicket.pick(i);
        }
        assertEquals(5, this.testLotto.validate(testTicket));
    }

    @Test
    void validate4Hits() {
        Ticket testTicket = new Ticket(this.testLotto.lottoType);
        for (int i = 2; i <= this.testLotto.lottoType.getNumberOfChoosenNumbers(); i++) {
            testTicket.pick(i);
        }
        assertEquals(4, this.testLotto.validate(testTicket));
    }

    @Test
    void validate3Hits() {
        Ticket testTicket = new Ticket(this.testLotto.lottoType);
        for (int i = 3; i <= this.testLotto.lottoType.getNumberOfChoosenNumbers(); i++) {
            testTicket.pick(i);
        }
        assertEquals(3, this.testLotto.validate(testTicket));
    }

    @Test
    void validate2Hits() {
        Ticket testTicket = new Ticket(this.testLotto.lottoType);
        for (int i = 4; i <= this.testLotto.lottoType.getNumberOfChoosenNumbers(); i++) {
            testTicket.pick(i);
        }
        assertEquals(2, this.testLotto.validate(testTicket));
    }

    @Test
    void validateNoHits() {
        Ticket testTicket = new Ticket(this.testLotto.lottoType);
        for (int i = 6; i <= this.testLotto.lottoType.getNumberOfChoosenNumbers(); i++) {
            testTicket.pick(i);
        }
        assertEquals(0, this.testLotto.validate(testTicket));
    }

    @Test
    void shouldSummarise() {
        Ticket.allTickets.clear();
        Ticket testTicket1 = new Ticket(this.testLotto.lottoType);
        testTicket1.pick(1).pick(2).pick(3).pick(4).pick(5);
        Ticket testTicket2 = new Ticket(this.testLotto.lottoType);
        testTicket2.pick(1).pick(2).pick(3).pick(52).pick(53);
        Ticket testTicket3 = new Ticket(this.testLotto.lottoType);
        testTicket3.pick(1).pick(50).pick(51).pick(52).pick(53);
        Ticket testTicket4 = new Ticket(this.testLotto.lottoType);
        testTicket4.pick(1).pick(50).pick(51).pick(52).pick(53);
        testLotto.validateAll();
        testLotto.summarize();
        assertEquals(1, testLotto.getCountWinPerCase().get(5));
        assertEquals(1, testLotto.getCountWinPerCase().get(3));
        assertEquals(2, testLotto.getCountWinPerCase().get(1));
    }

    @Test
    void shouldTicketWinCertainMoney() {
        Ticket.allTickets.clear();
        Ticket testTicket1 = new Ticket(this.testLotto.lottoType);
        testTicket1.pick(1).pick(2).pick(3).pick(4).pick(5);
        Ticket testTicket2 = new Ticket(this.testLotto.lottoType);
        testTicket2.pick(1).pick(2).pick(3).pick(52).pick(53);
        Ticket testTicket3 = new Ticket(this.testLotto.lottoType);
        testTicket3.pick(1).pick(2).pick(3).pick(52).pick(53);
        Ticket testTicket4 = new Ticket(this.testLotto.lottoType);
        testTicket4.pick(1).pick(2).pick(3).pick(52).pick(53);
        Ticket testTicket5 = new Ticket(this.testLotto.lottoType);
        testTicket5.pick(1).pick(50).pick(51).pick(52).pick(53);
        testLotto.validateAll();
        testLotto.summarize();
        testLotto.calculateWinnings();
        assertEquals(10860, testTicket1.getMoneyWinnings());
        assertEquals(80, testTicket2.getMoneyWinnings());
        assertEquals(0, testTicket5.getMoneyWinnings());
    }

    @Test
    void shouldModifyPool() {
        Ticket.allTickets.clear();
        Ticket testTicket1 = new Ticket(this.testLotto.lottoType);
        //hit 5 - steal the pool!
        testTicket1.pick(1).pick(2).pick(3).pick(4).pick(5);
        //hit 3
        Ticket testTicket2 = new Ticket(this.testLotto.lottoType);
        testTicket2.pick(1).pick(2).pick(3).pick(52).pick(53);
        //hit 3
        Ticket testTicket3 = new Ticket(this.testLotto.lottoType);
        testTicket3.pick(1).pick(2).pick(3).pick(52).pick(53);
        Ticket testTicket4 = new Ticket(this.testLotto.lottoType);
        //hit 3
        testTicket4.pick(1).pick(2).pick(3).pick(52).pick(53);
        Ticket testTicket5 = new Ticket(this.testLotto.lottoType);
        //hit 1 - pays nothing
        testTicket5.pick(1).pick(50).pick(51).pick(52).pick(53);
        testLotto.validateAll();
        testLotto.summarize();
        testLotto.calculateWinnings();
        testLotto.modifyPool();
        assertEquals(900, this.testLotto.pool);
    }

}

