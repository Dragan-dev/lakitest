package main.DAO;

import java.util.List;

import main.entity.Message;

public interface MessageDAO {

	public Message getMessage(int id);
	public void deleteMessage(int id);
	public void saveMessage(Message message);
	public long getUnreadMessageCount ();
	public List<Message> getMessageList();
}
