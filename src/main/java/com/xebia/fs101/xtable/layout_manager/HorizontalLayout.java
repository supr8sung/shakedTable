package com.xebia.fs101.xtable.layout_manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.xebia.fs101.xtable.layout_manager.TableConstants.VERTICAL_SEPARATOR;

public class HorizontalLayout extends LayoutTemplate {

    public HorizontalLayout(int rowCount, int colCount, int[] colWidth) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.columnWidths = setColumnWidthToDefaultForLessThan5(colWidth);
    }

    public HorizontalLayout(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.columnWidths = initializeColWidths();
    }


     protected void validate(List<String[]> rows) {
        validate();
        if (rows != null && rows.size() != rowCount)
            throw new IllegalArgumentException("Please pass according to the number of rows");
        if (rows != null) {
            for (String cells[] : rows) {
                if (cells.length != colCount)
                    throw new IllegalArgumentException("Please pass according to the number of rows");
            }
        }
    }
    protected List<String[]> initializeRows(List<String[]> rows)
    {
        if (rows==null || rows.size() == 0) {
            rows=new ArrayList<>();
            for (int i = 0; i < rowCount; i++) {
                String[] cols = new String[colCount];
                Arrays.fill(cols, "");
                rows.add(cols);
            }

        }
        else if(rows.size()==1)// for only headers
        {
            for (int i = 1; i < rowCount; i++) {
                String[] cols = new String[colCount];
                Arrays.fill(cols, "");
                rows.add(cols);
            }
        }
        else
            rows=rows;
        return rows;

    }

    protected String createTableStructure(List<String[]> rows) {

        StringBuilder tableData = new StringBuilder();
        String currentData = null;
        for (int i = 0; i < rowCount; i++) {
            tableData.append("\n");
            for (int j = 0; j < colCount; j++) {
                if (!(rows.get(i)[j].length() < columnWidths[j] - 1)) {
                    if(i==0)
                    currentData = replaceWith(rows.get(i)[j], columnWidths[j] - 1).toUpperCase();
                    else
                        currentData = replaceWith(rows.get(i)[j], columnWidths[j] - 1);
                    tableData.append(createCellWithData(currentData, columnWidths[j]));
                  } else
                {
                    if(i==0)
                        tableData.append(createCellWithData(rows.get(i)[j].toUpperCase(), columnWidths[j]));
                    else
                        tableData.append(createCellWithData(rows.get(i)[j], columnWidths[j]));

                }

            }
            tableData.append(VERTICAL_SEPARATOR);
            if (i != rowCount - 1)
                tableData.append(createRowSeparator());
        }
        return tableData.toString();

    }


}