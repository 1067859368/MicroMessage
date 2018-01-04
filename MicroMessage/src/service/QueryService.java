package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import util.Iconst;

import bean.Command;
import bean.CommandContent;
import bean.Message;

import dao.CommandDao;
import dao.MessageDao;
import entity.Page;

/**
 *��ѯ��ص�ҵ����
 */
public class QueryService {
	public List<Message> queryMessageList(String command,String description,Page page){
		//��֯��ѯ����
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		MessageDao messageDao = new MessageDao();
		//����������ѯ����
		int totalNumber = messageDao.count(message);
		//��֯��ҳ��ѯ����
		page.setTotalNumber(totalNumber);
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("message", message);
		parameter.put("page", page);
		//��ҳ��ѯ�����ؽ��
		return messageDao.queryMessageList(parameter);
		
	}
	
	/**
	 * ���ݲ�ѯ������ҳ��ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageListByPage(String command,String description,Page page){
		
		Map<String,Object> parameter = new HashMap<String,Object>();
		
		//��֯��ѯ����
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		
		MessageDao messageDao = new MessageDao();
		//����������ѯ����
		//��֯��ҳ��ѯ����
		parameter.put("message", message);
		parameter.put("page", page);
		//��ҳ��ѯ�����ؽ��
		return messageDao.queryMessageListByPage(parameter);
	}
	
	/*
	 * ͨ��ָ���ѯ�Զ��ظ�������
	 * @param command ָ��
	 * @return �Զ��ظ�������
	 * 
	 */
	public String queryByCommand(String command){
		CommandDao commandDao = new CommandDao();
		List<Command>commandList;
		if(Iconst.HELP_COMMAND.equals(command)){
			commandList = commandDao.queryCommandList(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0;i<commandList.size();i++){
				if(i!=0){
					result.append("<br/>");
				}
				result.append("�ظ�[" + commandList.get(i).getName() +"]���Բ鿴" + commandList.get(i).getDescription());
			}
			return result.toString();
		}
		commandList = commandDao.queryCommandList(command, null);
		if(commandList.size()>0){
			List<CommandContent> contentList = commandList.get(0).getContentList();
			int i = new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}