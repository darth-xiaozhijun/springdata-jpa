package com.geekshow.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.geekshow.pojo.Users;

/**
 * Repository接口讲解
 * @author Administrator
 *
 */
public interface UsersDao2 extends Repository<Users, Integer>{

	/**
	 * 根据username查询列表
	 * @param string
	 * @return
	 */
	List<Users> findByUsernameIs(String string);
	
	/**
	 * 根据username模糊查询
	 * @param string
	 * @return
	 */
	List<Users> findByUsernameLike(String string);
	
	/**
	 * 查询username和大于等于userage的列表
	 * @param name
	 * @param age
	 * @return
	 */
	List<Users> findByUsernameAndUserageGreaterThanEqual(String name,Integer age);

}
