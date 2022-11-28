package org.nefure.goodshops.controller;

import org.nefure.goodshops.dto.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nefure
 * @since 2022/11/23 22:49
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping("login")
    public Response login(){
        return Response.fail("功能未完成..");
    }

}
