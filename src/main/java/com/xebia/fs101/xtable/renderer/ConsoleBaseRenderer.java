package com.xebia.fs101.xtable.renderer;

public class ConsoleBaseRenderer implements Renderer {
    @Override
    public void printTable(String table) {
        System.out.println(table);
    }
}
