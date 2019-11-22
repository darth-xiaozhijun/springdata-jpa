package com.geekshow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.geekshow.pojo.Users;

/**
 * JpaSpecificationExecutor接口讲解
 * 注意：JpaSpecificationExecutor<Users>:不能单独使用，需要配合着jpa中的其他接口一起使用
 * 用户自定义Repository接口讲解
 * @author Administrator
 *
 */
public interface UsersDao5 extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users>,UsersRepository {

}
