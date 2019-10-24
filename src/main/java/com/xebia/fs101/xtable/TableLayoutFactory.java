package com.xebia.fs101.xtable;

public class TableLayoutFactory {

    public LayoutManager getLayoutManager(TableLayout tableLayout, int rowCount, int colCount) {
       if (tableLayout == TableLayout.VERTICAL) {
            return new VerticalLayoutManager(rowCount,colCount);
        }
        return new HorizontalLayoutManager(rowCount,colCount);
    }
}
