package dat.routes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoemRoutesTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFivePlusFive() {
        assertEquals(10, 5 + 5);
    }

    @Test
    void testThatFails() {
        assertEquals(10, 5 + 6);
    }
}