package swust.yang.main;

import swust.yang.entity.ResultMsg;
import swust.yang.service.impl.CpplintPlug;

public class Main {

	public static void main(String[] args) {
		//ConfigInfo config = new ConfigInfo();
		//config.setFuncAnnotation("~ RULE_5_3_A_provide_doxygen_function_comment_on_function_in_impl");
		CpplintPlug cpplint = new CpplintPlug();
		String config_info = 
		"{\"funcAnnotation\":\"~ RULE_5_3_A_provide_doxygen_function_comment_on_function_in_impl\",\"score\":20}";
	    String file_path = "E:\\test\\5120152516.cpp";
	    String log_path = "E:\\log";
	    ResultMsg msg = cpplint.singleExecute(config_info, file_path, log_path);
	    System.out.println("学生信息：" + msg.getStudent_infor());
	    System.out.println("本次得分：" + msg.getScore());
	}

}
