package com.xebia.fs101.xtable;

import java.util.List;

import static com.xebia.fs101.xtable.TableConstants.PADDING;
import static com.xebia.fs101.xtable.TableConstants.VERTICAL_SEPARATOR;

public class HorizontalLayoutManager extends LayoutManager {


    HorizontalLayoutManager(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    @Override
    public String createDataTable(List<String[]> rows) {
        validate(rows);
        colWidth = computeWidth(rows) + PADDING;
        tableWidth = colWidth * colCount;
        return this.createTopLine() + this.createTableStructure(rows) + this.createBottomLine();
    }


    @Override
    public String createTableWithHeadersOnly(String[] headers) {

        validate(headers);
        colWidth = computeWidth(headers) + PADDING;
        tableWidth = colWidth * colCount;
        return this.createTopLine() + this.createTableStructure(headers) + this.createBottomLine();

    }

    private String createTableStructure(String[] headers) {
        StringBuilder tableHeader = new StringBuilder();
        tableHeader.append("\n" + VERTICAL_SEPARATOR);
        for (int j = 0; j < headers.length; j++) {
            for (int k = 0; k < colWidth; ) {
                tableHeader.append(" ").append(headers[j]);
                k = k + headers[j].length() + 2;
                while (k < colWidth) {
                    tableHeader.append(" ");
                    k++;
                }
                tableHeader.append(VERTICAL_SEPARATOR);
            }
        }
        tableHeader.append(createRowSeparator());
        for (int j = 1; j <= rowCount; j++) {
            tableHeader.append("\n" + VERTICAL_SEPARATOR);
            for (int i = 1; i < tableWidth; i++) {
                if (i % colWidth == 0)
                    tableHeader.append(VERTICAL_SEPARATOR);
                else
                    tableHeader.append(" ");
            }
            tableHeader.append(VERTICAL_SEPARATOR);
            if (j == rowCount - 1)
                break;
            tableHeader.append(createRowSeparator());

            return tableHeader.toString();

        }

        return tableHeader.toString();

    }

    private String createTableStructure(List<String[]> rows) {
        StringBuilder tableData = new StringBuilder();
        for (int i = 0; i < rowCount; i++) {
            tableData.append("\n" + VERTICAL_SEPARATOR);
            String[] cells = rows.get(i);
            for (int j = 0; j < cells.length; j++) {
                for (int k = 0; k < colWidth; ) {
                    tableData.append(" ").append(cells[j]);
                    k = k + cells[j].length() + PADDING;
                    while (k < colWidth) {
                        tableData.append(" ");
                        k++;
                    }

                }
                tableData.append(VERTICAL_SEPARATOR);
            }
            if (i == rowCount - 1)
                break;
            tableData.append(createRowSeparator());
        }
        return tableData.toString();

    }

    private void validate(String[] headers) {
        if (headers != null && headers.length != colCount)
            throw new IllegalArgumentException("Please pass according to number of rows");
    }

    private void validate(List<String[]> rows) {
        if (rows != null && rows.size() != rowCount)
            throw new IllegalArgumentException("Please pass according to the number of rows");
        if (rows != null) {
            for (String cells[] : rows) {
                if (cells.length != colCount)
                    throw new IllegalArgumentException("Please pass according to the number of rows");
            }
        }
    }
    }