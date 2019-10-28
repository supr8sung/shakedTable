package com.xebia.fs101.xtable.layout_manager;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VerticalLayoutTest {
    @Test
    public void should_create_table_empty_table_with_passed_rows_and_cols() {
        LayoutTemplate verticalLayoutTemplate = new VerticalLayout(2, 3);
        List<String[]> rows=new ArrayList<>();
        String actualResult = verticalLayoutTemplate.createTable(rows);
        String expectedResult =
                                "┌───────────────────┬───────────────────┬───────────────────┐\n" +
                                "│                   │                   │                   │\n" +
                                "├───────────────────┼───────────────────┼───────────────────┤\n" +
                                "│                   │                   │                   │\n" +
                                "└───────────────────┴───────────────────┴───────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void should_create_empty_table_with_passed_rows_and_columns_and_custom__column_widths() {
        LayoutTemplate verticalLayoutTemplate = new VerticalLayout(2, 3, new int[]{10, 20, 30});
        List<String[]> rows=new ArrayList<>();
        String actualResult = verticalLayoutTemplate.createTable(rows);
        String expectedResult =
                        "┌─────────┬───────────────────┬─────────────────────────────┐\n" +
                        "│         │                   │                             │\n" +
                        "├─────────┼───────────────────┼─────────────────────────────┤\n" +
                        "│         │                   │                             │\n" +
                        "└─────────┴───────────────────┴─────────────────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void should_create_table_with_header() {
        VerticalLayout verticalLayoutManager = new VerticalLayout(2, 3, new int[]{10, 10, 10});
        String[] cells = {"one", "two"};
        List<String[]> rows=new ArrayList<>();
        rows.add(cells);
        String actualResult = verticalLayoutManager.createTable(rows);
        String expectedResult =
                        "┌─────────┬─────────┬─────────┐\n" +
                        "│ ONE     │         │         │\n" +
                        "├─────────┼─────────┼─────────┤\n" +
                        "│ TWO     │         │         │\n" +
                        "└─────────┴─────────┴─────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void should_create_table_with_header_and_custom_column_width() {
        VerticalLayout verticalLayoutManager = new VerticalLayout(2, 3, new int[]{10, 20, 30});
        String[] cells = {"one", "two"};
        List<String[]> rows=new ArrayList<>();
        rows.add(cells);
        String actualResult = verticalLayoutManager.createTable(rows);
        String expectedResult =
                        "┌─────────┬───────────────────┬─────────────────────────────┐\n" +
                        "│ ONE     │                   │                             │\n" +
                        "├─────────┼───────────────────┼─────────────────────────────┤\n" +
                        "│ TWO     │                   │                             │\n" +
                        "└─────────┴───────────────────┴─────────────────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void hould_create_table_with_data_rows() {
        LayoutTemplate verticalLayoutTemplate = new VerticalLayout(3, 4, new int[]{15, 15, 15, 15});
        String[] headers = {"Name", "Marks", "Subject"};
        String[] row1 = {"Trump", "10", "Math"};
        String[] row2 = {"Obama", "40", "Math"};
        String[] row3 = {"Jamie", "60", "Math"};
        List<String[]> tableData = new ArrayList<>();
        tableData.add(headers);
        tableData.add(row1);
        tableData.add(row2);
        tableData.add(row3);
        String actualResult = verticalLayoutTemplate.createTable(tableData);
        String expectedResult =
                        "┌──────────────┬──────────────┬──────────────┬──────────────┐\n" +
                        "│ NAME         │ Trump        │ Obama        │ Jamie        │\n" +
                        "├──────────────┼──────────────┼──────────────┼──────────────┤\n" +
                        "│ MARKS        │ 10           │ 40           │ 60           │\n" +
                        "├──────────────┼──────────────┼──────────────┼──────────────┤\n" +
                        "│ SUBJECT      │ Math         │ Math         │ Math         │\n" +
                        "└──────────────┴──────────────┴──────────────┴──────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    public void should_create_table_with_data_rows_and_custom_column_width() {
        LayoutTemplate verticalLayoutTemplate = new VerticalLayout(3, 4, new int[]{15, 10, 30, 20});
        String[] headers = {"Name", "Marks", "Subject"};
        String[] row1 = {"Trump", "10", "Math"};
        String[] row2 = {"Obama", "40", "Math"};
        String[] row3 = {"Jamie", "60", "Math"};
        List<String[]> tableData = new ArrayList<>();
        tableData.add(headers);
        tableData.add(row1);
        tableData.add(row2);
        tableData.add(row3);
        String actualResult = verticalLayoutTemplate.createTable(tableData);
        String expectedResult =
                        "┌──────────────┬─────────┬─────────────────────────────┬───────────────────┐\n" +
                        "│ NAME         │ Trump   │ Obama                       │ Jamie             │\n" +
                        "├──────────────┼─────────┼─────────────────────────────┼───────────────────┤\n" +
                        "│ MARKS        │ 10      │ 40                          │ 60                │\n" +
                        "├──────────────┼─────────┼─────────────────────────────┼───────────────────┤\n" +
                        "│ SUBJECT      │ Math    │ Math                        │ Math              │\n" +
                        "└──────────────┴─────────┴─────────────────────────────┴───────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void should_be_able_to_truncate_data_if_header_is_larger_as_compared_to_column_length() {
        VerticalLayout verticalLayoutManager = new VerticalLayout(2, 3, new int[]{5, 5, 5});
        String[] cells = {"three", "t"};
        List<String[]> rows=new ArrayList<>();
        rows.add(cells);
        String actualResult = verticalLayoutManager.createTable(rows);
        String expectedResult =
                        "┌────┬────┬────┐\n" +
                        "│ T..│    │    │\n" +
                        "├────┼────┼────┤\n" +
                        "│ T  │    │    │\n" +
                        "└────┴────┴────┘";

        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    public void should_be_able_to_truncate_data_if_data_is_larger_as_compared_to_column_length() {
        LayoutTemplate verticalLayoutTemplate = new VerticalLayout(3, 4, new int[]{10, 5, 10, 10});
        String[] headers = {"Name", "Marks", "Subject"};
        String[] row1 = {"Donald Trump", "10", "Mathematics"};
        String[] row2 = {"Obama", "40", "Mathematics"};
        String[] row3 = {"Jamie Lannister", "60", "Mathematics"};
        List<String[]> tableData = new ArrayList<>();
        tableData.add(headers);
        tableData.add(row1);
        tableData.add(row2);
        tableData.add(row3);
        String actualResult = verticalLayoutTemplate.createTable(tableData);
        String expectedResult =
                        "┌─────────┬────┬─────────┬─────────┐\n" +
                        "│ NAME    │ D..│ Obama   │ Jamie ..│\n" +
                        "├─────────┼────┼─────────┼─────────┤\n" +
                        "│ MARKS   │ 10 │ 40      │ 60      │\n" +
                        "├─────────┼────┼─────────┼─────────┤\n" +
                        "│ SUBJECT │ M..│ Mathem..│ Mathem..│\n" +
                        "└─────────┴────┴─────────┴─────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);

    }

}
