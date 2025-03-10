package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.JieshourenwuEntity;
import com.cl.entity.view.JieshourenwuView;

import com.cl.service.JieshourenwuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 接受任务
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-02 11:11:45
 */
@RestController
@RequestMapping("/jieshourenwu")
public class JieshourenwuController {
    @Autowired
    private JieshourenwuService jieshourenwuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JieshourenwuEntity jieshourenwu,
		HttpServletRequest request){
        EntityWrapper<JieshourenwuEntity> ew = new EntityWrapper<JieshourenwuEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.or();
            ew.eq("jiedanrenzhanghao", (String)request.getSession().getAttribute("username"));
        }
		PageUtils page = jieshourenwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jieshourenwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JieshourenwuEntity jieshourenwu, 
		HttpServletRequest request){
        EntityWrapper<JieshourenwuEntity> ew = new EntityWrapper<JieshourenwuEntity>();

		PageUtils page = jieshourenwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jieshourenwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JieshourenwuEntity jieshourenwu){
       	EntityWrapper<JieshourenwuEntity> ew = new EntityWrapper<JieshourenwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jieshourenwu, "jieshourenwu")); 
        return R.ok().put("data", jieshourenwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JieshourenwuEntity jieshourenwu){
        EntityWrapper< JieshourenwuEntity> ew = new EntityWrapper< JieshourenwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jieshourenwu, "jieshourenwu")); 
		JieshourenwuView jieshourenwuView =  jieshourenwuService.selectView(ew);
		return R.ok("查询接受任务成功").put("data", jieshourenwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JieshourenwuEntity jieshourenwu = jieshourenwuService.selectById(id);
		jieshourenwu = jieshourenwuService.selectView(new EntityWrapper<JieshourenwuEntity>().eq("id", id));
        return R.ok().put("data", jieshourenwu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JieshourenwuEntity jieshourenwu = jieshourenwuService.selectById(id);
		jieshourenwu = jieshourenwuService.selectView(new EntityWrapper<JieshourenwuEntity>().eq("id", id));
        return R.ok().put("data", jieshourenwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JieshourenwuEntity jieshourenwu, HttpServletRequest request){
    	jieshourenwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jieshourenwu);
        jieshourenwuService.insert(jieshourenwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JieshourenwuEntity jieshourenwu, HttpServletRequest request){
    	jieshourenwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jieshourenwu);
        jieshourenwuService.insert(jieshourenwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JieshourenwuEntity jieshourenwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jieshourenwu);
        jieshourenwuService.updateById(jieshourenwu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jieshourenwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
