package com.hjxlog.exception;

import java.io.*;
import java.util.Scanner;

/**
 * @author Huang JX
 * @date 2022/4/3
 */
public class Demo03 {

    public static void main(String[] args) {
        //读取文本文件的内容
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("D:\\TestFiles\\java-basic\\read.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        // 使用 Java 7 之后的 try-with-resources 语句改造上面的代码:
        try (Scanner scanner1 = new Scanner(new File("D:\\TestFiles\\java-basic\\read.txt"))) {
            while (scanner1.hasNext()) {
                System.out.println(scanner1.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        // 通过使用分号分隔，可以在try-with-resources块中声明多个资源。
        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(new File("test.txt")));
             BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File("out.txt")))) {
            int b;
            while ((b = bin.read()) != -1) {
                bout.write(b);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

}
