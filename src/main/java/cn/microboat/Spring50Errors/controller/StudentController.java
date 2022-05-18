package cn.microboat.Spring50Errors.controller;

import cn.microboat.Spring50Errors.pojo.Student;
import cn.microboat.Spring50Errors.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhouwei
 */
@RestController
@Slf4j
@Validated
public class StudentController {

//    @Qualifier("oracleDataServiceImpl")
//    @Autowired
//    DataService dataService;
//
//    @RequestMapping(path = "student/{id}", method = RequestMethod.DELETE)
//    public void deleteStudent(@PathVariable("id") int id) {
//        dataService.deleteStudent(id);
//    }


    // 如果一个类名是以两个大写字母开头的，
    // 则首字母不变，其他情况下默认首字母变成小写
    // SQLiteDataService 的Bean，其名称就是类名本身
    // OracleDataServiceImpl 的Bean，其名称就变成了首字母小写 oracleDataServiceImpl

    // 也可以通过 @Repository("") 指定 Bean 的名字，这样就不用纠结首字母到底大写还是小写了

    @Autowired
    DataService oracleDataServiceImpl;

    @RequestMapping(path = "student/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("id") int id) {
        oracleDataServiceImpl.deleteStudent(id);
    }


    /**
     * 内部类的 Bean name 又不一样，不是单纯的 类名或者小写类名
     * 是 外部类小写.内部类，例如：@Qualifier("studentController.InnerClassDataServiceImpl")
     * 这个写法虽然别扭，但还是符合命名规范的
     */
    @Repository
    @Slf4j
    public static class InnerClassDataServiceImpl implements DataService {

        @Override
        public void deleteStudent(int id) {
            log.info("delete student info maintained by inner");
        }
    }

    @Qualifier("studentController.InnerClassDataServiceImpl")
    @Autowired
    DataService innerClassDataServiceImpl;

    @RequestMapping(path = "student2/{id}", method = RequestMethod.DELETE)
    public void deleteStudent2(@PathVariable("id") int id) {
        innerClassDataServiceImpl.deleteStudent(id);
    }


    private List<Student> students;

    public StudentController(List<Student> students) {
        this.students = students;
    }

    @RequestMapping(value = "students", method = RequestMethod.GET)
    public String listStudent() {
        return students.toString();
    }

}
