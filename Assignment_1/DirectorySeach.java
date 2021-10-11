package Assignment_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DirectorySeach {
    public static int fileSearch(String path,String file){
        int flag = 0;
        try{
            Process process = Runtime.getRuntime().exec(path);
            BufferedReader outputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s = " ";
            while((s=outputStream.readLine())!=null){
                if(s.contains(file)) {
//                    System.out.println(s);
                    flag++;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public static void main(String[] args) {
        String path = "ls /home/arvinc/play-ground";
        String file = "hello";
        if(fileSearch(path,file)>0){
            System.out.println("file found in the directory");
        }else{
            System.out.println("file not found in the directory");
        }
    }
}
