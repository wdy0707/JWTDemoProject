package cn.wdy07.demoproject.AOP_JWT;

import cn.wdy07.demoproject.annotation.PassToken;
import cn.wdy07.demoproject.annotation.UserLoginToken;
import cn.wdy07.demoproject.controller.StudentController;
import cn.wdy07.demoproject.entity.Student;
import cn.wdy07.demoproject.exceptionhandler.CommonEnum;
import cn.wdy07.demoproject.exceptionhandler.CustomException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author wdy
 * @create 2020-03-12 16:05
 */
@Aspect
@Component
public class AopImplJWT  {

    private static final Logger logger = LoggerFactory.getLogger(AopImplJWT.class);

    @Pointcut("execution(public * cn.wdy07.demoproject.controller.*.*(..))")
    public void pointcutMethods(){
    }

    //@Before("pointcutMethods()")
    public void doBefore(JoinPoint joinPoint)throws Exception{



        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            Student stu = (Student) arg;
            System.out.println("StudentPasswd:"+stu.getPasswd());
        }

        //在Spring中获取Request和Response
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();

        System.out.println("获取token信息----》"+request.getHeader("token"));

        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        for(Method method:methods){
            if(method.getName().equals(joinPoint.getSignature().getName())){
                System.out.println("找到了！！！----"+joinPoint.getSignature().getName());
                if(method.isAnnotationPresent(UserLoginToken.class)){
                    System.out.println("劳资终于弄好了！！！");
                }
            }
            System.out.println(method.getName()+"-------------methodName");
        }
        System.out.println(joinPoint.getTarget());
        System.out.println(joinPoint.getKind()+"======Kind");

        System.out.println(joinPoint.getSignature().toShortString()+"---toShortString");
        System.out.println(joinPoint.getSignature().getModifiers()+"---getModifiers");
        System.out.println(joinPoint.getSignature().getName()+"---getName");
        System.out.println(joinPoint.getSignature().getModifiers()+"---toShortString");
        System.out.println(joinPoint.getSignature()+"======Signature");

        System.out.println(((StudentController)joinPoint.getTarget())+"----");

    }

}
