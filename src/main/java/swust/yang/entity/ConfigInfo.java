package swust.yang.entity;

public class ConfigInfo {
	
	/**
	 * 检查变量命名
	 */
	private String variableName;
	
	/**
	 * 检查函数注释
	 */
	private String funcAnnotation;
	
	/**
	 * 检查循环嵌套（次数）
	 */
	private String nestedLoop;
	
	/**
	 * 检查选择嵌套（次数）
	 */
	private String nestedSelect;
    
    /**
     * 扩展的过滤器参数
     */
    private String checkExtend;

    /**
     * 该项检查总分
     */
    private Float score;

	public Float getScore() {
		return score;
	}


	public void setScore(Float score) {
		this.score = score;
	}


	public String getCheckExtend() {
		return checkExtend;
	}


	public void setCheckExtend(String checkExtend) {
		this.checkExtend = checkExtend;
	}


	public String getVariableName() {
		return variableName;
	}


	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}


	public String getFuncAnnotation() {
		return funcAnnotation;
	}


	public void setFuncAnnotation(String funcAnnotation) {
		this.funcAnnotation = funcAnnotation;
	}


	public String getNestedLoop() {
		return nestedLoop;
	}


	public void setNestedLoop(String nestedLoop) {
		this.nestedLoop = nestedLoop;
	}


	public String getNestedSelect() {
		return nestedSelect;
	}


	public void setNestedSelect(String nestedSelect) {
		this.nestedSelect = nestedSelect;
	}
}
