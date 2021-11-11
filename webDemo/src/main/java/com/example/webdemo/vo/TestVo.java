package com.example.webdemo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author chansiwan
 * @since 2021-10-11 10:55
 */
@Data
public class TestVo {

    //@JSONField(serializeUsing = ToStringSerializer.class)
    //@JsonSerialize(using = ToStringSerializer.class)
    private Long test1;
    private Long test2;
    private String test3;
}
