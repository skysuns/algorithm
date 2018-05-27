package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandUtil {
    /**
     * 判断贤者石是否已经安装且可正常启动
     * @return 已安装，返回true
     */
    public static boolean IsInstallPhilstone(){
        String path = "open -n /Applications/Sii.app";
        return CanRunCommand(path);
    }

    public static boolean IsCsrutil(){
        String path = "csrutil status";
        return CanRunCommand(path);
    }

    public static boolean CanRunCommand(String command){
        Runtime rt = Runtime.getRuntime();
        try{
            Process pr = rt.exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code " + exitVal);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
