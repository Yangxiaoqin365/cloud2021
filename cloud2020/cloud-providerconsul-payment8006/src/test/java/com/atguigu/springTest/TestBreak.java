package com.atguigu.springTest;

/**
 * @author yxq
 * @data 2021/10/7 21:06
 */
public class TestBreak {
    public static void main(String[] args) {
        int [] numbers = {10, 20, 30, 40, 50};

        for(int x : numbers ) {
            // x 等于 30 时跳出循环
            if( x == 30 ) {
                //break;
                continue;
            }
            System.out.print( x );
            System.out.print("\n");
        }
    }
}
