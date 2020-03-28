package cn.wdy07.demoproject.service.impl;

import cn.wdy07.demoproject.dao.StudentMapper;
import cn.wdy07.demoproject.entity.Student;
import cn.wdy07.demoproject.listener.MyEvent;
import cn.wdy07.demoproject.service.api.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Student selectByPrimaryKey(Integer stuId) {

        Student student = studentMapper.selectByPrimaryKey(stuId);
        //发布自定义事件
        MyEvent myEvent = new MyEvent(this, student);
        applicationContext.publishEvent(myEvent);

        return student;
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
