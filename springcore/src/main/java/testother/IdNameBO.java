package testother;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Desc: 通用key、value的BO
 * <p>
 * Copyright (c) 2019 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 *
 * @author hugua@myweimai.com
 * @since 2020-03-03 17:17
 */
public class IdNameBO {
    private String id;      // key值
    private String name;    // 名称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
