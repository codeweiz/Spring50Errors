package cn.microboat.Spring50Errors.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author zhouwei
 */
public interface DataService {
    void deleteStudent(int id);
}
