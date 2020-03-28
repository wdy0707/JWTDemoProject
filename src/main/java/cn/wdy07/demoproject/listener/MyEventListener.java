package cn.wdy07.demoproject.listener;

import cn.wdy07.demoproject.entity.Student;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wdy
 * @create 2020-03-12 18:22
 */
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("事件已经被监听到-----》"+myEvent);
        //获得MyEvent时间中传入的Student信息
        Student student = myEvent.getStudent();
        System.out.println("获得学生信息~~~~~~student Passwd-->"+student.getPasswd());
    }
}
