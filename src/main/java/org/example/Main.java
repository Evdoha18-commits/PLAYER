package org.example;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Player alice = new Player(1, "Alice", 10);
        Player bob = new Player(2, "Bob", 5);
        Player charlie = new Player(3, "Charlie", 10);

        game.register(alice);
        game.register(bob);
        game.register(charlie);

        System.out.println("Alice vs Bob: " + game.round("Alice", "Bob"));       // 1
        System.out.println("Bob vs Charlie: " + game.round("Bob", "Charlie"));   // 2
        System.out.println("Alice vs Charlie: " + game.round("Alice", "Charlie")); // 0

        try {
            game.round("Alice", "Unknown");
        } catch (NotRegisteredException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}