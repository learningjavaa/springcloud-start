package com.example.authserver.config;

import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.annotation.Resource;
import java.security.KeyPair;

/**
 * @Author:ZengXiao 自定义jwt
 * @Description:
 * @Date: Create in 22:15 2019/3/7
 * @Modified By:
 */
@Configuration
public class JwtTokenConfig {

    //读取密钥的配置
    @Bean("keyProp")
    public KeyProperties keyProperties(){
        return new KeyProperties();
    }

    @Resource(name = "keyProp")
    private KeyProperties keyProperties;

    /**
     * token生成处理：指定签名
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();

        // KeyPair keyPair = new KeyStoreKeyFactory
        //         (keyProperties.getKeyStore().getLocation(), keyProperties.getKeyStore().getSecret().toCharArray())
        //         .getKeyPair(keyProperties.getKeyStore().getAlias(),keyProperties.getKeyStore().getPassword().toCharArray());
        // accessTokenConverter.setKeyPair(keyPair);

        // accessTokenConverter.setSigningKey("internet_plus");
        return accessTokenConverter;
    }

}
