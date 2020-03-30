package com.wjl.springcloud.dao;

import com.wjl.springcloud.springcloud.pojo.Dept;

import java.util.List;

public interface DeptDao {
    public boolean addDept(Dept dept);
    public Dept queryById(long id);
    public List<Dept> queryAll();
}
