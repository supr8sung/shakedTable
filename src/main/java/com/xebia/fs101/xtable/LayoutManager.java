package com.xebia.fs101.xtable;

import java.util.List;

public interface LayoutManager {
    String createTable();
    String createTableWithOnlyHeaders(String[] headers);
    String createDataTable(List<String[]> rows);


}
