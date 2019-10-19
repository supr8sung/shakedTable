package com.xebia.fs101.xtable;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {

    @Test
    public void should_return_shape_of_table_when_given_valid_data() {
        Table table = new Table(3, 4);
        String actualResult = table.getShape();
        String expectedResult = "3 rows X 4 cols";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_row_count_or_col_count_is_less_than_0() {
        Table table = new Table(-1, 1);
    }

    @Test
    public void should_create_table_with_no_data_with_for_1_row_and_col() {
        Table table = new Table(1, 1);
        String actualResult = table.generateTable();
        String expectedResult =
                        "┌───────────────────┐\n" +
                        "│                   │\n" +
                        "└───────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void should_create_table_with_no_data_for_2_row_and_cols() {
        Table table = new Table(2, 2);
        String actualResult = table.generateTable();
        String expectedResult =
                        "┌───────────────────┬───────────────────┐\n" +
                        "│                   │                   │\n" +
                        "├───────────────────┼───────────────────┤\n" +
                        "│                   │                   │\n" +
                        "└───────────────────┴───────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void should_create_table_with_no_data_for_2_row_and_3cols() {
        Table table = new Table(2, 3);
        String actualResult = table.generateTable();
        String expectedResult =
                        "┌───────────────────┬───────────────────┬───────────────────┐\n" +
                        "│                   │                   │                   │\n" +
                        "├───────────────────┼───────────────────┼───────────────────┤\n" +
                        "│                   │                   │                   │\n" +
                        "└───────────────────┴───────────────────┴───────────────────┘";

        assertThat(actualResult).isEqualTo(expectedResult);
    }


}