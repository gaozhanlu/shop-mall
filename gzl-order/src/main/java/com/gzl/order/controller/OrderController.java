package com.gzl.order.controller;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@Slf4j
public class OrderController {

    @GetMapping(value = "/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1(){
        log.error("调用成功");
        return "访问资源1";
    }



}