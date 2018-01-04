package dao;


import java.util.List;

import bean.CommandContent;

/*
 * 与ConmandContent配置文件相对应的接口
 */
public interface ICommandContent {
	
	public void addBatch(List<CommandContent> commandContent);
	
}

