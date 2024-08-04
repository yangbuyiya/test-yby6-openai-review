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
        
        while (true) {
            // do nothing
        }
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
        
        while (true) {
            // do nothing
        }
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
        
        while (true) {
            // do nothing
        }  // 内存溢出
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
        
        while (true) {
            // do nothing
        }
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
        
        while (true) {
            // do nothing
        }
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
        
        while (true) {
            // do nothing
        }
        
        
        /*
        * 要避免Java程序中的内存泄漏，可以采取以下措施：
对象生命周期管理：确保不再使用的对象被及时回收。对于临时对象，应该在不再引用时立即将其设置为null，以便垃圾收集器可以回收。
使用弱引用：在需要引用但又不想阻止垃圾收集的情况下，可以使用WeakReference或SoftReference。
资源释放：确保所有打开的资源（如文件、数据库连接、网络连接等）在使用完毕后都被正确关闭。可以使用try-with-resources语句来自动管理资源。
缓存策略：合理使用缓存，避免无限增长的数据结构导致内存泄漏。设置缓存大小限制，并在必要时实现缓存清理策略。
监听器和回调：注册监听器和回调时，确保在对象不再使用时取消注册，避免内存泄漏。
线程管理：确保线程池中的线程在完成任务后能够正确结束，避免线程成为内存泄漏源头。
使用内存分析工具：利用内存分析工具（如VisualVM、MAT等）来检测和定位潜在的内存泄漏问题。
代码审查：定期进行代码审查，注意成员变量、静态集合等可能导致内存泄漏的地方。
单元测试：编写单元测试来验证内存管理逻辑的正确性，帮助发现潜在的内存泄漏问题。
通过上述措施，可以有效地减少和避免Java程序中的内存泄漏。
        * */
    }
    
}
