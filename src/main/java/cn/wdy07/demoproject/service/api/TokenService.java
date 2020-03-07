package cn.wdy07.demoproject.service.api;

import cn.wdy07.demoproject.entity.Student;

/**
 * @author wdy
 * @create 2020-03-07 1:15
 */
public interface TokenService {
    String getToken(Student student);
}
