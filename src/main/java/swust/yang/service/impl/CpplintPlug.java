package swust.yang.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import swust.yang.entity.ConfigInfo;
import swust.yang.entity.DefaultConfigInfo;
import swust.yang.entity.PluginInfo;
import swust.yang.entity.ResultMsg;
import swust.yang.service.IPlug;
import swust.yang.util.ConfigInfoManage;
import swust.yang.util.JSonToObject;
import swust.yang.util.RunTask;
import swust.yang.util.XMLParse;

public class CpplintPlug implements IPlug {

	public ResultMsg singleExecute(String config_info, String file_path,String log_path) {
		//规则文件路径
		String filefilter_path =  file_path.substring(0,file_path.lastIndexOf("\\") + 1) + "filefilter.txt";
		
		//学生信息
	    String student_info = 
						file_path.substring(file_path.lastIndexOf('\\') + 1, file_path.lastIndexOf('.') );
		//日志的命名格式
		String log_name = student_info + ".log";
		
		//日志存储位置（含文件名）
		log_path = log_path + "\\" + log_name;
		
		//运行命令
		StringBuilder execute_command = 
				new StringBuilder("python" + " " + DefaultConfigInfo.tool_path + " "
					+ DefaultConfigInfo.output_format + " " + "-o" + " " + log_path + " " 
					+ "-f" + " " + filefilter_path + " " + file_path);
	    System.out.println(execute_command);
		
		//将前端返回的包含配置信息的JSon字符串转换为对象
		ConfigInfo config_obj = JSonToObject.JSonStrToObject(config_info);
		
		//配置规则
		ConfigInfoManage.ruleConfig(config_obj, filefilter_path);
		
		//执行作业
		try {
			RunTask.runCommand(execute_command.toString());
		} catch (IOException e) {
			System.err.println("作业执行失败！");
			e.printStackTrace();
		}
		
		//分析执行日志
		float taskScore = RunTask.getTaskScore(log_path);
		
		ResultMsg msg = new ResultMsg();
		msg.setStudent_infor(student_info);
		msg.setScore(taskScore);
		return msg;
	}

	public List<ResultMsg> batchExecute(String config_info,String src_dir,String dest_path) {
		List<ResultMsg> msgs = new ArrayList<ResultMsg>();
		//配置解析
		//文件批量执行
		
		return msgs;
	}

	public void saveBaseInfo(String config_info,String file_path) {
		XMLParse.createXML(JSonToObject.JSonStrToObject(config_info), file_path);
	}

	public PluginInfo getPluginInfo() {
		PluginInfo cpplint_Info = new PluginInfo();
		cpplint_Info.setName("CpplintPlug.jar");
		cpplint_Info.setAuthor("yangyechi");
		cpplint_Info.setDescription("Code specification check plug-in");
		cpplint_Info.setVersion("1.0");
		cpplint_Info.setClass_name("swust.yang.service.impl.CpplintPlug");
		return cpplint_Info;
	}

	public String getHtml(String preSetting) {
		String html = "<div id = \"cpplint\" style=\"width: 700px; height: 500px;\">\r\n" + 
				"    分数设置：\r\n" + 
				"    <input type=\"text\" name=\"score\" value=\"\"  placeholder=\"大于0小于等于100\" style=\"width: 120px;\">\r\n" + 
				"    <br />\r\n" + 
				"    检查函数注释\r\n" + 
				"    <input type=\"checkbox\" name=\"funcAnnotation\" value=\"~ RULE_5_3_A_provide_doxygen_function_comment_on_function_in_impl\" >\r\n" + 
				"    <br />\r\n" + 
				"    检查变量命名\r\n" + 
				"    <input type=\"checkbox\" name=\"variableName\" value=\"\" >\r\n" + 
				"    <br />\r\n" + 
				"    检查循环嵌套次数\r\n" + 
				"    <input type=\"checkbox\" name=\"nestedLoop\" value=\"\" > \r\n" + 
				"    <br />\r\n" + 
				"    检查选择嵌套次数\r\n" + 
				"    <input type=\"checkbox\" name=\"nestedSelect\" value=\"\" >\r\n" + 
				"    <p style=\"line-height:0px\">其他检查项：<p>\r\n" + 
				"    <textarea name=\"checkExtend\" placeholder=\"请输入完整的规则,规则间用分号分割.\" style=\"width: 460px; height: 120px;\"></textarea>\r\n" + 
				"    <br />\r\n" + 
				"</div>";
		return html;
	}

}
