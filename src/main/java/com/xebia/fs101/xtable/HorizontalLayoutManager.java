package com.xebia.fs101.xtable;

import java.util.List;

public class HorizontalLayoutManager implements LayoutManager {

    private int tableWidth;
    private int rowCount;
    private int colCount;
    private int colWidth;
    public static final String ANSI_RED = "\u001B[31m";


    HorizontalLayoutManager(int rowCount, int colCount) {

        this.rowCount = rowCount;
        this.colCount = colCount;

    }

    @Override
    public String createDataTable(List<String[]> rows) {

        colWidth = computeWidth(rows) + 2;
        tableWidth = colWidth * colCount;
        return this.createTopLine() + this.createTabularStruct(rows) + this.createBottomLine();
    }

    @Override
    public String createTable() {

        tableWidth = TableConstants.maxColWidth * colCount;
        colWidth = TableConstants.maxColWidth;
        return this.createTopLine() + this.createTabularStruct() + this.createBottomLine();

    }


    @Override
    public String createTableWithOnlyHeaders(String[] headers) {

        colWidth = computeWidth(headers) + 2;
        tableWidth = colWidth * colCount;
        return this.createTopLine() + this.createTabularStruct(headers) + this.createBottomLine();

    }

    private String createTopLine() {
        StringBuilder top = new StringBuilder();
        for (int i = 1; i <= tableWidth; i++) {
            if (i == 1)
                top.append(TableConstants.topLeft);
            if (i == tableWidth)
                top.append(TableConstants.topRight);
            else if (i % colWidth == 0)
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
            else if (i % colWidth == 0)
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
            if (i % colWidth == 0)
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
                if (i % colWidth == 0)
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

    private String createTabularStruct(String[] headers) {
        StringBuilder tableHeader = new StringBuilder();
        tableHeader.append("\n" + TableConstants.verticalSeparator);
        for (int j = 0; j < headers.length; j++) {
            for (int k = 0; k < colWidth; ) {
                tableHeader.append(" ").append(headers[j]);
                k = k + headers[j].length() + 2;
                while (k < colWidth) {
                    tableHeader.append(" ");
                    k++;
                }
                tableHeader.append(TableConstants.verticalSeparator);
            }
        }
        tableHeader.append(createRowSeparator());
        for (int j = 1; j <= rowCount; j++) {
            tableHeader.append("\n" + TableConstants.verticalSeparator);
            for (int i = 1; i < tableWidth; i++) {
                if (i % colWidth == 0)
                    tableHeader.append(TableConstants.verticalSeparator);
                else
                    tableHeader.append(" ");
            }
            tableHeader.append(TableConstants.verticalSeparator);
            if (j == rowCount - 1)
                break;
            tableHeader.append(createRowSeparator());

            return tableHeader.toString();

        }

        return tableHeader.toString();

    }

    private String createTabularStruct(List<String[]> rows) {
        StringBuilder tableData = new StringBuilder();
        for (int i = 0; i < rowCount; i++) {
            tableData.append("\n" + TableConstants.verticalSeparator);
            String[] cells = rows.get(i);
            for (int j = 0; j < cells.length; j++) {
                for (int k = 0; k < colWidth; ) {
                    tableData.append(" ").append(cells[j]);
                    k = k + cells[j].length() + 2;
                    while (k < colWidth) {
                        tableData.append(" ");
                        k++;
                    }

                }
                tableData.append(TableConstants.verticalSeparator);
            }
            if (i == rowCount - 1)
                break;
            tableData.append(createRowSeparator());
        }
        return tableData.toString();

    }


    private int computeWidth(String[] headers) {
        int maxWidth = Integer.MIN_VALUE;

        for (String header : headers) {
            maxWidth = Math.max(maxWidth, header.length());

        }
        return maxWidth;
    }

    private int computeWidth(List<String[]> rows) {
        int maxWidth = Integer.MIN_VALUE;
        for (String[] cells : rows) {
            for (int i = 0; i < cells.length; i++) {

                maxWidth = Math.max(maxWidth, cells[i].length());
            }
        }
        return maxWidth;
    }

}