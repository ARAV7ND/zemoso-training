package Assignment_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DirectorySeach {

    public static void findFile(String path,String fileName){
        File fileDirectory = new File(path);
        File[] fileList = fileDirectory.listFiles();
        boolean flag = false ;
        if(fileList==null){
            System.out.println("Empty directory");
        }else{
            for(File file : fileList){
                if(file.getName().equalsIgnoreCase(fileName)){
                    System.out.println("File found at : "+file.getAbsolutePath());
                    flag = true;
                }
            }
        }
        if(!flag){
            System.out.println("File not found");
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String path = "/home/arvinc/play-ground";
//        String file = "hello.txt";
        String path = scanner.next();
        String fileName = scanner.next();
        findFile(path,fileName);
    }
}
