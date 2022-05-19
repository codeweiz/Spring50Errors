package cn.microboat.Spring50Errors.pojo;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Friend {

    /**
     * 注解 @Size 只能限制字符串在非空的情况下 最小 或 最大 为多少
     * 注解 @NotEmpty、@NotNull 可以限制非空
     */
    @NotEmpty
    @NotNull
    @Size(min = 1, max = 10)
    private String name;

    private short age;

    /**
     * 嵌套的属性，如果需要加校验，
     * 需要在 引用的地方加上 @Valid 注解修饰 Filed
     * 在属性本身加上 @Size(max = 11) 等相关校验限制注解
     */
    @Valid
    private Phone phone;

}

@Data
class Phone {

    @Size(max = 11)
    private String phone;
}