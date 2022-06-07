package com.gzl.common.packagemodel;

import lombok.Data;

@Data
public class PageResult<T> {
    private Long num;
    private T data;

}
