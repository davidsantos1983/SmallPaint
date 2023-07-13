package org.academiadecodigo.nanderthals;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;

public class LoadClearSaveCommands implements KeyboardHandler{

    private Keyboard keyboard;
    private Squares squares;

    public LoadClearSaveCommands() {

            keyboard = new Keyboard(this);
            addKeyboard();
    }

    private void addKeyboard() {

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(clear);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int keyPressed = keyboardEvent.getKey();

        if (keyPressed == KeyboardEvent.KEY_C) {

            clearSquares();

        }
        if (keyPressed == KeyboardEvent.KEY_L) {
            //Read file to get saved file and put it on grid How???
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("save.txt"));

                for (int i = 0; i < squares.getSquares().size(); i++) {
                    if (bufferedReader.read() == 1) {
                        squares.getSquares().get(i).setColor(Color.RED);
                        squares.getSquares().get(i).fill();
                        continue;
                    }
                    squares.getSquares().get(i).setColor(Color.BLACK);
                }
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (keyPressed == KeyboardEvent.KEY_S) {

            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("save.txt"));

                for (Rectangle square : squares.getSquares()) {
                    bufferedWriter.write(0);
                }
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void clearSquares(){
        for (int i = 0; i < squares.getSquares().size(); i++) {
            squares.getSquares().get(i).setColor(Color.BLACK);
            squares.getSquares().get(i).draw();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
