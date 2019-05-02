package service;

import MyException.UploadException;
import bean.User;

/**
 * @author LX
 * @date 2019/5/1 - 18:18
 */
public interface UploadService {

    void updUser(User user) throws UploadException;
}
