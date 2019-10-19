package com.xebia.fs101.xtable;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class TableLayoutManagerTest {

    @Test
    public void should_create_table_with_no_data_for_2_row_and_cols() {
        TableLayoutManager tableLayoutManager = new TableLayoutManager(1, 2);
        String actualResult = tableLayoutManager.createTable();
        String expectedResult =
                                "┌───────────────────┬───────────────────┐\n" +
                                "│                   │                   │\n" +
                                "└───────────────────┴───────────────────┘";
        assertThat(actualResult).isEqualTo(expectedResult);
    }



}