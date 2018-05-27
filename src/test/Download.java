package test;

import java.util.Properties;

public class Download {
    /*
网络文件地址
 */
    String urlFile;

    /*
    要启动下载的线程数
     */
    int threadNum;

    /*
    要保存的本地地址，请保重该处没有名为"tmp"的文件夹
     */
    String localFileAddress;

    public Download()
    {
        /**
         * 下面的由使用者自己设为定
         */
        urlFile="http://www.netbox.cn/download/nbsetup.EXE";
        //要同时下载的线程数
        threadNum=9;
        Properties properties = System.getProperties();
        localFileAddress= (String)properties.get("user.dir") + properties.get("file.separator");
    }

    private void start()
    {
        Thread thread=new Thread(new MultiThreadGetFile(urlFile,threadNum,localFileAddress));
        thread.start();
    }

    public static void main(String[] args)
    {
        Download main = new Download();
        main.start();
    }
}
