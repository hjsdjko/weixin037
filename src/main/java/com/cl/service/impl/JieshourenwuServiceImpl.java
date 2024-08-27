package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JieshourenwuDao;
import com.cl.entity.JieshourenwuEntity;
import com.cl.service.JieshourenwuService;
import com.cl.entity.view.JieshourenwuView;

@Service("jieshourenwuService")
public class JieshourenwuServiceImpl extends ServiceImpl<JieshourenwuDao, JieshourenwuEntity> implements JieshourenwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JieshourenwuEntity> page = this.selectPage(
                new Query<JieshourenwuEntity>(params).getPage(),
                new EntityWrapper<JieshourenwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JieshourenwuEntity> wrapper) {
		  Page<JieshourenwuView> page =new Query<JieshourenwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JieshourenwuView> selectListView(Wrapper<JieshourenwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JieshourenwuView selectView(Wrapper<JieshourenwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
