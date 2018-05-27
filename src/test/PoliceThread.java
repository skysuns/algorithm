package test;

public class PoliceThread   extends Thread
{
    int totalThread;
    String localFileAddress;
    String localFileAddress_tmp;

    public PoliceThread(int totalThread, String localFileAddress,
                        String localFileAddress_tmp)
    {
        this.totalThread = totalThread;
        this.localFileAddress = localFileAddress;
        this.localFileAddress_tmp = localFileAddress_tmp;
    }

    public void run()
    {
        boolean isRun = true;
        int allStop = 0;
        while (isRun)
        {
            allStop=0;
            for (int i = 1; i <= totalThread; i++)
            {
                if (MultiThreadGetFile.checkList[i] == true)
                {
                    allStop++;
                }
            }
            try
            {
                this.sleep(500);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            if (allStop == totalThread)
                isRun = false;
        }
        Thread thread =
            new Thread(new FileCombination(localFileAddress, localFileAddress_tmp));
        thread.start();
    }
}