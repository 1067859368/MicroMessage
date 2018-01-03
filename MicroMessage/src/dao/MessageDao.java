package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import db.DBAccess;
import entity.Page;

import bean.Message;
/**
 * 
 * ��message����ص����ݿ����
 *
 */
public class MessageDao {
	/*
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageList(Map<String,Object> parameter){
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageList(parameter);
//			messageList = sqlSession.selectList("Message.queryMessageList",message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/*
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter){
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageListByPage(parameter);
//			messageList = sqlSession.selectList("Message.queryMessageList",message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/*
	 * 	���ݲ�ѯ������ѯ��Ϣ�б������
	 */
	public int count(Message message){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			// ͨ��sqlSessionִ��SQL���
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			result  = imessage.count(message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		return result;
	}
	
	/**
	 * ����ɾ��
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
			sqlSession.delete("dao.IMessage.deleteOne",id);
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession!=null)
			sqlSession.close();
		}
		
	}
	
	/**
	 * ����ɾ��
	 */
	public void deleteBatch(List<Integer>ids){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
			sqlSession.delete("dao.IMessage.deleteBatch",ids);
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession!=null)
			sqlSession.close();
		}
		
	}
	
	
	/*
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
//	public List<Message> queryMessageList(String command,String description){
//		List<Message> messageList = new ArrayList<Message>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_message","root","lang367788591");
//			StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
//			List<String>paramList = new ArrayList<String>();
//			if(command!=null && !"".equals(command.trim())){
//				sql.append(" and COMMAND=? ");
//				paramList.add(command);
//			} 
//			if(description!=null && !"".equals(description.trim())){
//				sql.append(" and DESCRIPTION like '%' ? '%' ");
//				paramList.add(description);
//			}
//			PreparedStatement statement = conn.prepareStatement(sql.toString());
//			for(int i=0;i<paramList.size();i++){
//				statement.setString(i + 1, paramList.get(i));
//			}
//			ResultSet rs = statement.executeQuery();
//			
//			while(rs.next()){
//				Message message = new Message();
//				messageList.add(message);
//				message.setId(rs.getString("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				message.setContent(rs.getString("CONTENT"));
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return messageList;
//		
//	}
}
