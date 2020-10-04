package com.xgen.util.file;


import lombok.Data;

import java.io.*;

public class FileHelper {
    private FileHelper(){

    }

    public static String readFile(String path){
        String content = "";
        DataInputStream din = null;
        try{
            din = new DataInputStream(new BufferedInputStream(
                    FileHelper.class.getClassLoader().getResourceAsStream(path)
            ));
            byte bs[] = new byte[din.available()];
            din.read(bs);
            content = new String(bs);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                din.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    public static void writeFile(String pathName,String content){
        File f = new File(pathName);
        if(f.exists()){
            f.delete();
        }
        DataOutputStream dout = null;
        try{
            f.createNewFile();
            dout = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream(f))
            );
            dout.write(content.getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
    }
}
