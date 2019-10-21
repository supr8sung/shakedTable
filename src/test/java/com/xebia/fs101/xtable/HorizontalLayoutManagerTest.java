package com.xebia.fs101.xtable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalLayoutManagerTest {

    @Test
    public void should_create_table_empty_table_with_passed_rows_and_cols() {
        HorizontalLayoutManager horizontalLayoutManager = new HorizontalLayoutManager(1, 2);
        String actualResult = horizontalLayoutManager.createTable();
        String expectedResult =
                                "┌───────────────────┬───────────────────┐\n" +
                                "│                   │                   │\n" +
                                "└───────────────────┴───────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void should_create_table_with_header() {
        HorizontalLayoutManager horizontalLayoutManager = new HorizontalLayoutManager(2, 3);
        String[] cells={"one","two","three"};
        String actualResult = horizontalLayoutManager.createTableWithOnlyHeaders(cells);
        String expectedResult =
                             "┌──────┬──────┬──────┐\n" +
                             "│ one  │ two  │ three│\n" +
                             "├──────┼──────┼──────┤\n" +
                             "│      │      │      │\n" +
                             "└──────┴──────┴──────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void should_create_table_with_data_rows() {
        HorizontalLayoutManager horizontalLayoutManager = new HorizontalLayoutManager(4, 3);
        String[] cells={"one","two","three"};
        String[] celldata1 = {"one", "two", "three"};
        String[] celldata2 = {"test", "logic", "user"};
        String[] celldata3 = {"assumption", "great", "reflection"};
        String[] celldata4 = {"flexible", "pleasant", "wild"};
        List<String[]> rowdata = new ArrayList<>();
        rowdata.add(celldata1);
        rowdata.add(celldata2);
        rowdata.add(celldata3);
        rowdata.add(celldata4);
        String actualResult = horizontalLayoutManager.createDataTable(rowdata);
        String expectedResult =
                        "┌───────────┬───────────┬───────────┐\n" +
                        "│ one       │ two       │ three     │\n" +
                        "├───────────┼───────────┼───────────┤\n" +
                        "│ test      │ logic     │ user      │\n" +
                        "├───────────┼───────────┼───────────┤\n" +
                        "│ assumption│ great     │ reflection│\n" +
                        "├───────────┼───────────┼───────────┤\n" +
                        "│ flexible  │ pleasant  │ wild      │\n" +
                        "└───────────┴───────────┴───────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }



}