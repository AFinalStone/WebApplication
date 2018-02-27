package com.shi.controller;

import com.shi.bean.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户管理
 *
 * @author AFinalStone
 */
@RestController
public class TestJsonController {

    //测试
    @RequestMapping(value = "/testJson/json.action", method = RequestMethod.GET)
    ResponseResult<String> customer() {
        ResponseResult<String> result = new ResponseResult<String>();
        result.setData("成功");
        result.setErrorCode(0);
        result.setSuccess(true);
        result.setMessage("恭喜您测试JSON数据成功");
        return result;
    }

}
