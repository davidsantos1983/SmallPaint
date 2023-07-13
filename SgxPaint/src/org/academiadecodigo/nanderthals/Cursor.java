package org.academiadecodigo.nanderthals;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;

import static org.academiadecodigo.nanderthals.Grid.*;

public class Cursor implements KeyboardHandler {

    private final Rectangle cursor;
    private final int cursorWidth = CELL_SIZE;
    private final int cursorHeight = CELL_SIZE;
    private final Keyboard keyboard;


    public Cursor() {

        keyboard = new Keyboard(this);
        addKeyboard();

        cursor = new Rectangle((float) frameWidth / 2 - (float) CELL_SIZE / 2, (float) frameHeight / 2 - (float) CELL_SIZE / 2, cursorWidth, cursorHeight);
        cursor.setColor(Color.GREEN);
        cursor.draw();
        cursor.fill();

    }

    public Rectangle getCursor() {
        return cursor;
    }

    public void addKeyboard() {

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent paint = new KeyboardEvent();
        paint.setKey(KeyboardEvent.KEY_SPACE);
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(paint);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(clear);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);

        KeyboardEvent erase = new KeyboardEvent();
        erase.setKey(KeyboardEvent.KEY_E);
        erase.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(erase);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int keyPressed = keyboardEvent.getKey();

        if (keyPressed == KeyboardEvent.KEY_LEFT) {
            if (cursor.getX() > CELL_SIZE) {
                cursor.translate(-CELL_SIZE, 0);
            }
        }
        if (keyPressed == KeyboardEvent.KEY_RIGHT) {
            if (cursor.getX() < frameWidth - CELL_SIZE) {
                cursor.translate(CELL_SIZE, 0);
            }
        }
        if (keyPressed == KeyboardEvent.KEY_DOWN) {
            if (cursor.getY() < frameHeight - CELL_SIZE) {
                cursor.translate(0, CELL_SIZE);
            }
        }
        if (keyPressed == KeyboardEvent.KEY_UP) {
            if (cursor.getY() > CELL_SIZE) {
                cursor.translate(0, -CELL_SIZE);
            }
        }
        if (keyPressed == KeyboardEvent.KEY_SPACE) {



        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }






}


