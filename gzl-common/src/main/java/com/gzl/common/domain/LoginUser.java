package com.gzl.common.domain;



import com.alibaba.fastjson.annotation.JSONField;
import com.gzl.common.model.security.UserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements UserDetails {

    private UserDetail userDetail;

    private List<String> permissions;

    public LoginUser(UserDetail userDetail) {
        this.userDetail=userDetail;
    }

    public LoginUser(UserDetail userDetail, List<String> permissions) {
        this.userDetail=userDetail;
        this.permissions = permissions;
    }

    /**
     * Redis默认时不会把它进行序列，但是这样会出问题
     * 其实，我们不需要把这个成员变量序列号存储到Redis当中，我们只需要存储permissions即可。
     * 我们可以将permissions转换为authorities。
     * 通过 @JSONField(serialize = false) 注解，可以不让它序列号。
     */
    @JSONField(serialize = false)
    private List<SimpleGrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities != null) {
            return authorities;
        }
        // 把permissions中String类型的权限信息封装成SimpleGrantedAuthority对象
        authorities = permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return userDetail.getPassword();
    }

    @Override
    public String getUsername() {
        return userDetail.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
