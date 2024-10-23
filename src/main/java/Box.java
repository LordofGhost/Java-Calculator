package main.java;

public class Box {
    int index;
    char symbol;
    Box previous;
    Box afterwards;

    public Box(int index, char symbol, Box previous, Box afterwards) {
        this.index = index;
        this.symbol = symbol;
        this.previous = previous;
        this.afterwards = afterwards;
    }

    /// ## Index
    /// The index specify the order of the boxes
    /// ### Change order
    /// If one box is removed or added, all boxes that have the same or higher index than the new box has to be changed.
    ///
    /// To make this process simple, only the box after the new one has to be called and that one automatically calls
    /// one after it and this goes and on to the last box.

    public void increaseIndex() {
        this.index++;
        try {
            previous.increaseIndex();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void decreaseIndex() {
        this.index--;
        try {
            previous.decreaseIndex();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /// search for the box by index, return this if the index matches else ask the box afterward
    /// in case the index not exist null is returned

    public Box searchByIndex(int index) {
        if (this.index == index) {
            return this;
        } else if (this.index > index) {
            return null;
        } else {
            return this.afterwards.searchByIndex(index);
        }
    }

    public int getIndex() {
        return this.index;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getSymbolRecursively() {
        if (this.afterwards != null) {
            return this.symbol + this.afterwards.getSymbolRecursively();
        } else {
            return Character.toString(this.symbol);
        }
    }

    /**
     The Display works by caned together box objects, to make it work, does every box store the before und behind box of her
     * @param previous the box before this one
     */

    public void setPrevious(Box previous) {
        this.previous = previous;
    }

    public Box getPrevious() {
        try {
            return this.previous;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param afterwards the box behind this one
     */

    public void setAfterwards(Box afterwards) {
        this.afterwards = afterwards;
    }

    public Box getAfterwards() {
        try {
            return this.afterwards;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
