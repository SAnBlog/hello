package cn.sanii.hello.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Auther: shouliang.wang
 * @Date: 2018/5/15 16:17
 * @Description:
 */
@Entity
@Data
public class UserRole {

    @Id
    @GeneratedValue
    private int id;

    private int roleID;

    private int userID;
}
