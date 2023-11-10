import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    Player testplayer;

    @BeforeEach
    void setUp() {
        this.testplayer = new Player("test player", 1234);
    }

    @Test
    void hasEnoughMoney() {
        assertFalse(this.testplayer.hasEnoughMoney(9999));
        assertTrue(this.testplayer.hasEnoughMoney(121));
    }

    @Test
    void hasJustEnoughMoney() {
        assertTrue(this.testplayer.hasEnoughMoney(1234));
    }





}
