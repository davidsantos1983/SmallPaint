package org.academiadecodigo.nanderthals;

//import org.academiadecodigo.simplegraphics.graphics.Color;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Rectangle frame;
    public static final int CELL_SIZE = 20;
    public static final int frameWidth = 600;
    public static final int frameHeight = 600;
    public  static final int PADDING = 10;
    public static final int squaresPerRow = frameHeight/CELL_SIZE;
    public static final int squaresPerCol = frameWidth/CELL_SIZE;
    public Squares squares;
    public Cursor cursor;


    public Grid() {

        frame = new Rectangle(PADDING, PADDING, frameWidth, frameHeight);
        frame.draw();

        cursor = new Cursor();

        squares = new Squares();
    }

    public void paintSquare(){
        for (int i = 0; i < squares.getSquares().size(); i++) {
            if(cursor.getCursor().getX() == squares.getSquares().get(i).getX() && cursor.getCursor().getY() == squares.getSquares().get(i).getY()){
                squares.getSquares().get(i).setColor(Color.RED);
                squares.getSquares().get(i).fill();
            }
        }
    }

    public void deleteSquare(){
        for (int i = 0; i < squares.getSquares().size(); i++) {
            if(cursor.getCursor().getX() == squares.getSquares().get(i).getX() && cursor.getCursor().getY() == squares.getSquares().get(i).getY()){
                squares.getSquares().get(i).setColor(Color.BLACK);
                squares.getSquares().get(i).draw();
            }
        }
    }
}
