package com.xebia.fs101.xtable;

import java.util.List;

import static com.xebia.fs101.xtable.TableConstants.*;

public class VerticalLayoutManager extends LayoutManager {

    VerticalLayoutManager(int rowCount, int colCount) {
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
        colWidth = computeWidth(headers) + 2;
        tableWidth = (colWidth) * colCount;
        return this.createTopLine() + this.createTableStructure(headers) + this.createBottomLine();
    }

    private String createTableStructure(String[] headers) {
        StringBuilder tableHeader = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <= colCount; j++) {
                if (j == START_POSITION) {
                    tableHeader.append("\n" + createCellWithData(headers[count++]));
                } else
                    tableHeader.append(createCellWithoutData());
            }
            tableHeader.append(VERTICAL_SEPARATOR);
            if (i != rowCount)
                tableHeader.append(createRowSeparator());
        }
        return tableHeader.toString();
    }

    private String createTableStructure(List<String[]> data) {
        StringBuilder tableData = new StringBuilder();
        for (int i = 0; i < rowCount; i++) {
            int count = 0;
            tableData.append("\n");
            for (int j = 0; j < colCount; j++) {
                tableData.append(createCellWithData(data.get(count++)[i]));
            }
            tableData.append(VERTICAL_SEPARATOR);
            if (i != rowCount - 1)
                tableData.append(createRowSeparator());
        }
        return tableData.toString();
    }

    private StringBuilder createCellWithData(String data) {
        StringBuilder cellData = new StringBuilder();
        cellData.append(VERTICAL_SEPARATOR + " ");
        int spaceLeft = colWidth - data.length();
        cellData.append(data);
        for (int i = 2; i < spaceLeft - 1; i++)
            cellData.append(" ");
        if (data.length() != colWidth - 2)
            cellData.append(" ");
        return cellData;
    }

    private StringBuilder createCellWithoutData() {
        StringBuilder builder = new StringBuilder();
        builder.append(VERTICAL_SEPARATOR);
        for (int i = 1; i <= colWidth - 1; i++)
            builder.append(" ");
        return builder;
    }

    private void validate(String[] headers) {
        if (headers != null && headers.length != rowCount)
            throw new IllegalArgumentException("Please pass according to number of rows");
    }

    private void validate(List<String[]> rows) {
        if (rows != null && rows.size() != colCount)
        throw new IllegalArgumentException("Please pass according to the number of cols");
        if (rows != null) {
            for (String cells[] : rows) {
                if (cells.length != rowCount)
                    throw new IllegalArgumentException("Please pass according to the number of rows");
            }
        }
    }
}