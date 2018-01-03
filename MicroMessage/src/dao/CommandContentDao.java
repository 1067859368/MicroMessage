package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Command;
import bean.CommandContent;
import bean.Message;
import db.DBAccess;

/*
 * ��ָ����Ӧ�����ݿ��������
 */
public class CommandContentDao {
	/*
	 * ���ݲ�ѯ������ѯָ���б�
	 */
	public List<Command> queryCommandList(String name,String description){
		DBAccess dbAccess = new DBAccess();
		List<Command> commandList = new ArrayList<Command>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Command command = new Command();
			command.setName(name);
			command.setDescription(description);
			//ͨ��sqlSessionִ��SQL���
			commandList = sqlSession.selectList("Command.queryCommandList",command);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession!=null)
			sqlSession.close();
		}
		return commandList;
	}
	
	/*
	 * ��������
	 */
	public void addBatch(List<CommandContent>commandContent){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
			ICommandContent icommandContent = sqlSession.getMapper(ICommandContent.class);
			icommandContent.addBatch(commandContent);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession!=null)
			sqlSession.close();
		}
	}
}
