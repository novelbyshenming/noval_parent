package mapper;

import java.util.List;
import bean.Collect;
import bean.Novel;

public interface CollectMapper {
	List<Collect> selectByUid(Long uid);
	
	Novel selectByNid(Long nid);
	
}
