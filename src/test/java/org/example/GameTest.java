package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void roundPlayer1Wins() {
        game.register(new Player(1, "Alice", 10));
        game.register(new Player(2, "Bob", 5));

        assertEquals(1, game.round("Alice", "Bob"));
    }

    @Test
    void roundPlayer2Wins() {
        game.register(new Player(1, "Alice", 5));
        game.register(new Player(2, "Bob", 10));

        assertEquals(2, game.round("Alice", "Bob"));
    }

    @Test
    void roundDraw() {
        game.register(new Player(1, "Alice", 7));
        game.register(new Player(2, "Bob", 7));

        assertEquals(0, game.round("Alice", "Bob"));
    }

    @Test
    void roundThrowsWhenPlayer1NotRegistered() {
        game.register(new Player(2, "Bob", 10));

        assertThrows(NotRegisteredException.class,
                () -> game.round("Alice", "Bob"));
    }

    @Test
    void roundThrowsWhenPlayer2NotRegistered() {
        game.register(new Player(1, "Alice", 10));

        assertThrows(NotRegisteredException.class,
                () -> game.round("Alice", "Bob"));
    }

    @Test
    void roundThrowsWhenBothNotRegistered() {
        assertThrows(NotRegisteredException.class,
                () -> game.round("Alice", "Bob"));
    }

    @Test
    void findByNameReturnsPlayerFoundOnSecondPosition() {
        game.register(new Player(1, "Alice", 5));
        game.register(new Player(2, "Bob", 10));
        game.register(new Player(3, "Charlie", 7));

        assertEquals(2, game.round("Alice", "Bob"));
    }
}
