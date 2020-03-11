package cn.wdy07.demoproject.controller;

import cn.wdy07.demoproject.annotation.UserLoginToken;
import cn.wdy07.demoproject.entity.Student;
import cn.wdy07.demoproject.exceptionhandler.CommonEnum;
import cn.wdy07.demoproject.exceptionhandler.CustomException;
import cn.wdy07.demoproject.result.CommonResult;
import cn.wdy07.demoproject.service.api.StudentService;
import cn.wdy07.demoproject.service.api.TokenService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wdy
 * @create 2020-03-06 16:45
 */
@RestController
@RequestMapping("/stu")
@Api(description = "学生登录管理")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/ok")
    public String ok(){
        return "ok";
    }

    @ApiOperation(value = "学生登录",notes = "对用户的登录信息进行判断，成功则返回token")
    @PostMapping("/login")
    public Object login(@RequestBody Student student){
        JSONObject jsonObject = new JSONObject();
        Student stu = studentService.selectByPrimaryKey(student.getStuId());
        if(stu == null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            //对密码进行校验
            if(!stu.getPasswd().equals(student.getPasswd())){
                jsonObject.put("message","登陆失败，密码错误！");
                return jsonObject;
            }else{
                //登录成功，设置token
                String token = tokenService.getToken(stu);
                jsonObject.put("token",token);
                jsonObject.put("student",stu);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("info")
    public String getInfo(){
        return "恭喜，成功通过验证！";
    }

    @GetMapping("/getStuById")
    public CommonResult getStuById(Student stu){
        if(stu == null || stu.getStuId() == null){
            throw new CustomException(CommonEnum.BODY_NOT_MATCH);
        }
        Student student = studentService.selectByPrimaryKey(stu.getStuId());
        return CommonResult.success(student);
    }
}
