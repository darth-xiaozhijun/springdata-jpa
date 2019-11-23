package com.geekshow.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geekshow.dao.UsersDao5;
import com.geekshow.pojo.Roles;
import com.geekshow.pojo.Users;

/**
 * 一对多的关联关系测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class One2ManyTest {

	@Autowired
	private UsersDao5 usersDao;
	
	
	/**
	 * 添加用户同时添加角色
	 */
	@Test
	public void test1(){
		//创建角色
		Roles roles = new Roles();
		roles.setRolename("管理员");
		//创建用户
		Users users =new Users();
		users.setUserage(30);
		users.setUsername("小王");
		//建立关系
		roles.getUsers().add(users);
		users.setRoles(roles);
		//保存数据
		this.usersDao.save(users);
	}
	
	/**
	 * 根据用户ID查询用户信息，同时查询角色
	 */
	@Test
	public void test2(){
		Users users = this.usersDao.findOne(6);
		System.out.println("用户："+users);
		Roles roles = users.getRoles();
		System.out.println(roles);
	}
}
