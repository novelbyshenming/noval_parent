package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyException.BizException;
import bean.History;
import mapper.HistoryMapper;

/**
 * 
 * @author sm
 *
 */
@Service
public class HistoryService {

	@Autowired
	private HistoryMapper historyMapper;

	//新增用户小说记忆
	public void newRecord(History history) throws BizException{
		historyMapper.newRecord(history);
	}
	
	//修改阅览记忆章节
	public int updRecord(History history) throws BizException{
		return historyMapper.updRecord(history);
	}
	
	//查询阅览记忆章节
	public History selRecord(long uid,long nid) throws BizException{
		return historyMapper.selectRecord(uid,nid);
	}
}
