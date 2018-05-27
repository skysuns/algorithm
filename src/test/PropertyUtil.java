package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.swing.*;

public class PropertyUtil {
    /**
     * 获取安装目录
     * @param frame
     * @return
     */
    public String getInstallPath(JFrame frame){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(frame);
        if(result == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile().getPath();
        }else if(result == JFileChooser.ERROR_OPTION){
            return "";
        }else{
            return "";
        }
    }

    /**
     * 保存配置信息
     * @param properties
     */
    public void saveProperties(Properties properties){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(new File(""));
            properties.store(fileOutputStream,"philStone配置文件");
        }catch(FileNotFoundException e ){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 获取配置属性
     * @param key
     * @return
     */
    public String getProperty(String key){
        String result = null;
        Properties properties = new Properties();
        try {
            System.out.println("");
            // 使用InPutStream流读取properties文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
            properties.load(bufferedReader);
            // 获取key对应的value值
            result = properties.getProperty(key);
            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
