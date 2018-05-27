package test;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

public class MultiThreadGetFile extends Thread{
    long startPos=0,endPos=0;
    String currentFileThreadName;//要带上完整的路径
    String urlFile;//网络文件地址
    String urlFileName;//网络文件名
    String localFileAddress;//下载文件要存放的地址
    int threadNum;//要同时下载的线程数
    long[] eachThreadLength;//每个线程要下功的文件分块的大小
    long urlFileLength;//网络文件的大小
    URL url;
    HttpURLConnection httpURLConnection;
    public static boolean[] checkList;//检测线程
    public MultiThreadGetFile(String urlFile,int threadNum,String localFileAddress)
    {
        this.urlFile=urlFile;
        this.threadNum=threadNum;//要同时下载的线程数
        this.localFileAddress=localFileAddress;

    }
    private void init_getEachThreadLength()//确定每个线程文件最终要写的文件在大小
    {
        long l;
        l=urlFileLength/threadNum;
        for(int i=0;i<threadNum;i++)
        {
            if(i==threadNum-1)//如果是分配最后一个线程了
            {
                eachThreadLength[i]=urlFileLength-i*l;
            }
            else
                eachThreadLength[i]=l;
        }
    }
    private String GetFileName(String file)
    {
        StringTokenizer st=new StringTokenizer(file,"/");
        while(st.hasMoreTokens())
        {
            file=st.nextToken();
        }
        return file;
    }
    private void init()
    {

        if(!new File(localFileAddress+"tmp").mkdir())//创建一个临时文件夹
        {
            System.out.println("创建文件夹失败！");
        }
        eachThreadLength=new long[threadNum];
        try
        {
            url=new URL(urlFile);
            httpURLConnection=(HttpURLConnection)url.openConnection();
            urlFileLength=Long.parseLong(httpURLConnection.getHeaderField("Content-Length"));
            urlFileName=url.getFile();//取得在服务器上的路径及文件名
            urlFileName=GetFileName(urlFileName);//只得文件名
            init_getEachThreadLength();
            httpURLConnection.disconnect();
            checkList=new boolean[threadNum+1];
            for(int i=1;i<=threadNum;i++)
            {
                if(i>1)
                    startPos=startPos+eachThreadLength[i-2];
                endPos=startPos+eachThreadLength[i-1];
                currentFileThreadName=localFileAddress+"tmp//"+urlFileName+".part"+i;
                //System.out.println("startPos:"+(startPos));
                //System.out.println("endPos:"+(endPos));
                //System.out.println("Size:"+(endPos-startPos));
                Thread thread=new Thread(new GetFileThread(urlFile,startPos,endPos,currentFileThreadName,i));
                thread.start();
                checkList[i]=false;//表示该线程开始
            }
            Thread policeThread=new Thread(new PoliceThread(threadNum,localFileAddress,localFileAddress+"tmp"));
            policeThread.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void run()
    {
        init();
    }
}
