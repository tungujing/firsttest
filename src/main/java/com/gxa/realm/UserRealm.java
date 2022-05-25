package com.gxa.realm;

import com.gxa.entity.User;
import com.gxa.mapper.PermMapper;
import com.gxa.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermMapper permMapper;
    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("********************doGetAuthorizationInfo*******************************");

        User principal = (User) principalCollection.getPrimaryPrincipal();
        System.out.println(principal);
        Set<String> perms = this.permMapper.queryPerms(principal.getName());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(perms);


        return simpleAuthorizationInfo;
    }
    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("===========doGetAuthenticationInfo==========================");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();
        System.out.println("=========username=====" + username);

        User byname = userMapper.getByname(username);

        System.out.println(byname+"==================================================");

        ByteSource salt = ByteSource.Util.bytes(byname.getSalt());

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(byname, byname.getPwd(), salt,getName());


        return simpleAuthenticationInfo;
    }


    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "admin";//明文 21232f297a57a5a743894a0e4a801fc3



//		Object result = new SimpleHash(hashAlgorithmName,credentials);
//		System.out.println(result);


//		Object result = new SimpleHash(hashAlgorithmName,credentials,null,1024);
//		System.out.println(result);

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        Object salt = ByteSource.Util.bytes(uuid.toString());;
        Object result = new SimpleHash(hashAlgorithmName, credentials,salt,1024);
        System.out.println(result);
    }
}
