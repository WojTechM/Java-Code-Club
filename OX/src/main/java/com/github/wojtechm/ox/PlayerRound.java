package com.github.wojtechm.ox;

public class PlayerRound implements GameState {

    private final Players players;
    private final Board board;
    private final Settings settings;

    public PlayerRound(Players players, Board board, Settings settings) {
        this.players = players;
        this.board = board;
        this.settings = settings;
    }

    @Override
    public GameState update() {
        int placeToMark = InputProvider.INSTACE.getInt();
        return new Referee(settings, players, board, placeToMark);
    }
}
