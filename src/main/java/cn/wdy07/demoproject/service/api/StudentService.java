package cn.wdy07.demoproject.service.api;

import cn.wdy07.demoproject.entity.Student;

/**
 * @author wdy
 * @create 2020-03-06 17:04
 */
public interface StudentService {

    int deleteByPrimaryKey(Integer stuId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
