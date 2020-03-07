package cn.wdy07.demoproject.interceptor;

import cn.wdy07.demoproject.annotation.PassToken;
import cn.wdy07.demoproject.annotation.UserLoginToken;
import cn.wdy07.demoproject.entity.Student;
import cn.wdy07.demoproject.exceptionhandler.CommonEnum;
import cn.wdy07.demoproject.exceptionhandler.CustomException;
import cn.wdy07.demoproject.service.api.StudentService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author wdy
 * @create 2020-03-07 0:42
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    StudentService studentService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new CustomException("无token，请重新登录!");
                }
                // 获取 token 中的 student id
                String stuId;
                try {
                    stuId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new CustomException(CommonEnum.BODY_NOT_MATCH);
                }
                Student student = studentService.selectByPrimaryKey(Integer.parseInt(stuId));
                if (student == null) {
                    throw new CustomException(CommonEnum.NOT_FOUND);
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(student.getPasswd())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new CustomException(CommonEnum.SIGNATURE_NOT_MATCH);
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}