package Pieces;

import Board.Board;
import Utils.Movement;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(boolean side, int value, String representation) {
        super(side, value, representation);
    }

    private List<int[]> getAllBishopMovesA(int[] move) {
        Movement movementUtil = new Movement();
        List<int[]> allMovements = new ArrayList<>();
        int x = move[0];
        int y = move[1];
        while (movementUtil.inBounds(x, y)) {
            x--;
            y--;
            if (!allMovements.contains(new int[] {x, y})) { allMovements.add(new int[] {x, y}); }
        }
        return allMovements;
    }

    private List<int[]> getAllBishopMovesB(int[] move) {
        Movement movementUtil = new Movement();
        List<int[]> allMovements = new ArrayList<>();
        int x = move[0];
        int y = move[1];
        while (movementUtil.inBounds(x, y)) {
            x++;
            y++;
            if (!allMovements.contains(new int[] {x, y})) { allMovements.add(new int[] {x, y}); }
        }
        return allMovements;
    }
    private List<int[]> getAllBishopMovesC(int[] move) {
        Movement movementUtil = new Movement();
        List<int[]> allMovements = new ArrayList<>();
        int x = move[0];
        int y = move[1];
        while (movementUtil.inBounds(x, y)) {
            x++;
            y--;
            if (!allMovements.contains(new int[] {x, y})) { allMovements.add(new int[] {x, y}); }
        }
        return allMovements;
    }

    private List<int[]> getAllBishopMovesD(int[] move) {
        Movement movementUtil = new Movement();
        List<int[]> allMovements = new ArrayList<>();
        int x = move[0];
        int y = move[1];
        while (movementUtil.inBounds(x, y)) {
            x--;
            y++;
            if (!allMovements.contains(new int[] {x, y})) { allMovements.add(new int[] {x, y}); }
        }
        return allMovements;
    }

    @Override
    public boolean checkMove(Board board, int[] move, boolean side) {
        Movement movementUtil = new Movement();
        List<int[]> allowedMovements = new ArrayList<>();
        int x, y;

        List<List<int[]>> foo = new ArrayList<>(4);
        foo.add(0, getAllBishopMovesA(move));
        foo.add(1, getAllBishopMovesB(move));
        foo.add(2, getAllBishopMovesC(move));
        foo.add(3, getAllBishopMovesD(move));

        for (List<int[]> ints : foo) {
            for (int[] movement : ints) {
                x = movement[0];
                y = movement[1];
                if (movementUtil.inBounds(x, y)) {
                    System.out.println("(" + x + "," + y + ") " + board.getFigure(x, y).getClass());
                    if (board.getFigure(x, y).getClass().isInstance(new Empty())) {
                        allowedMovements.add(new int[] {x, y});
                    } else {
                        break;
                    }
                }
            }
        }

        return movementUtil.isAllowed(allowedMovements, move);
    }

}


