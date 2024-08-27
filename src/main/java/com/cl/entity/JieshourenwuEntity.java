package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 接受任务
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-02 11:11:45
 */
@TableName("jieshourenwu")
public class JieshourenwuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JieshourenwuEntity() {
		
	}
	
	public JieshourenwuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 订单编号
	 */
					
	private String dingdanbianhao;
	
	/**
	 * 任务名称
	 */
					
	private String renwumingcheng;
	
	/**
	 * 取件地方
	 */
					
	private String qujiandifang;
	
	/**
	 * 送达地方
	 */
					
	private String songdadifang;
	
	/**
	 * 报酬
	 */
					
	private Double baochou;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 订单状态
	 */
					
	private String dingdanzhuangtai;
	
	/**
	 * 接受时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jieshoushijian;
	
	/**
	 * 接单人账号
	 */
					
	private String jiedanrenzhanghao;
	
	/**
	 * 接单人姓名
	 */
					
	private String jiedanrenxingming;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：订单编号
	 */
	public void setDingdanbianhao(String dingdanbianhao) {
		this.dingdanbianhao = dingdanbianhao;
	}
	/**
	 * 获取：订单编号
	 */
	public String getDingdanbianhao() {
		return dingdanbianhao;
	}
	/**
	 * 设置：任务名称
	 */
	public void setRenwumingcheng(String renwumingcheng) {
		this.renwumingcheng = renwumingcheng;
	}
	/**
	 * 获取：任务名称
	 */
	public String getRenwumingcheng() {
		return renwumingcheng;
	}
	/**
	 * 设置：取件地方
	 */
	public void setQujiandifang(String qujiandifang) {
		this.qujiandifang = qujiandifang;
	}
	/**
	 * 获取：取件地方
	 */
	public String getQujiandifang() {
		return qujiandifang;
	}
	/**
	 * 设置：送达地方
	 */
	public void setSongdadifang(String songdadifang) {
		this.songdadifang = songdadifang;
	}
	/**
	 * 获取：送达地方
	 */
	public String getSongdadifang() {
		return songdadifang;
	}
	/**
	 * 设置：报酬
	 */
	public void setBaochou(Double baochou) {
		this.baochou = baochou;
	}
	/**
	 * 获取：报酬
	 */
	public Double getBaochou() {
		return baochou;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：订单状态
	 */
	public void setDingdanzhuangtai(String dingdanzhuangtai) {
		this.dingdanzhuangtai = dingdanzhuangtai;
	}
	/**
	 * 获取：订单状态
	 */
	public String getDingdanzhuangtai() {
		return dingdanzhuangtai;
	}
	/**
	 * 设置：接受时间
	 */
	public void setJieshoushijian(Date jieshoushijian) {
		this.jieshoushijian = jieshoushijian;
	}
	/**
	 * 获取：接受时间
	 */
	public Date getJieshoushijian() {
		return jieshoushijian;
	}
	/**
	 * 设置：接单人账号
	 */
	public void setJiedanrenzhanghao(String jiedanrenzhanghao) {
		this.jiedanrenzhanghao = jiedanrenzhanghao;
	}
	/**
	 * 获取：接单人账号
	 */
	public String getJiedanrenzhanghao() {
		return jiedanrenzhanghao;
	}
	/**
	 * 设置：接单人姓名
	 */
	public void setJiedanrenxingming(String jiedanrenxingming) {
		this.jiedanrenxingming = jiedanrenxingming;
	}
	/**
	 * 获取：接单人姓名
	 */
	public String getJiedanrenxingming() {
		return jiedanrenxingming;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
