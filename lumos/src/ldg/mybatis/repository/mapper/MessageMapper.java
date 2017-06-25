package ldg.mybatis.repository.mapper;

import java.util.List;

import ldg.mybatis.model.Message;

public interface MessageMapper {
	List<Message> selectSendMessage(String u_num);
	List<Message> selectRecMessage(String u_num);
	Message selectMessageByPrimaryKey(int m_id);
	Integer insertMessage(Message message);
	Integer flagMessage(int m_id);
	//Ż��� message ��������޴»�� '�˼�����' ���� �ٲ�
	Integer updateMessageRecvUser(String stu_num);
	Integer updateMessageSendUser(String stu_num);
}
