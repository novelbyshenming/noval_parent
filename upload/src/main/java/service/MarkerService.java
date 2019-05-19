package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyException.MarkerException;
import bean.Collect;
import mapper.MarkerMapper;

@Service
public class MarkerService {
	@Autowired
	private MarkerMapper markerMapper;
	
	public void addMarker(Collect collect)throws MarkerException{
		markerMapper.addMarker(collect);
	}
	
	public void joinMarker(Collect collect)throws MarkerException{
		markerMapper.joinMarker(collect);
	}
}
