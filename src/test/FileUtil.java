package test;

import java.io.File;

/**
 * @author shaoka.ssk
 * @date 2018/5/20
 */
public class FileUtil {
    /**
     * 文件或目录是否已经存在
     * @param path
     * @return 存在返回true
     */
    public static boolean FileExist(String path){
        System.out.println("OK");
        File file = new File(path);
        if(file.exists()){
            return true;
        }
        return false;
    }
}
