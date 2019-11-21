package com.geekshow.dao;

import com.geekshow.pojo.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository接口讲解
 */
public interface UsersDao3 extends CrudRepository<Users,Integer> {
}
