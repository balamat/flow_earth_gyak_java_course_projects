import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LottozoTest {
    Lottozo testLottozo;

    Player mockPlayer = mock(Player.class);

    Lottery mockLottery = mock(Lottery.class);


    @BeforeEach
    void setUp() {
        this.testLottozo = new Lottozo();
        this.mockPlayer = new Player("Béla", 100);
        when(mockLottery.getLottoType()).thenReturn(LottoType.ÖTÖSLOTTÓ);
    }

    @Test
    void shouldReturnNullBecauseHasNotEnoughMoneyToBuy(
    ) {
        assertNull(this.testLottozo.buyTicket(mockPlayer, mockLottery), "nem null-t ad vissza!");
    }

    @Test
    void shouldReturnTrueBecauseHasEnoughMoneyToBuy(
    ) {
        this.mockPlayer.setMoney(1000);
        assertEquals(600, this.testLottozo.buyTicket(mockPlayer, mockLottery).getPlayer().getMoney(), "nem ad vissza jegyet");
    }


}
