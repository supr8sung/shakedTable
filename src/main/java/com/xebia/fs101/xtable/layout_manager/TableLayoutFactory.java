package com.xebia.fs101.xtable.layout_manager;

import static com.xebia.fs101.xtable.layout_manager.TableLayout.VERTICAL;

public class TableLayoutFactory {
    private TableLayoutFactory() {
    }

    public static LayoutTemplate getLayoutManager(TableLayout tableLayout,
                                                  int rowCount, int colCount) {
        if (tableLayout == VERTICAL) {
            return new VerticalLayout(rowCount, colCount);
        }
        return new HorizontalLayout(rowCount, colCount);
    }

    public static LayoutTemplate getLayoutManager(TableLayout tableLayout,
                                                  int rowCount, int colCount, int[] colWidth) {
        if (tableLayout == VERTICAL) {
            return new VerticalLayout(rowCount, colCount, colWidth);
        }
        return new HorizontalLayout(rowCount, colCount, colWidth);
    }
}
