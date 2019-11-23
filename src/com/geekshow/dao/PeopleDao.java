package com.geekshow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.geekshow.pojo.People;

/**
 * 一对一关联关系操作
 * @author Administrator
 *
 */
public interface PeopleDao extends JpaRepository<People, Integer>,JpaSpecificationExecutor<People>{

}
