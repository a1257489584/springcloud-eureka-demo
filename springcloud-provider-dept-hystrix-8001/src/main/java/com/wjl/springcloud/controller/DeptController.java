package com.wjl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wjl.springcloud.service.DeptService;
import com.wjl.springcloud.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
//    @Autowired
//    DeptService deptService;
//    @Autowired
//    private DiscoveryClient client;
//    @PostMapping("/dept/add")
//    public boolean addDept(Dept dept){
//        return deptService.addDept(dept);
//    }
//    @GetMapping("/dept/get/{id}")
//    public Dept qeuryById(@PathVariable("id") long id){
//        return deptService.queryById(id);
//    }
//
//    @GetMapping("/dept/list")
//    public List<Dept> queryAll(){
//        return deptService.queryAll();
//    }
//
//    @GetMapping("/dept/discovery")
//    public Object Discovery(){
//        List<String> services = client.getServices();
//        System.out.println("discovery=>"+services);
//        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
//        for (ServiceInstance instance : instances) {
//            System.out.println(instance.getHost()+instance.getPort()+instance.getUri()+instance.getServiceId());
//        }
//        return this.client;
//    }
    @Autowired
    private DeptService deptService;
    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept==null){
            throw new RuntimeException("id=>"+id+"不存在该用户");

        }
        return dept;
    }
    public Dept hystrixGet(Long id){
        return new Dept().setDeptno(id)
                .setDname("id=>"+id+"没有对应的信息")
                .setDb_source("没有这个数据库");
    }
}
