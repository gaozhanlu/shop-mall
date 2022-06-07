package com.gzl.common.model.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class UseBaseResponse {
    private Integer id;

    private String accountId;

    private String accountName;

    private String passWord;

    private Integer roleId;

    private String roleName;
}
