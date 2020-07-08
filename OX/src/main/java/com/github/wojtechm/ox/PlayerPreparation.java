package com.github.wojtechm.ox;

public class PlayerPreparation implements GameState {

    private final Settings settings;

    public PlayerPreparation(Settings settings) {
        this.settings = settings;
    }

    @Override
    public GameState update() {
        Player player = new Player("Ann", 'o');
        Player player2 = new Player("Boromir", 'x');
        Players players = new Players(player, player2);
        return new InitializeGame(settings, players);
    }
}
