package entity;

public class SaveOneGame {
    private int row;

    @Override
    public String toString() {
        return "SaveOneGame{" +
                "row=" + row +
                ", column=" + column +
                ", value=" + value +
                '}';
    }

    public SaveOneGame(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int column;
    private int value;
}
