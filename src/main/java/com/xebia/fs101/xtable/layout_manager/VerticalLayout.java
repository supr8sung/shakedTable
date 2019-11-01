package com.xebia.fs101.xtable.layout_manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.xebia.fs101.xtable.layout_manager.TableConstants.VERTICAL_SEPARATOR;

public class VerticalLayout extends LayoutTemplate {

    public VerticalLayout(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.columnWidths = initializeColWidths();
    }

    public VerticalLayout(int rowCount, int colCount, int[] colWidth) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.columnWidths = setColumnWidthToDefaultForLessThan5(colWidth);
    }

    protected String createTableStructure(List<String[]> data) {
        StringBuilder tableData = new StringBuilder();
        String currentData = null;
        for (int i = 0; i < rowCount; i++) {
            tableData.append("\n");
            for (int j = 0; j < colCount; j++) {
                if (!(data.get(j)[i].length() < columnWidths[j] - 1)) {
                    if (j == 0)
                        currentData = replaceWith(data.get(j)[i],
                                columnWidths[j] - 1).toUpperCase();
                    else
                        currentData = replaceWith(data.get(j)[i],
                                columnWidths[j] - 1);
                    tableData.append(createCellWithData(currentData, columnWidths[j]));
                } else if (j == 0)
                    tableData.append(createCellWithData(data.get(j)[i].toUpperCase(),
                            columnWidths[j]));
                else
                    tableData.append(createCellWithData(data.get(j)[i],
                            columnWidths[j]));
            }
            tableData.append(VERTICAL_SEPARATOR);
            if (i != rowCount - 1)
                tableData.append(createRowSeparator());
        }
        return tableData.toString();
    }

    protected void validate(List<String[]> rows) {
        validate();
        if (rows != null && rows.size() != colCount)
            throw new IllegalArgumentException("Please pass according to the no of cols");
        if (rows != null) {
            for (String[] cells : rows) {
                if (cells.length != rowCount)
                    throw new IllegalArgumentException("Please pass according to the no of rows");
            }
        }
    }

    protected List<String[]> initializeRows(List<String[]> rows) {
        if (rows == null || rows.size() == 0) {
            rows = new ArrayList<>();
            for (int i = 0; i < colCount; i++) {
                String[] cols = new String[rowCount];
                Arrays.fill(cols, "");
                rows.add(cols);
            }

        } else if (rows.size() == 1) {
            for (int i = 1; i < colCount; i++) {
                String[] cols = new String[rowCount];
                Arrays.fill(cols, "");
                rows.add(cols);
            }
        } else
            rows = rows;
        return rows;

    }
}

