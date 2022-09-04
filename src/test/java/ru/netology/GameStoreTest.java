package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameStoreTest {

  @Test
  public void shouldAddGame() {

    GameStore store = new GameStore();
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

    assertTrue(store.containsGame(game));
  }

  @Test
  public void shouldNotFoundGameWithoutErrors() {
    GameStore store = new GameStore();
    Game game = null;

    assertFalse(store.containsGame(game));
  }

  @Test
  public void shouldAddPlaytimeForExistPlayer() {
    GameStore store = new GameStore();
    store.playedTime.put("Vasya", 11);
    store.addPlayTime("Vasya", 1);

    assertEquals(12, store.playedTime.get("Vasya"));
  }

  @Test
  public void shouldAddPlaytimeForNewPlayer() {
    GameStore store = new GameStore();
    store.addPlayTime("Petya", 1);

    assertEquals(1, store.playedTime.get("Petya"));
  }

  @Test
  public void shouldGetMostActivePlayer() {
    GameStore store = new GameStore();
    store.playedTime.put("Vasya", 11);
    store.playedTime.put("Petya", 10);

    Assertions.assertEquals("Vasya", store.getMostPlayer());
  }

  @Test
  public void shouldGetSumOfPlayedTime() {
    GameStore store = new GameStore();
    store.playedTime.put("Vasya", 11);
    store.playedTime.put("Petya", 10);

    Assertions.assertEquals(21, store.getSumPlayedTime());
  }

  // другие ваши тесты
}