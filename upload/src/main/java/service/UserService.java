package service;

import MyException.UserException;
import bean.User;


public interface UserService {
  User loginCheck(User user) throws UserException;
  
  void register(User user) throws UserException;
  
  User selectByUid(Long uid) throws UserException;
  
  User selectByName(String name) throws UserException;
  
  User selectByEmail(String email) throws UserException;
}
