package service;

import org.springframework.stereotype.Service;

import MyException.UserException;
import bean.User;


public interface UserService {
  User loginCheck(User user) throws UserException;
  
  void register(User user) throws UserException;
}