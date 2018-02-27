package com.shi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 客户管理
 *
 * @author AFinalStone
 */
@Controller
public class TestController {

    //测试
    @RequestMapping(value = "/test.action")
    String customer() {
        return "success";
    }

}
