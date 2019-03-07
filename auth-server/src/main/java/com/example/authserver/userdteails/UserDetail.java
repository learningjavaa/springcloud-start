package com.example.authserver.userdteails;

import com.example.common.domain.RoleDO;
import com.example.common.domain.UserDO;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author:ZengXiao
 * @Description:
 * @Date: Create in 17:15 2019/3/7
 * @Modified By:
 */
@Getter
public class UserDetail implements UserDetails {

    private Long userId;
    private String username;
    private String password;
    private Integer status;
    List<RoleDO> roles;

    public UserDetail(UserDO userDO, List<RoleDO> roles) {
        this.userId = userDO.getId();
        this.username = userDO.getUsername();
        this.password = userDO.getPassword();
        this.status = userDO.getStatus();
        this.roles = roles;
    }

    /**
     * 返回分配给用户的角色列表
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleDO role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getKey()));
        }
        authorities.add(new SimpleGrantedAuthority("BASE_ROLE"));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * 账户是否未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否未锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return this.status == 0;
    }

    /**
     * 密码是否未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否激活
     */
    @Override
    public boolean isEnabled() {
        return this.status == 1;
    }
}
