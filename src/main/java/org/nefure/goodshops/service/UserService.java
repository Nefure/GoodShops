package org.nefure.goodshops.service;

import org.nefure.goodshops.dto.LoginFormDTO;
import org.nefure.goodshops.dto.Response;
import org.nefure.goodshops.entity.User;

/**
 * @author nefure
 * @since 2022/11/24 20:14
 */
public interface UserService {

    /**
     * 向邮箱发送验证码
     * @param email 目标邮箱
     * @return 返回给请求方
     */
    Response sendEmailCheckCode(String email);

    /**
     * 登录逻辑
     * @param loginForm 登录表单数据
     * @return 返回给请求方
     */
    Response doLogin(LoginFormDTO loginForm);

    /**
     * 根据email获取用户
     * @param email 邮箱
     * @return 符合条件的用户
     */
    User getUserByEmail(String email);

    /**
     * 添加/更新用户数据
     * @param user 用户信息
     */
    void save(User user);
}
