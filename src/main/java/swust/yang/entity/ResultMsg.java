package swust.yang.entity;

public class ResultMsg {
	
	/**
	 * 学生信息
	 */
	private String student_infor;
	
	/**
	 * 作业得分
	 */
	private float score;
	
	public String getStudent_infor() {
		return student_infor;
	}

	public void setStudent_infor(String student_infor) {
		this.student_infor = student_infor;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

}
