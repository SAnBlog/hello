package cn.sanii.hello.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * @author sanii.cn
 * @Description: 表白实体类
 * @date 2018/5/19 14:56
 */
@Entity
@Data
public class Lover {

    @Id
    @GeneratedValue
    private int id;


    private String isOpen;

    @NotBlank(message = "请填写信息完整")
    private String url;

    @NotBlank(message = "请填写信息完整")
    private String yourName;
    @NotBlank(message = "请填写信息完整")
    private String taName;
    @NotBlank(message = "请填写信息完整")
    private String randomStr1;
    @NotBlank(message = "请填写信息完整")
    private String randomStr2;
    @NotBlank(message = "请填写信息完整")
    private String randomStr3;
    @NotBlank(message = "请填写信息完整")
    private String randomStr4;
    @NotBlank(message = "请填写信息完整")
    private String year;
    @NotBlank(message = "请填写信息完整")
    private String month;
    @NotBlank(message = "请填写信息完整")
    private String day;
    @NotBlank(message = "请填写信息完整")
    private String loveWords1;
    @NotBlank(message = "请填写信息完整")
    private String loveWords2;
    @NotBlank(message = "请填写信息完整")
    private String loveWords3;
    @NotBlank(message = "请填写信息完整")
    private String loveWords4;
}
