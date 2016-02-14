package javathreads.examples.ch02.example7;

import java.awt.Dimension;
import java.awt.Graphics;

import javathreads.examples.ch02.CharacterDisplayCanvas;
import javathreads.examples.ch02.CharacterEvent;
import javathreads.examples.ch02.CharacterListener;
import javathreads.examples.ch02.CharacterSource;

public class AnimatedCharacterDisplayCanvas extends CharacterDisplayCanvas implements CharacterListener, Runnable {

    private volatile boolean done = false;
    private int curX = 0;

    public AnimatedCharacterDisplayCanvas() {
    }

    public AnimatedCharacterDisplayCanvas(CharacterSource cs) {
        super(cs);
    }

    public synchronized void newCharacter(CharacterEvent ce) {
        curX = 0;
        tmpChar[0] = (char) ce.character;
        repaint();
    }

    protected synchronized void paintComponent(Graphics gc) {
        Dimension d = getSize();
        gc.clearRect(0, 0, d.width, d.height);
        if (tmpChar[0] == 0)
            return;
        int charWidth = fm.charWidth(tmpChar[0]);
        gc.drawChars(tmpChar, 0, 1,
                     curX++, fontHeight);
    }

    @Override
    public void run() {
        while (!done) {
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                return;
            }
        }
    }

    public void setDone(boolean b) {
        done = b;
    }
}