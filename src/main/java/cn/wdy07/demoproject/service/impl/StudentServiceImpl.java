package cn.wdy07.demoproject.service.impl;

import cn.wdy07.demoproject.dao.StudentMapper;
import cn.wdy07.demoproject.entity.Student;
import cn.wdy07.demoproject.service.api.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wdy
 * @create 2020-03-06 17:04
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int deleteByPrimaryKey(Integer stuId) {
        return studentMapper.deleteByPrimaryKey(stuId);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer stuId) {
        return studentMapper.selectByPrimaryKey(stuId);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }
}
