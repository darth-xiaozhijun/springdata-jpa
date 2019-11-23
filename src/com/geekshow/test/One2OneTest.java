package com.geekshow.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geekshow.dao.PeopleDao;
import com.geekshow.pojo.Card;
import com.geekshow.pojo.People;

/**
 * JpaRepository接口测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class One2OneTest {

	@Autowired
	private PeopleDao peopleDao;
	
	/**
	 * 添加用户同时添加角色
	 */
	@Test
	public void test1(){
		//创建身份证
		Card card = new Card();
		card.setCardno("362422199509156666");
		card.setCardaddr("江西吉安");
		
		//创建用户
		People people = new People();
		people.setPeoplename("欧阳修");
		people.setPeopleage(24);
		
		//建立关系
		people.setCard(card);
		card.setPeople(people);
		
		//保存数据
		this.peopleDao.save(people);
	}
	
	/**
	 * 根据用户ID查询用户，同时查询用户角色
	 */
	@Test
	public void test2(){
	}
}
