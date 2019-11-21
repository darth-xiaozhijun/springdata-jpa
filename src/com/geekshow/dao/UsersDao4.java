package com.geekshow.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.geekshow.pojo.Users;

/**
 * PagingAndSortingRepository接口讲解
 * @author Administrator
 *
 */
public interface UsersDao4 extends PagingAndSortingRepository<Users, Integer>{

}
