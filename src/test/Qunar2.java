package test;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class Qunar2 {
	  public static void main(String[] args){

		  //Properties properties = System.getProperties();
		  //String path = (String)properties.get("user.dir")+properties.get("file.separator")+"test.properties";
		  //try{
			//  FileOutputStream fileOutputStream = new FileOutputStream(path);
          //
			//  Properties pro = new Properties();
			//  pro.setProperty("driver", "oracle.jdbc.dirver.OracleDriver");
			//  pro.store(fileOutputStream,"test");
		  //}catch(FileNotFoundException e ){
		  //	e.printStackTrace();
		  //}catch(IOException e){
		  //	e.printStackTrace();
		  //}
          //
          //
		  //JFrame frame = new JFrame();
		  //int selection = JOptionPane.showConfirmDialog(frame,"安装贤者石？","贤者石",JOptionPane.OK_CANCEL_OPTION);
		  //if(selection == JOptionPane.OK_OPTION){
			//  System.out.println(selection);
		  //}else{
			//  System.out.println("Bad Selection !");
		  //}

		  int[] a = {0,1,2,3,4};
		  int begin = 0;
		  int[] b = {0,1,2,3,4};
		  if(a[b[begin++]]-- >= 0){
			  System.out.println(begin+"ok"+a[b[0]]);
		  }
		  System.out.println(begin+"ok"+a[b[1]]);

		  Map map = System.getenv();
		  Iterator it = map.entrySet().iterator();
		  while(it.hasNext())
		  {
			  Entry entry = (Entry)it.next();
			  System.out.print(entry.getKey()+"=");
			  System.out.println(entry.getValue());
		  }

		  System.out.println("----------------------------------------");

		  Properties properties = System.getProperties();
		  Iterator its =  properties.entrySet().iterator();
		  while(its.hasNext())
		  {
			  Entry entry = (Entry)its.next();
			  System.out.print(entry.getKey()+"=");
			  System.out.println(entry.getValue());
		  }

	  }


}
