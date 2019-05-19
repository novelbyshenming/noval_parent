package service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyException.CollectException;
import bean.Collect;
import mapper.CollectMapper;

@Service
public class CollectService {
	@Autowired
	private CollectMapper collectMapper;
	
	//根据用户id查询信息
	public Map<String,Collect> selectByUid(long uid) throws CollectException {
		Map<String,Collect> map = collectMapper.selectByUid(uid);
		return map;
		
	}
}
