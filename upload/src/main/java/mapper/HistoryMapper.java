package mapper;

import bean.History;

/**
 * @author sm
 *
 */
public interface HistoryMapper {
	//新增
	void newRecord(History history);
	
	//修改
	int updRecord(History history);
	
	//查询
	History selectRecord(long nid);
}
