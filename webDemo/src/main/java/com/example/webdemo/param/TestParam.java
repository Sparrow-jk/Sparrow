package com.example.webdemo.param;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author chansiwan
 * @since 2021-10-11 10:27
 */
@Data
public class TestParam {
    @JSONField(serializeUsing = ToStringSerializer.class)
    //@JsonSerialize(using = ToStringSerializer.class)
    private Long test1;
    private Long test2;
    private String test3;
}
