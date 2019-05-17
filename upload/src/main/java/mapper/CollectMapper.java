package mapper;

import java.util.List;

import bean.Collect;

public interface CollectMapper {
	List<Collect> selectByUid(Long uid);
}
