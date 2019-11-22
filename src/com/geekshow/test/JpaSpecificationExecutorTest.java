package com.geekshow.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geekshow.dao.UsersDao5;
import com.geekshow.pojo.Users;

/**
 * JpaSpecificationExecutorTest
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpaSpecificationExecutorTest {

	@Autowired
	private UsersDao5 usersDao;
	
	/**
	 * 需求：根据用户姓名查询数据
	 */
	@Test
	public void test1(){
		Specification<Users> spec = new Specification<Users>() {

			/**
			 * @return Predicate:定义了查询条件
			 * @param Root<Users> root:根对象。封装了查询条件的对象
			 * @param CriteriaQuery<?> query:定义了一个基本的查询。一般不使用
			 * @param CriteriaBuilder cb:创建一个查询条件
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate pre = cb.equal(root.get("username"), "张三");
				return pre;
			}
		};
		List<Users> list = this.usersDao.findAll(spec);
		for (Users users : list) {
			System.out.println(users);
		}
	}

    /**
     * 多条件查询 方式一
     * 需求：使用用户姓名以及年龄查询数据
     */
    @Test
    public void test2(){
        Specification<Users> spec = new Specification<Users>() {

            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                list.add(cb.equal(root.get("username"),"王小小"));
                list.add(cb.equal(root.get("userage"),24));
                //此时条件之间是没有任何关系的。
                Predicate[] arr = new Predicate[list.size()];
                return cb.and(list.toArray(arr));
            }

        };
        List<Users> list = this.usersDao.findAll(spec);
        for (Users users : list) {
            System.out.println(users);
        }
    }
}
