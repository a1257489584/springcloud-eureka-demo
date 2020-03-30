package com.wjl.springcloud.springcloud.service;

import com.wjl.springcloud.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {

    @Override
    public DeptClienService create(Throwable throwable) {
        return new DeptClienService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id).setDname("这个>="+id+"没有对应的信息,服务降级中")
                        .setDb_source("no this databases");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
