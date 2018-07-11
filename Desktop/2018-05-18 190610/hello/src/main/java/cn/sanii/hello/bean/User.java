package cn.sanii.hello.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author shouliang.wang
 * @Description:
 */
@Entity
@Data
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * id
     * 自增
     * PS：@GeneratedValue注解的strategy属性提供四种值：

     –AUTO： 主键由程序控制，是默认选项，不设置即此项。

     –IDENTITY：主键由数据库自动生成，即采用数据库ID自增长的方式，Oracle不支持这种方式。

     –SEQUENCE：通过数据库的序列产生主键，通过@SequenceGenerator 注解指定序列名，mysql不支持这种方式。

     –TABLE：通过特定的数据库表产生主键，使用该策略可以使应用更易于数据库移植。

     注解	说明
     @Null	被注释的元素必须为 null
     @NotNull	被注释的元素必须不为 null
     @AssertTrue	被注释的元素必须为 true
     @AssertFalse	被注释的元素必须为 false
     @Min(value)	被注释的元素必须是一个数字，其值必须大于等于指定的最小值
     @Max(value)	被注释的元素必须是一个数字，其值必须小于等于指定的最大值
     @DecimalMin(value)	被注释的元素必须是一个数字，其值必须大于等于指定的最小值
     @DecimalMax(value)	被注释的元素必须是一个数字，其值必须小于等于指定的最大值
     @Size(max=, min=)	被注释的元素的大小必须在指定的范围内
     @Digits (integer, fraction)	被注释的元素必须是一个数字，其值必须在可接受的范围内
     @Past	被注释的元素必须是一个过去的日期
     @Future	被注释的元素必须是一个将来的日期
     @Pattern(regex=,flag=)	被注释的元素必须符合指定的正则表达式
     Hibernate Validator 附加的 constraint
     @NotBlank(message =)	验证字符串非null，且长度必须大于0
     @Email	被注释的元素必须是电子邮箱地址
     @Length(min=,max=)	被注释的字符串的大小必须在指定的范围内
     @NotEmpty	被注释的字符串的必须非空
     @Range(min=,max=,message=)	被注释的元素必须在合适的范围内

     */
    @Id
    @GeneratedValue
    private Integer id;

    private String uuid;

    @NotBlank(message = "名字不能为空")
    private String name;

    @NotBlank(message = "密码不能为空")
    private String pwd;


}
