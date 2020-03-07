package cn.wdy07.demoproject.service.impl;

import cn.wdy07.demoproject.entity.Student;
import cn.wdy07.demoproject.service.api.TokenService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

/**
 * @author wdy
 * @create 2020-03-07 1:16
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(Student student) {
        String token="";
        token= JWT.create().withAudience(student.getStuId()+"")
                .sign(Algorithm.HMAC256(student.getPasswd()));
        return token;
    }
}
