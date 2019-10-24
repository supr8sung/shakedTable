package com.xebia.fs101.xtable;

import java.util.List;

public class Table {

    private int rowCount;
    private int colCount;
    private LayoutManager layoutManager;
    private Renderer renderer;
    private String[] headers;
    private List<String[]> rows;


    private Table(Builder builder) {
        rowCount = builder.rowCount;
        colCount = builder.colCount;
        renderer = new ConsoleBaseRenderer();
        rows = builder.rows;
        headers = builder.headers;
        layoutManager = builder.layoutManager;
    }

    public void render() {
        renderer.printTable(generate());
    }

    public String getShape() {
        return rowCount + " rows X " + colCount + " cols";
    }


    public String generate() {

        if (headers != null || rows != null) {
            if (headers != null && rows != null) {
                rows.add(0, headers);
                return layoutManager.createDataTable(rows);
            } else if (headers != null && rows == null) {
                return layoutManager.createTableWithHeadersOnly(headers);
            } else {

                return layoutManager.createDataTable(rows);
            }

        } else

            return layoutManager.createTable();

    }

    public static final class Builder {

        private int rowCount;
        private int colCount;
        private LayoutManager layoutManager;
        private Renderer renderer;
        private List<String[]> rows;
        private String[] headers;
        private TableLayoutFactory tableLayoutFactory;

        public Builder() {
        }

        public Builder withRowCount(int val) {
            rowCount = val;
            return this;
        }

        public Builder withColCount(int val) {
            colCount = val;
            return this;
        }

        public Builder withHeader(String[] val) {
            headers = val;
            return this;
        }

        public Builder withRenderer(Renderer val) {
            renderer = val;
            return this;
        }

        public Builder withRows(List<String[]> val) {
            rows = val;
            return this;
        }

        public Builder withHorizontalLayoutManger() {
            tableLayoutFactory = new TableLayoutFactory();
            layoutManager = tableLayoutFactory.getLayoutManager(TableLayout.HORIZONTAL, rowCount, colCount);
            return this;

        }

        public Builder withVerticalLayoutManger() {
            tableLayoutFactory = new TableLayoutFactory();
            layoutManager = tableLayoutFactory.getLayoutManager(TableLayout.VERTICAL, rowCount, colCount);
            return this;
        }


        public Table build() {
            return new Table(this);
        }


    }


}