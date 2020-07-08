package com.github.wojtechm.ox;

import java.util.Arrays;
import java.util.List;

class Players {
    private final List<Player> players;
    int currentPlayerIndex = 0;

    Players(Player p1, Player p2) {
        players = Arrays.asList(p1, p2);
    }

    public void updateCurrentPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public String getCurrentPlayerName() {
        return players.get(currentPlayerIndex).name;
    }

    public char getCurrentPlayerSymbol() {
        return players.get(currentPlayerIndex).symbol;
    }
}
