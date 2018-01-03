package bean;

public class CommandContent {
	/*
	 * 主键
	 */
	private String id;
	/*
	 * 回复内容
	 */
	private String content;
	/*
	 * 内容主键
	 */
	private String content_id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	
	
}
