package com.example.authserver.userdteails;

import com.example.common.domain.RoleDO;
import com.example.common.domain.UserDO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

/**
 * @Author:ZengXiao
 * @Description:
 * @Date: Create in 17:03 2019/3/7
 * @Modified By:
 */
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // todo 测试暂时写死,后面从数据库查询
        UserDO userDO = new UserDO();
        userDO.setName("曾孝");
        userDO.setPassword("123456");
        // 这密码是从数据库中取出的,封装到UserDetail后,
        // security会自动帮我们进行匹配
        userDO.setUsername("zengxiao");
        return new UserDetail(userDO, Arrays.asList(new RoleDO()));
    }
}
