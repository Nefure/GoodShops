package org.nefure.goodshops.service.impl;

import cn.hutool.core.util.RandomUtil;
import org.nefure.goodshops.constant.RedisConstant;
import org.nefure.goodshops.dto.LoginFormDTO;
import org.nefure.goodshops.dto.Response;
import org.nefure.goodshops.entity.User;
import org.nefure.goodshops.service.UserService;
import org.nefure.goodshops.util.EmailUtils;
import org.nefure.goodshops.util.RegexUtils;
import org.nefure.goodshops.util.StringUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author nefure
 * @since 2022/11/24 20:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate redisTemplate;

    @Override
    public Response sendEmailCheckCode(String email) {
        if (!RegexUtils.isEmailInvalid(email)){
            return Response.fail("邮箱格式错误！");
        }

        String code = RandomUtil.randomNumbers(6);
        EmailUtils.sendMail(email,"您好，您的验证码："+ code +" ，5分钟内有效，如果不是您本人，请忽略此邮件。","【探好货】邮箱验证");

        redisTemplate.opsForValue().set(RedisConstant.LOGIN_CODE_KEY + email, code, RedisConstant.LOGIN_CODE_TTL, TimeUnit.MINUTES);

        return Response.ok();
    }

    @Override
    public Response doLogin(LoginFormDTO loginForm) {
        String email = loginForm.getEmail();
        if (!RegexUtils.isEmailInvalid(email)){
            return Response.fail("邮箱格式错误！");
        }

        String tmp;
        if (!StringUtil.isBlank(tmp = loginForm.getCode())){
            //验证码登录
            String code = redisTemplate.opsForValue().get(RedisConstant.LOGIN_CODE_KEY + email);
            if (!tmp.equals(code)){
                return Response.fail("验证码错误！");
            }

            User user = getUserByEmail(email);
            if (user == null){
                user = signUpWithEmail(email);

            }
        }else {
            //账号密码登录

        }
        return null;
    }

    private User signUpWithEmail(String email) {
        User user = new User().setEmail(email);
        save(user);
        user = getUserByEmail(email);
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public void save(User user) {

    }
}
