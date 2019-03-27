package swust.yang.util;

import net.sf.json.JSONObject;
import swust.yang.entity.ConfigInfo;

public class JSonToObject {
	
	public static ConfigInfo JSonStrToObject(String config_info) {
		  
		  if(config_info.indexOf("[") != -1){  
			  config_info = config_info.replace("[", "");  
	      }  
	      if(config_info.indexOf("]") != -1){  
	        	config_info = config_info.replace("]", "");  
	      }
	      JSONObject jsonObject = JSONObject.fromObject(config_info);
	      ConfigInfo config_info_obj = 
	    		  (ConfigInfo)JSONObject.toBean(jsonObject,ConfigInfo.class);
	      return config_info_obj;
	}

}
