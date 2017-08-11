package ua.service;


import java.security.Principal;
import java.util.List;

import ua.entity.User;

public interface UserService {
	void save(User user);
	 public String getUserId(Principal principal);
	 List<User> findAll();
	 User findOne(int id);
	 User findByUserEmail(String username);
}
