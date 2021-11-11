package com.example.demoforsparrow;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chansiwan
 * @since 2021-05-26 15:08
 */
@Data
@NoArgsConstructor
public class TesBo {
    private Long ad;
    private Long bd;
    private String xd;
    private Byte vd;
    private Long cd;
    private Long dd;
    private String eds;
    private Long od;

}
