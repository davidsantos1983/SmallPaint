package org.academiadecodigo.naderthals;

//import org.academiadecodigo.simplegraphics.graphics.Color;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Rectangle frame;

    public static final int CELL_SIZE = 20;

    public static final int frameWidth = 600;
    public static final int frameHeight = 600;
    public  static final int PADDING = 10;
    public static final int squaresPerRow = frameHeight/CELL_SIZE;
    public static final int squaresPerCol = frameWidth/CELL_SIZE;


    public Grid() {

        frame = new Rectangle(PADDING, PADDING, frameWidth, frameHeight);
        frame.draw();

        Cursor cursor = new Cursor();

        //Squares squares = new Squares();
    }


}
