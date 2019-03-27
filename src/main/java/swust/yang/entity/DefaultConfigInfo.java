package swust.yang.entity;

public class DefaultConfigInfo {
	/**
	 * 过滤器的默认配置
	 */
	public static final String base_filter = 
			"--filter=-whitespace,-build,-legal,-readability,-runtime";
	

	/**
	 * nsiqcppstyle.py文件的绝对路径
	 */
    public static final String tool_path = 
    		System.getProperty("user.dir") + "\\src\\main\\resources\\nsiqcppstyle\\nsiqcppstyle.py";
	
    /**
	  * 错误统计的详细程度
	 */
    public static final String counting_level = "--counting=detailed";
    
    /**
     * 错误信息输出格式
     */
    public static final String output_format = "--output=csv";
    
}
