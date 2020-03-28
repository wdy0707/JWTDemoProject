package cn.wdy07.demoproject.listener;

import cn.wdy07.demoproject.entity.Student;
import org.springframework.context.ApplicationEvent;

/**
 * @author wdy
 * @create 2020-03-12 18:19
 */
public class MyEvent extends ApplicationEvent {

    private Student student;

    public MyEvent(Object source,Student student){
        super(source);
        this.student=student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
