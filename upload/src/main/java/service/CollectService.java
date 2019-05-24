package service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyException.CollectException;
import bean.Collect;
import bean.Novel;
import mapper.CollectMapper;

@Service
public class CollectService {
	@Autowired
	private CollectMapper collectMapper;
	
	//根据用户id查询信息
	public List<Collect> selectByUid(long uid) throws CollectException {
		
		
		
		List<Collect> list = collectMapper.selectByUid(uid);
		
		for(Collect a:list){
		 Novel novel =collectMapper.selectByNid(a.getNid());
		 a.setName(novel.getNovelName());
		}
		return list;
	}
}
