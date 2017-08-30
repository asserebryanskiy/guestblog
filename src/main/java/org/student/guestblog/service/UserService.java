package org.student.guestblog.service;

import org.student.guestblog.model.User;

public interface UserService {
	User addUser(User user);
	void deleteUser(User user);

	User findByUsername(String username);
}
