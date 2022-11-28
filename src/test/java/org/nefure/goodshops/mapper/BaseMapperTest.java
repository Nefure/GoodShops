package org.nefure.goodshops.mapper;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.nefure.goodshops.entity.User;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author nefure
 * @since 2022/11/26 17:42
 */
@SpringBootTest
@MapperScan("org.nefure.goodshops.mapper")
public class BaseMapperTest {

    @Resource
    UserMapper userMapper;

    @Test
    void testSelectAndUpdate(){
        User user = userMapper.selectById("1012");
        System.out.println(user);
        user.setNickName("test");
        userMapper.updateById(user);
        System.out.println(userMapper.selectById(user.getId()));
    }

    @Test
    void testInsertAll(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User().setId(1011L).setNickName("test").setEmail("001"));
        users.add(new User().setId(1012L).setNickName("test").setEmail("002"));
        users.add(new User().setId(1013L).setNickName("test").setEmail("003"));
        users.add(new User().setId(1014L).setNickName("test").setEmail("004"));
        users.add(new User().setId(1015L).setNickName("test").setEmail("005"));
        userMapper.insertAll(users);
    }

    @Test
    void testDel(){
        for(int i = 1013; i < 1016; i++){
            User user = userMapper.selectById(i);
            System.out.println(user);
            userMapper.delete(user.getId());
            System.out.println(userMapper.selectById(user.getId()));
        }
    }

}
