package com.gzl.base.common.packagemodel;

import lombok.Data;

@Data
public class PageRequest<T> {
    private Integer page;
    private Integer size;
    private T data;
}
