package com.wjl.springcloud.springcloud.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *实体类必须加序列化
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    /**
     * 表ID
     */
    private long deptno;
    /**
     * 名字
     */
    private String dname;
    /**
     * 资源
     */
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
