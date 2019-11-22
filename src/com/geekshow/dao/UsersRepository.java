package com.geekshow.dao;

import com.geekshow.pojo.Users;

public interface UsersRepository {

	public Users findUserByUserid(Integer userid);
}
