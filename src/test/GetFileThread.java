package test;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetFileThread extends Thread{
    long startPos,endPos;//传入的文件下载开始、结束点
    String currentFileThreadName;//要带上完整的路径
    String urlFile;//网络文件地址
    int currentThread;//当前是那个线程，这主要是用于下载完成后将对应的检测标志设为true，表示下载完成
    /**
     *
     * @param urlFile 网络文件地址
     * @param startPos 网络开始下载点
     * @param endPos 网络文件结点
     * @param currentFileThreadName 当前线程的完程路径及名字
     * @param currentThread 当前是第几个线程
     */
    public GetFileThread(String urlFile,long startPos,long endPos,String currentFileThreadName,int currentThread)
    {
        this.startPos=startPos;
        this.endPos=endPos;
        this.currentFileThreadName=currentFileThreadName;
        this.urlFile=urlFile;
        this.currentThread=currentThread;
    }
    private boolean FileExist(String pathAndFile)
    {
        File file = new File(pathAndFile);
        if (file.exists())
            return true;
        else
            return false;
    }

    private long FileSize(String pathAndFile)
    {
        long fileSize=0;
        File filet = new File(pathAndFile);
        fileSize=filet.length();
        return fileSize;
    }

    private void FileRename(String fName, String nName)
    {
        File file = new File(fName);
        file.renameTo(new File(nName));
        file.delete();
    }

    public void run()
    {
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        DataOutputStream dos = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        String localFile = currentFileThreadName; //文件保存的地方及文件名，具体情况可以改
        String localFile_tp = localFile + ".tp"; //未下载完文件加.tp扩展名，以便于区别
        long fileSize = 0;//在断点续传中，用于取得当前文件已经下载的大小
        int len = 0;
        byte[] bt = new byte[1024];//缓冲区
        //byte[] buffer=new byte[50*1024];
        RandomAccessFile raFile = null;
        long TotalSize = 0; //当前块要下载的文件总大小
        try
        {
            url = new URL(urlFile);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            //TotalSize = Long.parseLong(urlc.getHeaderField("Content-Length"));//取得网络文件大小
            TotalSize=endPos-startPos;//取得要该块文件实际要写的大小
            long downSize=0;//已经下载的大小
            //确定临时文件是否存在
            if (FileExist(localFile_tp)) //采用断点续传，这里的依据是看下载文件是否在本地有.tp有扩展名同名文件
            {
                System.out.println("文件续传中...");
                fileSize=new File(localFile_tp).length();//取得已经下载的大小，以便确定随机写入的位置
                downSize=fileSize;//下载大小
                fileSize=fileSize+startPos;//取得文件开始写入点
                //设置User-Agent
                //urlc.setRequestProperty("User-Agent","NetFox");
                /**
                 * httpURLConnection属性的设置一定要在得到输入流之前，否则会报已经连接的错误
                 */
                //设置断点续传的开始位置
                //synchronized(new Object()){
                httpURLConnection.setRequestProperty("RANGE", "bytes=" + fileSize + "-");
                //urlc.setRequestProperty("RANGE", "bytes="+fileSize);//这样写不行，不能少了这个"-".
                //设置接受信息
                httpURLConnection.setRequestProperty("Accept",
                    "image/gif,image/x-xbitmap,application/msword,*/*");
                //}
                raFile = new RandomAccessFile(localFile_tp, "rw"); //随机方位读取
                raFile.seek(downSize); //定位指针到fileSize位置
                bis = new BufferedInputStream(httpURLConnection.getInputStream());
                while ((len = bis.read(bt)) > 0)
                {
                    if(downSize<(endPos-startPos))
                    {
                        downSize=downSize+len;
                        if(downSize>(endPos-startPos))
                        {
                            len=(int)((endPos-startPos)-(downSize-len));
                        }
                        raFile.write(bt, 0, len);
                    }
                    else
                        break;
                }
                //System.out.println("文件续传接收完毕！");
            }
            else if(!FileExist(localFile))//采用原始下载，但保证该文件没有下载
            {
                //设置断点续传的开始位置
                httpURLConnection.setRequestProperty("RANGE", "bytes=" + startPos + "-");
                bis = new BufferedInputStream(httpURLConnection.getInputStream());
                fos = new FileOutputStream(localFile_tp); //没有下载完毕就将文件的扩展名命名.tp
                dos = new DataOutputStream(fos);
                //System.out.println("正在接收文件...");
                while ((len = bis.read(bt)) > 0)
                {
                    if(downSize<(endPos-startPos))//确定没有下载完毕
                    {
                        downSize=downSize+len;
                        if(downSize>(endPos-startPos))//如果当前下载的加上要下载的已经超过要求的下载范围
                        {
                            len=(int)((endPos-startPos)-(downSize-len));//就只取满足要求的下功部份
                        }
                        dos.write(bt, 0, len);//写文件
                    }
                    else
                        break;
                }
            }
            if (bis != null)
                bis.close();
            if (dos != null)
                dos.close();
            if (fos != null)
                fos.close();
            if (raFile != null)
                raFile.close();
            //System.out.println("localFile_bak:" + FileSize(localFile_bak));
            if (FileSize(localFile_tp) == TotalSize) //下载完毕后，将文件重命名
            {
                FileRename(localFile_tp, localFile);
            }
            MultiThreadGetFile.checkList[currentThread]=true;
        }
        catch (Exception e)
        {
            try
            {
                if (bis != null)
                    bis.close();
                if (dos != null)
                    dos.close();
                if (fos != null)
                    fos.close();
                if (raFile != null)
                    raFile.close();
            }
            catch (IOException f)
            {
                f.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
