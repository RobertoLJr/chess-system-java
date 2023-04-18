package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        Scanner read = new Scanner(System.in);

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(read);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(read);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
            catch (ChessException e) {
                System.out.println(e.getMessage());
                read.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                read.nextLine();
            }
        }
    }
}