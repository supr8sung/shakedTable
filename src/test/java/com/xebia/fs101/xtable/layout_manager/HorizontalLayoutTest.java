package com.xebia.fs101.xtable.layout_manager;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalLayoutTest {

    @Test
    public void should_create_empty_table_with_valid_rows_and_cols() {
        LayoutTemplate horizontalLayoutTemplate = new HorizontalLayout(1, 3);
        List<String[]> rows=new ArrayList<>();
        String actualResult = horizontalLayoutTemplate.createTable(rows);
        String expectedResult =
                                "┌───────────────────┬───────────────────┬───────────────────┐\n" +
                                "│                   │                   │                   │\n" +
                                "└───────────────────┴───────────────────┴───────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }


    @Test

    public void should_create_empty_table_with_passed_rows_and_columns_with_custom_column_widths() {
        LayoutTemplate horizontalLayoutTemplate = new HorizontalLayout(2, 3,new int[]{10,20,30});
        List<String[]> rows=new ArrayList<>();
        String actualResult = horizontalLayoutTemplate.createTable(rows);
        String expectedResult=
                        "┌─────────┬───────────────────┬─────────────────────────────┐\n" +
                        "│         │                   │                             │\n" +
                        "├─────────┼───────────────────┼─────────────────────────────┤\n" +
                        "│         │                   │                             │\n" +
                        "└─────────┴───────────────────┴─────────────────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    public void should_create_table_with_header() {
        LayoutTemplate horizontalLayoutTemplate = new HorizontalLayout(2, 3);
        List<String[]> rows=new ArrayList<>();
        String[] headers = {"one", "two", "three"};
        rows.add(headers);
        String actualResult = horizontalLayoutTemplate.createTable(rows);
        String expectedResult =
                        "┌───────────────────┬───────────────────┬───────────────────┐\n" +
                        "│ ONE               │ TWO               │ THREE             │\n" +
                        "├───────────────────┼───────────────────┼───────────────────┤\n" +
                        "│                   │                   │                   │\n" +
                        "└───────────────────┴───────────────────┴───────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }
    @Test
    public void should_create_table_with_header_and_custom_column_width() {
        LayoutTemplate horizontalLayoutTemplate = new HorizontalLayout(2, 3,new int[]{10,20,30});
        List<String[]> rows=new ArrayList<>();
        String[] headers = {"one", "two", "three"};
        rows.add(headers);
        String actualResult = horizontalLayoutTemplate.createTable(rows);
        String expectedResult =
                        "┌─────────┬───────────────────┬─────────────────────────────┐\n" +
                        "│ ONE     │ TWO               │ THREE                       │\n" +
                        "├─────────┼───────────────────┼─────────────────────────────┤\n" +
                        "│         │                   │                             │\n" +
                        "└─────────┴───────────────────┴─────────────────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void should_create_table_with_data_rows() {
        LayoutTemplate horizontalLayoutTemplate = new HorizontalLayout(4, 3);
        String[] row1 = {"one", "two", "three"};
        String[] row2 = {"test", "logic", "user"};
        String[] row3 = {"assumption", "great", "reflection"};
        String[] row4 = {"flexible", "pleasant", "wild"};
        List<String[]> tabledata = new ArrayList<>();
        tabledata.add(row1);
        tabledata.add(row2);
        tabledata.add(row3);
        tabledata.add(row4);
        String actualResult = horizontalLayoutTemplate.createTable(tabledata);
        String expectedResult =
                        "┌───────────────────┬───────────────────┬───────────────────┐\n" +
                        "│ ONE               │ TWO               │ THREE             │\n" +
                        "├───────────────────┼───────────────────┼───────────────────┤\n" +
                        "│ test              │ logic             │ user              │\n" +
                        "├───────────────────┼───────────────────┼───────────────────┤\n" +
                        "│ assumption        │ great             │ reflection        │\n" +
                        "├───────────────────┼───────────────────┼───────────────────┤\n" +
                        "│ flexible          │ pleasant          │ wild              │\n" +
                        "└───────────────────┴───────────────────┴───────────────────┘";

        assertThat(actualResult).isEqualTo(expectedResult);
    }
    @Test
    public void should_create_table_with_data_rows_and_custom_column_width() {
        LayoutTemplate horizontalLayoutTemplate = new HorizontalLayout(4, 3,new int[]{20,40,60});
        String[] row1 = {"one", "two", "three"};
        String[] row2 = {"test", "logic", "user"};
        String[] row3 = {"assumption", "great", "reflection"};
        String[] row4 = {"flexible", "pleasant", "wild"};
        List<String[]> tabledata = new ArrayList<>();
        tabledata.add(row1);
        tabledata.add(row2);
        tabledata.add(row3);
        tabledata.add(row4);
        String actualResult = horizontalLayoutTemplate.createTable(tabledata);
        String expectedResult =
                        "┌───────────────────┬───────────────────────────────────────┬───────────────────────────────────────────────────────────┐\n" +
                        "│ ONE               │ TWO                                   │ THREE                                                     │\n" +
                        "├───────────────────┼───────────────────────────────────────┼───────────────────────────────────────────────────────────┤\n" +
                        "│ test              │ logic                                 │ user                                                      │\n" +
                        "├───────────────────┼───────────────────────────────────────┼───────────────────────────────────────────────────────────┤\n" +
                        "│ assumption        │ great                                 │ reflection                                                │\n" +
                        "├───────────────────┼───────────────────────────────────────┼───────────────────────────────────────────────────────────┤\n" +
                        "│ flexible          │ pleasant                              │ wild                                                      │\n" +
                        "└───────────────────┴───────────────────────────────────────┴───────────────────────────────────────────────────────────┘";

        assertThat(actualResult).isEqualTo(expectedResult);
    }
    @Test
    public void should_be_able_to_truncate_data_if_header_is_larger_as_compared_to_column_length() {
        LayoutTemplate horizontalLayoutTemplate = new HorizontalLayout(2, 3,new int[]{10,5,5});
        List<String[]> rows=new ArrayList<>();
        String[] headers = {"one", "two", "three"};
        rows.add(headers);
        String actualResult = horizontalLayoutTemplate.createTable(rows);
        String expectedResult =
                        "┌─────────┬────┬────┐\n" +
                        "│ ONE     │ TWO│ T..│\n" +
                        "├─────────┼────┼────┤\n" +
                        "│         │    │    │\n" +
                        "└─────────┴────┴────┘";
        assertThat(actualResult).isEqualTo(expectedResult);

    }
    @Test
    public void should_be_able_to_truncate_data_if_data_is_larger_as_compared_to_column_length() {
        LayoutTemplate horizontalLayoutTemplate = new HorizontalLayout(3, 3,new int[]{10,20,10});
        String[] row1 = {"test", "logic", "user"};
        String[] row2 = {"assumption", "great", "reflection"};
        String[] row3 = {"flexible", "pleasant", "wild"};
        List<String[]> tabledata = new ArrayList<>();
        tabledata.add(row1);
        tabledata.add(row2);
        tabledata.add(row3);
        String actualResult = horizontalLayoutTemplate.createTable(tabledata);
        String expectedResult =
                        "┌─────────┬───────────────────┬─────────┐\n" +
                        "│ TEST    │ LOGIC             │ USER    │\n" +
                        "├─────────┼───────────────────┼─────────┤\n" +
                        "│ assump..│ great             │ reflec..│\n" +
                        "├─────────┼───────────────────┼─────────┤\n" +
                        "│ flexible│ pleasant          │ wild    │\n" +
                        "└─────────┴───────────────────┴─────────┘";

        assertThat(actualResult).isEqualTo(expectedResult);
    }


}
