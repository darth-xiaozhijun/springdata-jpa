package com.geekshow.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geekshow.dao.UsersDao2;
import com.geekshow.pojo.Users;

/**
 * Repository接口测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RepositoryTest {

	@Autowired
	private UsersDao2 usersDao;
	
	/**
	 * 需求：使用用户名作为查询条件
	 */
	@Test
	public void test1(){
		/**
		 * 判断相等的条件，有三种表示方式
		 * 1,什么都不写，默认的就是做相等判断
		 * 2,Is
		 * 3,Equal
		 */
		List<Users> list = this.usersDao.findByUsernameIs("张三");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * 需求：根据用户姓名做Like处理
	 * Like:条件关键字
	 */
	@Test
	public void test2(){
		List<Users> list = this.usersDao.findByUsernameLike("李%");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * 需求：查询名称为王五，并且他的年龄大于等于22岁
	 */
	@Test
	public void test3(){
		List<Users> list = this.usersDao.findByUsernameAndUserageGreaterThanEqual("张三", 20);
		for (Users users : list) {
			System.out.println(users);
		}
	}
}
