package swust.yang.entity;

public class PluginInfo {
	/**
	 * 插件名
	 */
    private String name;
    
    /**
     * 插件版本
     */
    private String version;
    
    /**
     * 插件接口实现类的类名（包括包名）
     */
    private String class_name;
    
    /**
     * 插件开发者
     */
    private String author;
    
    /**
     * 插件功能描述
     */
    private String description;

    /**
     * 
     * @return 获取实现插件接口的类名（包括包名）
     */
	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
    
	/**
	 * 
	 * @return 获取插件名字
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return 获取插件的版本
	 */
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * 
	 * @return 获取插件的发布者
	 */
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * 
	 * @return 获取插件描述
	 */
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	} 
}
