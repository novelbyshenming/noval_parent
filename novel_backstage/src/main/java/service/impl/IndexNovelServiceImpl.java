package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.IndexNovel;
import mapper.IndexNovelMapper;
import service.IndexNovelService;

/**
 * @author LX
 * @date 2019/5/12 - 14:18
 */
@Service  
@Transactional  
// 此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class IndexNovelServiceImpl implements IndexNovelService {

	
	@Resource  
	private IndexNovelMapper mapper;
	 
	/**
	 * 查询全部数据
	 */
	public List<IndexNovel> findAll() {
		List<IndexNovel> findAllList = mapper.findAll(); 
		return findAllList;
	}
	 
	/**
	 * 添加
	 */
	public void insert(IndexNovel indexnovel) {
		mapper.insert(indexnovel);
	}

	/**
	 * 根据id修改对应数据
	 * @return 
	 */
	public boolean update(IndexNovel indexnovel) {
		return mapper.update(indexnovel);	
	}

	
	/**
	 * 根据id查询
	 */
	public IndexNovel findById(int id) {
		IndexNovel indexnovel = mapper.findById(id);
		return indexnovel;
	}
	/**
	 * 根据ID删除
	 * @return 
	 */
	public boolean delete(int id) {
		 return mapper.delete(id);
	}


	
	
}
