package dao;

import java.util.List;
import java.util.Map;

import bean.Message;

/*
 * 与Message配置文件相对应的接口
 */
public interface IMessage {
	
	public List<Message> queryMessageList(Map<String, Object> parameter);
	
	public int count(Message message);
	
	public List<Message> queryMessageListByPage(Map<String, Object> parameter);
	
}

