package com.github.wojtechm.ox;

public class Referee implements GameState {

    private final Settings settings;
    private final Players players;
    private final Board board;
    private final int placeToMark;

    public Referee(Settings settings, Players players, Board board, int placeToMark) {
        this.settings = settings;
        this.players = players;
        this.board = board;
        this.placeToMark = placeToMark;
    }

    @Override
    public GameState update() {
        if (markCannotBePlaced()) {
            return new PlayerRound(players, board, settings);
        }
        board.markAtPoint(placeToMark, players.getCurrentPlayerSymbol());
        players.updateCurrentPlayer();
        return new Printer(board, players, settings);
    }

    private boolean markCannotBePlaced() {
        try {
            char c = board.symbolAt(placeToMark);
            if (c != 0) {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
