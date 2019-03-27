package swust.yang.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)  
public class CheckFileTest {
	
	private String path;
    private int exp;
    private static final String root_path = System.getProperty("user.dir");
    
	public CheckFileTest(String path,int exp) {
		this.path = path;
		this.exp = exp;
	}

	@Parameters  
	public static Collection<Object[]> prepareData(){  
        Object [][] object = {
        		{root_path + "\\src\\test\\resources\\test1.txt",0},
        		{root_path + "\\src\\test\\resources\\test2.txt",0},
        		{root_path + "\\src\\test\\resources\\test3.txt",0},
        		{root_path + "\\src\\test\\resources\\test4.txt",1},
        		{root_path + "\\src\\test\\resources\\test5.txt",0},
        		}; 
        return Arrays.asList(object);  
    }  
	
	@Test
	public void test() {
		int ret = CheckFile.checkCppFile(path);
		assertEquals(exp, ret);
	}

}
