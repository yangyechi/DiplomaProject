package swust.yang.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunTask {
     
	public static void runCommand(String execute_command) throws IOException{
    	  Process p = Runtime.getRuntime().exec("cmd /c start cmd.exe /c " + execute_command); 
          BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));   
          String readLine = br.readLine();   
          while (readLine != null) { 
              readLine = br.readLine(); 
              System.out.println(readLine); 
          } 
          if(br!=null){ 
              br.close(); 
          } 
          p.destroy(); 
          p = null; 
     }
	
	/**
	 * 
	 * @param log_path 作业运行日志路径
	 * @return 返回作业得分
	 */
	public static float getTaskScore(String log_path) {
		System.out.println(log_path);
		return 0.0f;
	}
}
