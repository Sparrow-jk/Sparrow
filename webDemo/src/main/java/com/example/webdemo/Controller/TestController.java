package com.example.webdemo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.webdemo.param.TestParam;
import com.example.webdemo.vo.TestVo;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chansiwan
 * @since 2021-10-11 10:25
 */
@Controller("/")
public class TestController {


    @GetMapping("/test_web")
    public TestVo testWeb(@RequestBody TestParam testParam) {
        System.out.println(testParam.getTest1());
        System.out.println(testParam.getTest2());
        System.out.println(testParam.getTest3());
        TestVo vo = new TestVo();
        BeanUtils.copyProperties(testParam,vo);
        return vo;
    }

    @GetMapping("test")
    public String index(Model model) {
        TestVo vo = new TestVo();
        vo.setTest1(123456L);
        vo.setTest2(654321L);
        vo.setTest3("test_thymeleaf");
        model.addAttribute("vo", vo);
        return "test";
    }
}
