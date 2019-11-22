package com.geekshow.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.geekshow.dao.UsersRepository;
import com.geekshow.pojo.Users;

public class UsersDaoImpl implements UsersRepository {

	@PersistenceContext(name="entityManagerFactory")
	private EntityManager em;
	
	@Override
	public Users findUserByUserid(Integer userid) {
		System.out.println("MyRepository......");
		return this.em.find(Users.class, userid);
	}

}
