package mapper;

import java.util.List;

import bean.Collect;

public interface MarkerMapper {
	List<Collect> selectMarker(Long uid);
	void addMarker(Collect collect); 
	void joinMarker(Collect collect);
}
