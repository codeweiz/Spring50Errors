package cn.microboat.Spring50Errors.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhouwei
 */
@Getter
@Setter
@ToString
@Component
public class Student {

    private int id;

    private String name;

    /**
     * 收集式
     * 注解 @Order(number)，number 的值越小优先级越高
     */
    @Order(2)
    @Bean
    public Student student2() {
        return createStudent(2, "fang");
    }

    @Order(1)
    @Bean
    public Student student1() {
        return createStudent(1, "xie");
    }

    /**
     * 直接装配式：如果收集式和直接装配式同时存在，直接装配式会失效
     */
    @Bean
    public List<Student> students() {
        Student student1 = createStudent(1, "xie");
        Student student2 = createStudent(2, "fang");
        Student student3 = createStudent(3, "liu");
        Student student4 = createStudent(4, "fu");
        return Arrays.asList(student1, student2, student3, student4);
    }

    private Student createStudent(int id, String name) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        return student;
    }
}
