package service;

import java.util.ArrayList;
import java.util.List;

import bean.Message;

import dao.MessageDao;

/*
 * ά����ص�ҵ����
 */
public class MaintainService {
	/**
	 * ����ɾ��
	 */
	public void deleteOne(String id){
		if(id!=null && !"".equals(id.trim())){
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}
	/**
	 * ����ɾ��
	 */
	public void deleteBatch(String[] ids){
		MessageDao messageDao = new MessageDao();
			List<Integer>idlist = new ArrayList<Integer>();
			for (String id : ids) {
				idlist.add(Integer.valueOf(id));
			}
			messageDao.deleteBatch(idlist);
	}
}