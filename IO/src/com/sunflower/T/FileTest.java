package com.sunflower.T;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) {
        File file1 = new File("D:\\Programming\\ProgrammingLearningPlace\\Java\\io\\file1.txt");
        System.out.println(file1);
        String path1 = file1.getPath();//D:\Programming\ProgrammingLearningPlace\Java\io\file1.txt
        System.out.println(path1);
        System.out.println(file1.getName());//file1.txt
        System.out.println(file1.length());//16
        long modified = file1.lastModified();//
        System.out.println(modified);//1614059530304
        System.out.println(new Date(modified));//Tue Feb 23 13:52:10 CST 2021
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        File file2 = new File("file2.txt");
        System.out.println(file2.getAbsolutePath());//D:\Programming\ProgrammingLearningPlace\Java\javaSenior\file2.txt
        String path2 = file2.getPath();
        System.out.println(path2);//file2.txt
        System.out.println(file2.getParent());//null

        File file3 = new File("D:\\Programming\\ProgrammingLearningPlace\\Java", "io\\file3.txt");
        System.out.println(file3.getAbsolutePath());
        String path3 = file3.getPath();
        System.out.println(path3);

        File file4 = new File(new File("D:\\Programming\\ProgrammingLearningPlace\\Java"), "io\\file4.txt");
        System.out.println(file4.getAbsolutePath());
        String path4 = file4.getPath();
        System.out.println(path4);

        File file5 = new File("D:\\");//d盘目录下所有文件和文件夹
        String[] list = file5.list();
        for (String s : list) {
            System.out.println(s);//遍历输出文件名
        }
        File[] files = file5.listFiles();//d盘目录下所有文件和文件夹
        for (File file : files) {
            System.out.println(file);//遍历输出文件绝对路径
        }

        File file6 = new File("D:\\Programming\\ProgrammingLearningPlace\\Java\\io\\file1.txt");
        boolean renameTo = file6.renameTo(new File("D:\\IO\\file10.txt"));//D:\IO需要存在
        System.out.println(renameTo);//true

        File file7 = new File("file7.txt");
        if(file7.exists()){
            if(file7.delete()){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }else {
            try {
                boolean newFile = file7.createNewFile();
                if(newFile){
                    System.out.println("创建成功");
                }else{
                    System.out.println("创建失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File file8 = new File("D:\\IO\\file8");
        System.out.println(file8.mkdir());//true
        File file9 = new File("D:\\IO\\io\\file9");
        System.out.println(file9.mkdir());//false
        System.out.println(file9.mkdirs());//true

    }
}
