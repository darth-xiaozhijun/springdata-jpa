package com.geekshow.test;

import com.geekshow.dao.UsersDao5;
import com.geekshow.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * UsersRepository接口测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UsersRepositoryTest {

    @Autowired
    private UsersDao5 usersDao;

    /**
     * 需求：根据用户ID查询数据
     */
    @Test
    public void test1(){
        Users users = this.usersDao.findUserByUserid(1);
        System.out.println(users);
    }
}
