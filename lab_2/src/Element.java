/**
 * This class represents elements of a matrix.
 * It stores element's value and indices.
 */

public class Element {
    private int value;
    private int row;
    private int column;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int i) {
        this.row = i;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int j) {
        this.column = j;
    }
}