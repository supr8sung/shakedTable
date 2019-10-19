package com.xebia.fs101.xtable;

public class TableLayoutManager {

    private int tableWidth;
    private int rowCount;
    private int colCount;

    TableLayoutManager(int rowCount, int colCount) {
        tableWidth = TableConstants.maxColWidth * colCount;
        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    private String createTopLine() {
        StringBuilder top = new StringBuilder();
        for (int i = 1; i <= tableWidth; i++) {
            if (i == 1)
                top.append(TableConstants.topLeft);
            if (i == tableWidth)
                top.append(TableConstants.topRight);
            else if (i % TableConstants.maxColWidth == 0)
                top.append(TableConstants.topMiddle);
            else
                top.append(TableConstants.mid);
        }
        return top.toString();

    }

    private String createBottomLine() {
        StringBuilder bottom = new StringBuilder();
        bottom.append("\n");
        for (int i = 1; i <= tableWidth; i++) {
            if (i == 1)
                bottom.append(TableConstants.bottomLeft);
            if (i == tableWidth)
                bottom.append(TableConstants.bottomRight);
            else if (i % TableConstants.maxColWidth == 0)
                bottom.append(TableConstants.bottomMiddle);
            else
                bottom.append(TableConstants.mid);
        }
        return bottom.toString();
    }

    private String createRowSeparator() {
        StringBuilder rowSeparator = new StringBuilder();
        rowSeparator.append("\n" + TableConstants.leftMid);
        for (int i = 1; i < tableWidth; i++) {
            if (i % TableConstants.maxColWidth == 0)
                rowSeparator.append(TableConstants.midMid);
            else
                rowSeparator.append(TableConstants.mid);
        }
        rowSeparator.append(TableConstants.rightMid);
        return rowSeparator.toString();
    }

    private String createTabularStruct() {
        StringBuilder tableData = new StringBuilder();

        for (int j = 1; j <= rowCount; j++) {
            tableData.append("\n" + TableConstants.verticalSeparator);
            for (int i = 1; i < tableWidth; i++) {
                if (i % TableConstants.maxColWidth == 0)
                    tableData.append(TableConstants.verticalSeparator);
                else
                    tableData.append(" ");
            }
            tableData.append(TableConstants.verticalSeparator);
            if (j == rowCount)
                break;
            tableData.append(createRowSeparator());
        }

        return tableData.toString();

    }

    public String createTable() {
        return this.createTopLine() + this.createTabularStruct() + this.createBottomLine();
    }


}