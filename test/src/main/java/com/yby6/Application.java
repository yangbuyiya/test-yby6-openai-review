package com.yby6;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用
 *
 * @author yangs
 * @date 2024/07/31
 */
public class Application {
    
    public static void main(String[] args) {
        
        System.out.println("Hello World Code Review");
        
        System.out.println(Integer.parseInt("ddd"));
        // https://github.com/yangbuyiya/test-yby6-openai-review
        
        // 内存溢出
        List<byte[]> byteList = new ArrayList<>();
        while (true) {
            try {
                byte[] bytes = new byte[Integer.MAX_VALUE];
                byteList.add(bytes);
            } catch (OutOfMemoryError e) {
                System.out.println("内存溢出");
                break;
            }
        }
        System.out.println(byteList.size());
        
    }
    
}
