package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
		SimpleDateFormat df = new SimpleDateFormat("MM-dd");
		String ctimes = df.format(new Date());
		System.out.println(ctimes);
		Long uid = collect.getUid();
		collect.setUid(uid);
		collect.setCtimes(ctimes);
		if(markerMapper.selectByNid(collect.getNid()) != null){
			markerMapper.updateMarker(collect);
		}else{
			markerMapper.joinMarker(collect);
		}
	}
	
	public void joinMarker(Collect collect)throws MarkerException{
		SimpleDateFormat df = new SimpleDateFormat("MM-dd");
		String ctimes = df.format(new Date());
		Long uid = collect.getUid();
			collect.setUid(uid);
			collect.setCtimes(ctimes);
			if(markerMapper.selectByNid(collect.getNid()) != null){
				markerMapper.updateMarker1(collect);
			}else{
				markerMapper.joinMarker(collect);
			}
	}
	
	public List<Collect> selectMarker(Long uid)throws MarkerException{
		List marlist = markerMapper.selectMarker(uid);
		return marlist;
	}
	
	public Collect selectByNid(Long nid) throws MarkerException{
		Collect collect = markerMapper.selectByNid(nid);
		return collect;
	}
}
