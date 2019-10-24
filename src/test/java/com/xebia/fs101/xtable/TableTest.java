package com.xebia.fs101.xtable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {

    @Test
    public void should_return_shape_of_table_when_given_valid_data() {
        Table table = new Table.Builder().withRowCount(3).withColCount(4).build();
        String actualResult = table.getShape();
        String expectedResult = "3 rows X 4 cols";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_row_count_or_col_count_is_less_than_0() {
        Table table =new Table.Builder().withRowCount(-1).withColCount(-1).withHorizontalLayoutManger().build();
        table.generate();
    }

    @Test
    public void should_create_table_with_no_data_with_for_1_row_and_col() {
        Table table = new Table.Builder().withRowCount(1).withColCount(1).withHorizontalLayoutManger().build();
        String actualResult = table.generate();
        String expectedResult =
                        "┌───────────────────┐\n" +
                        "│                   │\n" +
                        "└───────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void should_create_table_with_only_header(){
        String[] header={"one","two","three"};
        Table table = new Table.Builder().withRowCount(2).withColCount(3).withHeader(header).withHorizontalLayoutManger().build();
        String actualResult = table.generate();
        String expectedResult =
                        "┌──────┬──────┬──────┐\n" +
                        "│ one  │ two  │ three│\n" +
                        "├──────┼──────┼──────┤\n" +
                        "│      │      │      │\n" +
                        "└──────┴──────┴──────┘";
        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_headers_are_less_than_cols() {
        String[] cells={"one","two"};
        Table table = new Table.Builder().withRowCount(2).withColCount(3).withHeader(cells).withHorizontalLayoutManger().build();
        table.generate();

    }


    @Test
    public void should_create_table_with_data_rows() {

        String[] row1 = {"one", "two", "three"};
        String[] row2 = {"test", "logic", "user"};
        String[] row3 = {"assumption", "great", "reflection"};
        String[] row4 = {"flexible", "pleasant", "wild"};
        List<String[]> tableData = new ArrayList<>();
        tableData.add(row1);
        tableData.add(row2);
        tableData.add(row3);
        tableData.add(row4);
        Table table = new Table.Builder().withRowCount(4).withColCount(3).withRows(tableData).withHorizontalLayoutManger().build();
        String actualResult = table.generate();
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

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_colData_is_less_than_colCount() {

        String[] row1 = {"one", "two", "three"};
        String[] row2 = {"test", "logic", "user"};
        String[] row3 = {"assumption", "great", "reflection"};
        String[] row4 = {"flexible", "pleasant", "wild"};
        List<String[]> tableData = new ArrayList<>();
        tableData.add(row1);
        tableData.add(row2);
        tableData.add(row3);
        tableData.add(row4);
        Table table = new Table.Builder().withRowCount(4).withColCount(1).withRows(tableData).withHorizontalLayoutManger().build();
        table.generate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_rowData_is_less_than_rowCount() {

        String[] row1 = {"one", "two", "three"};
        String[] row2 = {"test", "logic", "user"};
        String[] row3 = {"assumption", "great", "reflection"};
        String[] row4 = {"flexible", "pleasant", "wild"};
        List<String[]> tableData = new ArrayList<>();
        tableData.add(row1);
        tableData.add(row2);
        tableData.add(row3);
        tableData.add(row4);
        Table table = new Table.Builder().withRowCount(2).withColCount(3).withRows(tableData).withHorizontalLayoutManger().build();
        table.generate();
    }

    @Test
    public void should_create_table_with_header_row_and_data_rows() {

        String[] header = {"one", "two", "three"};
        String[] row1 = {"test", "logic", "user"};
        String[] row2 = {"assumption", "great", "reflection"};
        String[] row3 = {"flexible", "pleasant", "wild"};
        List<String[]> tableData = new ArrayList<>();
        tableData.add(row1);
        tableData.add(row2);
        tableData.add(row3);
        Table table = new Table.Builder().withRowCount(4).withColCount(3).withHeader(header).withHorizontalLayoutManger().withRows(tableData).build();
        String actualResult = table.generate();
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

    @Test
    public void should_be_able_to_create_a_vertical_table_with_headers() {

        String[] headers = {"Name", "Marks", "Subject"};
        Table table = new Table.Builder().withRowCount(3).withColCount(4).withHeader(headers).withVerticalLayoutManger().build();
        String actualResult = table.generate();
        assertThat(actualResult).isEqualTo(
                               "┌────────┬────────┬────────┬────────┐\n" +
                               "│ Name   │        │        │        │\n" +
                               "├────────┼────────┼────────┼────────┤\n" +
                               "│ Marks  │        │        │        │\n" +
                               "├────────┼────────┼────────┼────────┤\n" +
                               "│ Subject│        │        │        │\n" +
                               "└────────┴────────┴────────┴────────┘");

    }

    @Test
    public void should_be_able_to_create_a_vertical_table_with_headers_and_rows() {

        String[] headers = {"Name", "Marks", "Subject"};
        String[] row1 = {"Trump", "10", "Math"};
        String[] row2 = {"Obama", "40", "Math"};
        String[] row3 = {"Jamie", "60", "Math"};
        List<String[]> tableData = new ArrayList<>();
        tableData.add(headers);
        tableData.add(row1);
        tableData.add(row2);
        tableData.add(row3);
        Table table = new Table.Builder().withRowCount(3).withColCount(4).withRows(tableData).withVerticalLayoutManger().build();
        String actualResult = table.generate();
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
}