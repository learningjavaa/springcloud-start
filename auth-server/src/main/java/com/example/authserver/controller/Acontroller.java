package com.example.authserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:ZengXiao
 * @Description:
 * @Date: Create in 22:32 2019/3/7
 * @Modified By:
 */
@RestController
public class Acontroller {

    @RequestMapping("test")
    public String test() {
        return "success";
    }

}
