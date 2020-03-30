package com.wjl.springcloud.controller;

import com.wjl.springcloud.springcloud.pojo.Dept;
import com.wjl.springcloud.springcloud.service.DeptClienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
//    @Autowired
//    private RestTemplate restTemplate;
    //private static final String REST_URL_PREFIX="http://localhost:8001";
//    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";
    @Autowired
    private DeptClienService deptClienService;

//    @RequestMapping("/consumer/dept/add")
//    public boolean add(Dept dept){
//        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
//    }
//    @RequestMapping("/consumer/dept/get/{id}")
//    public Dept get(@PathVariable("id") long id){
//        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
//    }
//    @RequestMapping("/consumer/dept/list")
//    public List<Dept> list(){
//        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
//    }


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return this.deptClienService.addDept(dept);
    }
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id){
        return this.deptClienService.queryById(id);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return this.deptClienService.queryAll();
    }

}
