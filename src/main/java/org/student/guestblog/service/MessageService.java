package org.student.guestblog.service;

import org.student.guestblog.model.Message;

import java.util.List;

public interface MessageService {
	public void save(Message message);
	public List<Message> findAll();
}
