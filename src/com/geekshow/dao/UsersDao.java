package com.geekshow.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.geekshow.pojo.Users;

public interface UsersDao extends JpaRepository<Users, Integer> {
	
	
}
