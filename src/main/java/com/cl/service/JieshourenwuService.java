package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JieshourenwuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JieshourenwuView;


/**
 * 接受任务
 *
 * @author 
 * @email 
 * @date 2024-04-02 11:11:45
 */
public interface JieshourenwuService extends IService<JieshourenwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JieshourenwuView> selectListView(Wrapper<JieshourenwuEntity> wrapper);
   	
   	JieshourenwuView selectView(@Param("ew") Wrapper<JieshourenwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JieshourenwuEntity> wrapper);
   	

}

