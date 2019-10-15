package com.xebia.fs101.xtable;

public class XTable {
    final char horizontalSeparator='-';
    final char verticalSeparator='|';
    final String topLeft="┌";
    final String topRight="┐";
    final String bottomLeft="└";
    final String bottomRight="┘";
    final String topMiddle="┬";
    final String bottomMiddle="┴";
    //final String width="     ";
    final String mid="─";
    public void createEmptyTable(int rows,int columns) {
        printHeader(columns);
        printMiddle(rows,columns);
        printFooter(columns);
        /*for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=columns;j++) {
                if(i==1 && j==1)
                    System.out.print(topLeft);
                if(j!=2 && i==1)
                    System.out.print("-----"+topMiddle);
                    System.out.print("|"+"-----");
            }
            if(i==1)
                System.out.println(topRight);
            if(i==3)
                System.out.println(bottomRight);
        }*/
    }
    public void printHeader(int columns) {
        int columnWidth=10*columns;
        for(int i=1;i<=columnWidth;i++){
            if(i==1)
                System.out.print(topLeft);

            if(i==columnWidth)
                System.out.print(topRight);
            else if(i%10==0)
                System.out.print(topMiddle);
            else
                System.out.print(mid);
        }

          }

    public void printMiddle(int rows,int column){
        int columnWidth=10*column;
        for(int j=0;j<rows;j++)
        {
            for(int i=1;i<columnWidth;i++)
            {
                if(i%10==0)
                    System.out.print("|");
                else
                    System.out.print(mid);
            }
            System.out.println("|");


        }

    }
    public void printFooter(int columns){
              int columnWidth=10*columns;
        for(int i=1;i<=columnWidth;i++){
            if(i==1)
                System.out.print(bottomLeft);

            if(i==columnWidth)
                System.out.print(bottomRight);
            else if(i%10==0)
                System.out.print(bottomMiddle);
            else
                System.out.print(mid);
        }

    }

    public static void main(String[] args) {
        System.out.println("Enter the size for empty table");
        new XTable().createEmptyTable(3,5);


    }
}
