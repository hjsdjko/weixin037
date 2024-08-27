package com.cl.dao;

import com.cl.entity.JieshourenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JieshourenwuView;


/**
 * 接受任务
 * 
 * @author 
 * @email 
 * @date 2024-04-02 11:11:45
 */
public interface JieshourenwuDao extends BaseMapper<JieshourenwuEntity> {
	
	List<JieshourenwuView> selectListView(@Param("ew") Wrapper<JieshourenwuEntity> wrapper);

	List<JieshourenwuView> selectListView(Pagination page,@Param("ew") Wrapper<JieshourenwuEntity> wrapper);
	
	JieshourenwuView selectView(@Param("ew") Wrapper<JieshourenwuEntity> wrapper);
	

}
