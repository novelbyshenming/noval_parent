package mapper;

import java.util.Map;

import bean.Collect;

public interface CollectMapper {
	Map<String,Collect> selectByUid(Long uid);
}
