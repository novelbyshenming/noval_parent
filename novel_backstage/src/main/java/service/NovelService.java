package service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import bean.Novel;

/**
 * @author LX
 * @date 2019/5/12 - 14:18
 */
public interface NovelService {
	void insert(Novel novel);
	boolean update(Novel novel);
	List<Novel> findAll();
	Novel findById(int id);
	boolean delete(int id);
	List<Novel> findByName(@Param("novelName")String novelName);
	
	
}
