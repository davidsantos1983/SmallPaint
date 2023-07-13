package org.academiadecodigo.nanderthals;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.util.ArrayList;
import java.util.List;
import static org.academiadecodigo.nanderthals.Grid.*;

public class Squares {


    private List<Rectangle> squares = new ArrayList<>();


    public Squares() {

        for (int row = 0; row < squaresPerRow; row++) {
            for (int col = 0; col < squaresPerCol; col++) {
                int x = col * 20;
                int y = row * 20;

                Rectangle square = new Rectangle(x + PADDING, y + PADDING, CELL_SIZE, CELL_SIZE);
                square.draw();
                squares.add(square);
            }
        }
    }
    public List<Rectangle> getSquares(){

        return squares;
    }


}


