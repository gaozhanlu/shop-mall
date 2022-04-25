package com.gzl.jwt.controller;


//import com.gzl.base.common.model.user.UseBaseRequest;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.gzl.base.common.model.oauth.UserDetails;
import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;
import com.gzl.base.common.result.ViewResult;
import com.gzl.base.common.util.EntityCopyUtil;
import com.gzl.jwt.config.UserDetailsServiceImpl;
import com.gzl.jwt.service.UseBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-03-02
 */
@RestController
@Api(tags = "use-base",description ="用户基础信息接口")
@RequestMapping("/use-base")
public class UseBaseController {


    @Resource
    private UseBaseService useBaseService;

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @ApiOperation(value = "查询用户信息")
    @RequestMapping(value = "/selectUseInfo", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult selectUseInfo(@RequestBody UseBaseRequest useBaseRequest) {
        List<UseBaseResponse> useBaseResponse=useBaseService.selectUseInfo(useBaseRequest);
        return ViewResult.success(useBaseResponse);
    }
    @ApiOperation(value = "添加用户信息")
    @RequestMapping(value = "/insertUseInfo", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult insertUseInfo(@RequestBody UseBaseRequest useBaseRequest) {
        useBaseService.insertUseInfo(useBaseRequest);
        return ViewResult.success("");
    }

    @Value("${security.oauth2.client.access-token-uri}")
    private String accessTokenUri;

    @Value("${security.oauth2.client.client-id}")
    private String clientId;

    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;


    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult login(@RequestBody UseBaseRequest useBaseRequest, @RequestHeader HttpHeaders httpHeaders) throws UnsupportedEncodingException {
//        UserDetails userDetails= EntityCopyUtil.toObject(useBaseRequest,UserDetails.class);
//        useBaseService.login(userDetails);
        userDetailsService.loadUserByUsername(useBaseRequest.getAccountName());
        RestTemplate restTemplate=new RestTemplate();
        // 构造 post的body内容（要post的内容，按需定义）
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.set("grant_type", "password");
        String username = useBaseRequest.getAccountName();
        paramsMap.set("username", username);
        String password = useBaseRequest.getPassWord();
        paramsMap.set("client_id", clientId);
        paramsMap.set("client_secret", clientSecret);
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            paramsMap.set("password", new String(decoder.decodeBuffer(password)));
        } catch (IOException e) {
            return ViewResult.failed("密码错误");

        }
        // 使用客户端的请求头,发起请求
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // 强制移除 原来的请求头,防止token失效
        httpHeaders.remove(HttpHeaders.AUTHORIZATION);
        //构造请求实体和头
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(paramsMap, httpHeaders);
        JSONObject authInfo = null;

        try {
            authInfo = restTemplate.postForObject(accessTokenUri, request, JSONObject.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
                byte[] bs = e.getResponseBodyAsByteArray();
                String msg = new String(bs, "utf-8");
                return ViewResult.failed(msg);
            } else {
                return ViewResult.failed("登录失败");
            }
        }
        JSONObject jsonObject = new JSONObject(authInfo);
        String jwt = jsonObject.getStr("access_token");
        Map<String, String> jwtMap = new HashMap<>();
        jwtMap.put("jwt", jwt);
        return ViewResult.success("");
    }

}

