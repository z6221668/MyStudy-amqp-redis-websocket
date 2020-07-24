package com.example.studyVue.web.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TestDao {

    String getName();

    @Insert("insert test(name) values(#{name})")
    void insert(@Param("name") String name);
}
