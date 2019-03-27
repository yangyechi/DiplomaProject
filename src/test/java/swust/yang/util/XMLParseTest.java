package swust.yang.util;


import org.junit.Test;

import swust.yang.entity.ConfigInfo;

public class XMLParseTest {

	@Test
	public void testCreateXML() {
		ConfigInfo config_info = new ConfigInfo();
		//config_info.setCheckExtend("extend Param");
		//config_info.setFuncAnnotation("yes");
		config_info.setScore(30.5f);
		config_info.setNestedLoop("yes");
		config_info.setNestedSelect("yes");
		config_info.setVariableName("yes");
		XMLParse.createXML(config_info,"cpplint.xml");
	}

}
