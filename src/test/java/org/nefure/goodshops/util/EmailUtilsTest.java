package org.nefure.goodshops.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author nefure
 * @since 2022/11/24 19:22
 */
@SpringBootTest
class EmailUtilsTest {

    @Test
    void sendTest() {
        EmailUtils.sendMail("3587211363@qq.com", """
                <a id='ppo' href='https://v3.bootcss.com/components/'>(´・ω・`) </a>你好，这是一封测试邮件，无需回复。
                """
                ,"测试邮件");
        System.out.println("发送成功");
    }
}