package com.xebia.fs101.xtable;

import java.util.List;
import static com.xebia.fs101.xtable.TableConstants.*;

public abstract class LayoutManager {
    protected int tableWidth;
    public int rowCount;
    public int colCount;
    protected int colWidth;
    protected final int START_POSITION=1;

    public String createTable()
    {
        validate();
        tableWidth = MAX_COL_WIDTH * colCount;
        colWidth = MAX_COL_WIDTH;
        return this.createTopLine() + this.createTableStructure() + this.createBottomLine();
    }
    public abstract String createTableWithHeadersOnly(String[] headers);

    public abstract String createDataTable(List<String[]> rows);

    protected String createTopLine() {
        StringBuilder top = new StringBuilder();
        for (int i = 1; i <= tableWidth; i++) {
            if (i == START_POSITION)
                top.append(TOP_LEFT);
            if (i == tableWidth)
                top.append(TOP_RIGHT);
            else if (i % colWidth == 0)
                top.append(TOP_MIDDLE);
            else
                top.append(MID);
        }
        return top.toString();

    }
    protected String createBottomLine() {
        StringBuilder bottom = new StringBuilder();
        bottom.append("\n");
        for (int i = 1; i <= tableWidth; i++) {
            if (i == START_POSITION)
                bottom.append(BOTTOM_LEFT);
            if (i == tableWidth)
                bottom.append(BOTTOM_RIGHT);
            else if (i % colWidth == 0)
                bottom.append(BOTTOM_MIDDLE);
            else
                bottom.append(MID);
        }
        return bottom.toString();
    }

    protected String createTableStructure() {
        StringBuilder tableData = new StringBuilder();
        for (int j = 1; j <= rowCount; j++) {
            tableData.append("\n" + VERTICAL_SEPARATOR);
            for (int i = 1; i < tableWidth; i++) {
                if (i % colWidth == 0)
                    tableData.append(VERTICAL_SEPARATOR);
                else
                    tableData.append(" ");
            }
            tableData.append(VERTICAL_SEPARATOR);
            if (j == rowCount)
                break;
            tableData.append(createRowSeparator());
        }

        return tableData.toString();

    }

    protected String createRowSeparator() {
        StringBuilder rowSeparator = new StringBuilder();
        rowSeparator.append("\n" + LEFT_MID);
        for (int i = 1; i < tableWidth; i++) {
            if (i % colWidth == 0)
                rowSeparator.append(MID_MID);
            else
                rowSeparator.append(MID);
        }
        rowSeparator.append(RIGHT_MID);
        return rowSeparator.toString();
    }


    protected int computeWidth(String[] headers) {
        int maxWidth = Integer.MIN_VALUE;

        for (String header : headers) {
            maxWidth = Math.max(maxWidth, header.length());

        }
        return maxWidth;
    }

    protected int computeWidth(List<String[]> rows) {
        int maxWidth = Integer.MIN_VALUE;
        for (String[] cells : rows) {
            for (int i = 0; i < cells.length; i++) {

                maxWidth = Math.max(maxWidth, cells[i].length());
            }
        }
        return maxWidth;
    }

    private void validate()
    {
        if(rowCount<0 ||colCount<0)
            throw new IllegalArgumentException("Row and col should be greater than 0");
    }

}