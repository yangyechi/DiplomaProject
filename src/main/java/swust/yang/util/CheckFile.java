package swust.yang.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class CheckFile {
	
	/**
	 * 
	 * @description 检查提交的代码中是否有NOLINT注释(区分大小写)
	 * @param 待检查的文件路径
	 * @return 有NOLINT注释(区分大小写)返回1,没有则返回0。 如果打开文件/关闭文件失败，则返回-1
	 */
    public static int checkCppFile(String path) {
    	String text = null;
    	try (BufferedReader read_buffer = new BufferedReader(new FileReader(path))){
			 while((text = read_buffer.readLine()) != null) {
				String pattern = ".*\\WNOLINT\\W.*";
				boolean isMatch = Pattern.matches(pattern, text);
				if(isMatch) {
					return 1;
				}
			 }
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件，路径错误！");
			e.printStackTrace();
			return -1;
		}catch (IOException e) {
			System.out.println("关闭IO流失败！");
			e.printStackTrace();
			return -1;
		}
    	return 0;
    }
}
