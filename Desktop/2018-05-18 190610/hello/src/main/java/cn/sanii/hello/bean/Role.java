package cn.sanii.hello.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Auther: shouliang.wang
 * @Date: 2018/5/15 16:14
 * @Description:
 */
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue
    private int id;

    private String name;
}
