package mapper;

import java.util.List;

import bean.Collect;
import bean.Vip;

public interface MarkerMapper {
	//通过uid查询该用户书签
	List<Collect> selectMarker(Long uid);
	//增加书签
	void addMarker(Collect collect); 
	//增加书签
	void joinMarker(Collect collect);
	//通过nid查询书签
	Collect selectByNid(Long nid);
	
	//修改introduction相同书签
	void updateMarker(Collect collect);
	
	//修改read的相同书签
	void updateMarker1(Collect collect);
}
