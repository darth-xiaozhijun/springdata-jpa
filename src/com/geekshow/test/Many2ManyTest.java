package com.geekshow.test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geekshow.dao.PartsDao;
import com.geekshow.pojo.Menus;
import com.geekshow.pojo.Parts;

/**
 * 多对多关联关系测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Many2ManyTest {
	
	
	@Autowired
	private PartsDao partsDao;
	
	/**
	 * 添加角色同时添加菜单
	 */
	@Test
	public void test1(){
		//创建角色对象
		Parts parts = new Parts();
		parts.setPartname("超级管理员");
		
		//创建菜单对象    极客萧管理平台 --->用户管理
		Menus menus = new Menus();
		menus.setMenusname("极客萧管理平台");
		menus.setFatherid(-1);
		menus.setMenusurl(null);
		
		//用户管理菜单
		Menus menus1 = new Menus();
		menus1.setMenusname("用户管理");
		menus1.setFatherid(1);
		menus1.setMenusurl(null);
		
		
		//建立关系
		parts.getMenus().add(menus);
		parts.getMenus().add(menus1);
		
		menus.getParts().add(parts);
		menus1.getParts().add(parts);
		
		//保存数据
		this.partsDao.save(parts);
	}
	
	/**
	 * 查询Roles
	 */
	@Test
	public void test2(){
		Parts parts = partsDao.findOne(1);
		System.out.println("角色信息："+parts);
		Set<Menus> menus = parts.getMenus();
		for (Menus menus2 : menus) {
			System.out.println("菜单信息："+menus2);
		}
	}

}
