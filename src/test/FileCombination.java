package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FileCombination extends Thread
{
    String srcDirectory=null;//拆分文件存放的目录
    String trueDirectory;//结果文件存放目录
    String[] separatedFiles;//存放所有拆分文件名
    String[][] separatedFilesAndSize;//存放所有拆分文件名及分件大小
    int FileNum=0;//确定文件个数
    String fileRealName="";//据拆分文件名确定现在原文件名
    public FileCombination(String trueDirectory,String srcDirectory)
    {
        this.srcDirectory=srcDirectory;
        this.trueDirectory=trueDirectory;
    }
    /**
     *
     * @param sFileName 任一一个拆分文件名
     * @return 原文件名
     */
    private String getRealName(String sFileName)
    {
        StringTokenizer st=new StringTokenizer(sFileName,".");
        return st.nextToken()+"."+st.nextToken();
    }
    /**
     * 取得指定拆分文件模块的文件大小
     * @param FileName 拆分的文件名
     * @return
     */
    private long getFileSize(String FileName)
    {
        FileName=srcDirectory+"//"+FileName;
        return (new File(FileName).length());
    }
    /**
     * 生成一些属性，做初使化
     * @param drictory 拆分文件目录
     */
    private void getFileAttribute(String drictory)
    {
        File file=new File(drictory);
        separatedFiles=new String[file.list().length];//依文件数目动态生成一维数组，只有文件名
        separatedFiles=file.list();
        //依文件数目动态生成二维数组，包括文件名和文件大小
        //第一维装文件名，第二维为该文件的字节大小
        separatedFilesAndSize=new String[separatedFiles.length][2];
        Arrays.sort(separatedFiles);//排序
        FileNum=separatedFiles.length;//当前文件夹下面有多少个文件
        for(int i=0;i<FileNum;i++)
        {
            separatedFilesAndSize[i][0]=separatedFiles[i];//文件名
            separatedFilesAndSize[i][1]=String.valueOf(getFileSize(separatedFiles[i]));//文件大上
        }
        fileRealName=getRealName(separatedFiles[FileNum-1]);//取得文件分隔前的原文件名
    }
    /**
     * 合并文件：利用随机文件读写
     * @return true为成功合并文件
     */
    private boolean CombFile()
    {
        RandomAccessFile raf=null;
        long alreadyWrite=0;
        FileInputStream fis=null;
        int len=0;
        byte[] bt=new byte[1024];
        try
        {
            raf = new RandomAccessFile(trueDirectory+"//"+fileRealName,"rw");
            for(int i=0;i<FileNum;i++)
            {
                raf.seek(alreadyWrite);
                //System.out.println("alreadyWrite:"+alreadyWrite);
                fis=new FileInputStream(srcDirectory+"//"+separatedFilesAndSize[i][0]);
                while((len=fis.read(bt))>0)
                {
                    raf.write(bt,0,len);
                }
                fis.close();
                alreadyWrite=alreadyWrite+Long.parseLong(separatedFilesAndSize[i][1]);
            }
            raf.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            try
            {
                if(raf!=null) {
                    raf.close();
                }
                if(fis!=null){
                    fis.close();
                }
            }
            catch (IOException f)
            {
                f.printStackTrace();
            }
            return false;
        }
        return true;
    }
    public void deleteTmp()
    {
        for(int i=0;i<FileNum;i++)
        {
            File file=new File(srcDirectory+"//"+separatedFilesAndSize[i][0]);
            file.delete();
        }
        File file1=new File(srcDirectory);
        file1.delete();
    }

    @Override
    public void run()
    {
        getFileAttribute(srcDirectory);
        CombFile();
        deleteTmp();
    }
}
