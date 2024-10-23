package main.java;

import javax.swing.*;
import java.awt.*;

public class Display extends JLabel {
    // start at index 1, because 0 is for the minus of the first number
    int indexCounter = 0;

    // Only the first box is directly stored in the object display and other boxes
    // are only stored in the box before theme
    Box firstBox = null;
    Box lastBox = null;

    public Display() {
        this.setFont(new Font("Arial", Font.PLAIN, 32));
    }

    public void createBox(char symbol) {
        indexCounter++;
        Box box = new Box(this.indexCounter, symbol, this.lastBox , null);
        if (lastBox != null) this.lastBox.setAfterwards(box);
        if (indexCounter == 1) this.firstBox = box;
        this.lastBox = box;
    }

    public String getSymbolString() {
        if (firstBox != null) {
            return firstBox.getSymbolRecursively();
        } else {
            return "";
        }
    }

    public void deleteLast() {
        if (lastBox == null) {
            clear();
        } else if (lastBox.getPrevious() == null) {
            clear();
        } else {
            lastBox = lastBox.getPrevious();
            lastBox.setAfterwards(null);
            indexCounter--;
        }
    }

    public void refresh() {
        this.setText(this.getSymbolString());
    }

    public void setResult(double number) {
        this.setText(String.valueOf(number));
    }

    public void clear() {
        indexCounter = 0;
        firstBox = null;
        lastBox = null;
    }
}
