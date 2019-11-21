package com.geekshow.test;

import com.geekshow.dao.UsersDao3;
import com.geekshow.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * CrudRepository接口测试
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CrudRepositoryTest {

    @Autowired
    private UsersDao3 usersDao;

    /**
     * 添加单条数据
     */
    @Test
    public void test1(){
        Users user = new Users();
        user.setUserage(21);
        user.setUsername("赵小丽");
        this.usersDao.save(user);
    }

    /**
     * 批量添加数据
     */
    @Test
    public void test2(){
        Users user = new Users();
        user.setUserage(21);
        user.setUsername("赵小丽");

        Users user1 = new Users();
        user1.setUserage(25);
        user1.setUsername("王小虎");

        List<Users> list= new ArrayList<>();
        list.add(user);
        list.add(user1);

        this.usersDao.save(list);

    }

    /**
     * 根据ID查询单条数据
     */
    @Test
    public void test3(){
        Users users = this.usersDao.findOne(1);
        System.out.println(users);
    }

    /**
     * 查询全部数据
     */
    @Test
    public void test4(){
        List<Users> list = (List<Users>)this.usersDao.findAll();
        for (Users users : list) {
            System.out.println(users);
        }
    }

    /**
     * 删除数据
     */
    @Test
    public void test5(){
        this.usersDao.delete(5);
    }

    /**
     * 更新数据 方式一
     */
    @Test
    public void test6(){
        Users user = this.usersDao.findOne(1);
        user.setUsername("王小红");
        this.usersDao.save(user);
    }

    /**
     * 更新数据 方式二
     */
    @Test
    @Transactional
    @Rollback(false)
    public void test7(){
        Users user = this.usersDao.findOne(1);//持久化状态的
        user.setUsername("王小小");
    }
}
