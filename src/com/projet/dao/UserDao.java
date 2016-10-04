package com.projet.dao;

import java.util.List;
import com.projet.model.User;

	public interface UserDao{
		
		public User addUser(User User);
		
		public User findUserById(Long id);
		
		public List<User> getAllUser();
		
		public void updateUser(User User);
		
		public void removeUser(User User);
}
