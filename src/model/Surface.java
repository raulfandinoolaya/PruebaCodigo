package model;

/**
 * Created by FAMILIA on 25/12/13.
 */
public class Surface {

    private int numberRows;
    private int numberColumns;

    public Surface (int row, int column){
        setNumberRows(row);
        setNumberColumns(column);
    }

    public int getNumberRows() {
        return numberRows;
    }

    public void setNumberRows(int numberRows) {
        this.numberRows = numberRows;
    }

    public int getNumberColumns() {
        return numberColumns;
    }

    public void setNumberColumns(int numberColumns) {
        this.numberColumns = numberColumns;
    }
}
