package com.xebia.fs101.xtable;

import com.xebia.fs101.xtable.layout_manager.HorizontalLayout;
import com.xebia.fs101.xtable.layout_manager.LayoutTemplate;
import com.xebia.fs101.xtable.layout_manager.TableLayout;
import com.xebia.fs101.xtable.layout_manager.TableLayoutFactory;
import com.xebia.fs101.xtable.renderer.ConsoleBaseRenderer;
import com.xebia.fs101.xtable.renderer.Renderer;

import java.util.ArrayList;
import java.util.List;

import static com.xebia.fs101.xtable.layout_manager.TableLayout.HORIZONTAL;

public class Table {

    private int rowCount;
    private int colCount;
    private LayoutTemplate layoutTemplate;
    private Renderer renderer;
    private String[] headers;
    private List<String[]> rows;
    private int[] columnWidth;


    private Table(Builder builder) {
        rowCount = builder.rowCount;
        colCount = builder.colCount;
        renderer = new ConsoleBaseRenderer();
        rows = builder.rows;
        headers = builder.headers;
        if(builder.layoutTemplate==null)
             layoutTemplate=builder.withLayoutOption(HORIZONTAL).layoutTemplate;
        else
            layoutTemplate = builder.layoutTemplate;
        columnWidth = builder.columnWidth;
    }

    public void render() {
        renderer.printTable(generate());
    }

    public String getShape() {
        return rowCount + " rows X " + colCount + " cols";
    }

    public String generate() {
        return layoutTemplate.createTable(rows);
    }

    public static final class Builder {

        private int rowCount;
        private int colCount;
        private LayoutTemplate layoutTemplate;
        private Renderer renderer;
        private List<String[]> rows;
        private String[] headers;
        private int[] columnWidth;


        public Builder() {
        }

        public Builder withColumnWidth(int[] val) {
            columnWidth = val;
            return this;
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
            rows = new ArrayList<>();
            rows.add(headers);
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

        public Builder withLayoutOption(TableLayout tableLayout) {
            if (columnWidth != null && columnWidth.length > 0)
                layoutTemplate = TableLayoutFactory.getLayoutManager(tableLayout, rowCount, colCount, columnWidth);
            else
                layoutTemplate = TableLayoutFactory.getLayoutManager(tableLayout, rowCount, colCount);
            return this;
        }

        public Table build() {
            return new Table(this);
        }
    }

}
