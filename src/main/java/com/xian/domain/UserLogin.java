package com.xian.domain;

import lombok.Data;

/**
 * @author Xian
 */
@Data
public class UserLogin {
    private Integer id;
    private String username;
    private Integer power;
    private Integer state;
}
