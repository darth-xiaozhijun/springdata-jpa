package com.geekshow.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
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

    //使用@Query注解查询JPQL
    @Query(value="from Users where username = ?")
    List<Users> queryUserByNameUseJPQL(String name);

    @Query("from Users where username like ?")
    List<Users> queryUserByLikeNameUseJPQL(String name);

    @Query("from Users where username = ? and userage >= ?")
    List<Users> queryUserByNameAndAgeUseJPQL(String name,Integer age);

    //使用@Query注解查询SQL
    //nativeQuery:默认的是false.表示不开启sql查询。是否对value中的语句做转义。
    @Query(value="select * from t_users where username = ?",nativeQuery=true)
    List<Users> queryUserByNameUseSQL(String name);

    @Query(value="select * from t_users where username like ?",nativeQuery=true)
    List<Users> queryUserByLikeNameUseSQL(String name);

    @Query(value="select * from t_users where username = ? and userage >= ?",nativeQuery=true)
    List<Users> queryUserByNameAndAgeUseSQL(String name,Integer age);
}
