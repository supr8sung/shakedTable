package com.xebia.fs101.xtable;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class VerticalLayoutManagerTest {
    @Test
    public void should_be_able_to_create_a_table_strcuture_with_headers() {
        VerticalLayoutManager verticalLayoutManager = new VerticalLayoutManager(3, 4);
        String[] cells = {"one", "two", "three"};
        String result = verticalLayoutManager.createTableWithHeadersOnly(cells);
        assertThat(result).isEqualTo(
                        "┌──────┬──────┬──────┬──────┐\n" +
                        "│ one  │      │      │      │\n" +
                        "├──────┼──────┼──────┼──────┤\n" +
                        "│ two  │      │      │      │\n" +
                        "├──────┼──────┼──────┼──────┤\n" +
                        "│ three│      │      │      │\n" +
                        "└──────┴──────┴──────┴──────┘"
        );
    }

    @Test
    public void should_be_able_to_create_a_table_with_headers_and_rows() {
        LayoutManager verticalLayoutManager = new VerticalLayoutManager(3, 4);
        String[] headers = {"Name", "Marks", "Subject"};
        String[] row1 = {"Trump", "10", "Math"};
        String[] row2 = {"Obama", "40", "Math"};
        String[] row3 = {"Jamie", "60", "Math"};
        List<String[]> tableData = new ArrayList<>();
        tableData.add(headers);
        tableData.add(row1);
        tableData.add(row2);
        tableData.add(row3);
        String actualResult = verticalLayoutManager.createDataTable(tableData);
        assertThat(actualResult).isEqualTo(
                        "┌────────┬────────┬────────┬────────┐\n" +
                        "│ Name   │ Trump  │ Obama  │ Jamie  │\n" +
                        "├────────┼────────┼────────┼────────┤\n" +
                        "│ Marks  │ 10     │ 40     │ 60     │\n" +
                        "├────────┼────────┼────────┼────────┤\n" +
                        "│ Subject│ Math   │ Math   │ Math   │\n" +
                        "└────────┴────────┴────────┴────────┘"
        );
    }
    @Test
    public void should_be_able_to_create_an_empty_structure() {
        LayoutManager verticalLayoutManager = new VerticalLayoutManager(1,2);
        String actualResult = verticalLayoutManager.createTable();
        String expectedResult =
                        "┌───────────────────┬───────────────────┐\n" +
                        "│                   │                   │\n" +
                        "└───────────────────┴───────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}