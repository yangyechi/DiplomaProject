package swust.yang.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import swust.yang.entity.ConfigInfo;

public class ConfigInfoManage {

	/**
	 * 
	 * @param config 配置信息
	 * @param filefilter_path 检查规则路径（含文件名）
	 */
	public static void ruleConfig(ConfigInfo config,String filefilter_path) {
		   try(BufferedWriter buffWriter = new BufferedWriter(new FileWriter(filefilter_path))){
			   StringBuilder strBuilder = new StringBuilder();
			   String variableName = config.getVariableName();
			   String funcAnnotation = config.getFuncAnnotation();
			   String nestedLoop = config.getNestedLoop();
			   String nestedSelect = config.getNestedSelect();
			   String checkExtend = config.getCheckExtend();
			   
			   if(variableName != null) {
				   if(variableName.length() > 0) {
					   strBuilder.append(variableName);
				   }
				  
			   }
			   
			   if(funcAnnotation != null) {
				   if(funcAnnotation.length() > 0) {
					   strBuilder.append(funcAnnotation);
				   }
				  
			   }
			   if(nestedLoop != null) {
				   if(nestedLoop.length() > 0) {
					   strBuilder.append(nestedLoop);
				   }
				  
			   }
			   if(nestedSelect != null) {
				   if(nestedSelect.length() > 0) {
					   strBuilder.append(nestedSelect);
				   }
				  
			   }
			   
			   if(checkExtend != null) {
				   if(checkExtend.length() > 0) {
					   strBuilder.append(checkExtend);
				   }
				  
			   }
			   
			   char[] buf = strBuilder.toString().toCharArray();
			   //如果buf为空？
			   buffWriter.write(buf, 0, buf.length);
			   buffWriter.flush();
		   } catch (IOException e) {
			System.err.println("文件写入失败!");
			e.printStackTrace();
		}
	}
}
