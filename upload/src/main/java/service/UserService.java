package service;

import MyException.UserException;
import bean.User;
import bean.Vip;


public interface UserService {

  public static final int i = 4 ;
  User loginCheck(User user) throws UserException;
  
  void register(User user) throws UserException;
  
  User selectByUid(Long uid) throws UserException;
  
  User selectByName(String name) throws UserException;
  
  User selectByEmail(String email) throws UserException;
  
  Long selectUid(String name) throws UserException;
  
  Vip selectVip(Long uid) throws UserException;
  
  void updateVip(Long uid) throws UserException;
  
  void addVip(Vip vip)throws UserException;
}
