package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн2", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);
        player.installGame(game2);
        player.play(game1, 2);

        int expected = 5;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

//    @Test
//    public void shouldSumGenreIfNoGame() {
//        GameStore store = new GameStore();
//        Game game1 = null;
//
//        Player player = new Player("Petya");
//        player.installGame(game1);
//        player.play(game1, 3);
//
//        int expected = 0;
//        int actual = player.sumGenre(game1.getGenre());
//        assertEquals(expected, actual);
//    }

    @Test
    public void shouldPlay() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);


        int expected = 3;
        int actual = player.play(game, 3);
        ;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayIfGameNotInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        Assertions.assertThrows(RuntimeException.class, () -> {
            player.play(game, 3);
        });
    }


    @Test
    public void shouldInstallGameIfNotInstalled() {
        GameStore store = new GameStore();
        Player player = new Player("Petya");
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Map<Game, Integer> playedTime = new HashMap<>();

        player.installGame(game);

        Map<Game, Integer> expected = new HashMap<>() {{
            put(game, 0);
        }};
        Map actual = player.playedTime;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldInstallGameIfInstalled() {
        GameStore store = new GameStore();
        Player player = new Player("Petya");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Арк1ады");
        Map<Game, Integer> playedTime = new HashMap<>();

        player.installGame(game1);
        player.installGame(game2);

        Map expected = new HashMap<>() {{
            put(game1, 0);
            put(game2, 0);
        }};
        Map actual = player.playedTime;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);


        Game expected = game;
        Game actual = player.mostPlayerByGenre(game.getGenre());

        assertEquals(expected, actual);
    }
}
