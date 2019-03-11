package com.example.authserver.userdteails;

import com.example.common.domain.RoleDO;
import com.example.common.domain.UserDO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:ZengXiao
 * @Description:
 * @Date: Create in 17:03 2019/3/7
 * @Modified By:
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // todo 测试暂时写死,后面从数据库查询
        UserDO userDO = new UserDO();
        userDO.setName("曾孝");
        userDO.setPassword("$2a$10$mX0IPzjwxv7vHfykkFncCuKLV7RpcG3zDLDWiEL4it1kbAUVuynxa");
        // 这密码是从数据库中取出的,封装到UserDetail后,
        // security会自动帮我们进行匹配
        userDO.setUsername("zengxiao");
        userDO.setStatus(1);
        List<RoleDO> roleDO =new ArrayList<>();
        return new UserDetail(userDO,roleDO);
    }
}
