package cn.microboat.Spring50Errors.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author zhouwei
 */
@Repository
@Slf4j
public class OracleDataServiceImpl implements DataService {
    @Override
    public void deleteStudent(int id) {
        log.info("delete student info maintained by oracle");
    }
}