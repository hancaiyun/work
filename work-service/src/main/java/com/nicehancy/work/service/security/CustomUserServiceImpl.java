package com.nicehancy.work.service.security;

import com.nicehancy.work.biz.user.UserInfoBiz;
import com.nicehancy.work.manager.model.UserInfoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     将用户权限交给 springsecurity 进行管控
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/16 9:44
 **/
@Service
public class CustomUserServiceImpl implements UserDetailsService {

    /**
     * 用户管理
     */
    @Autowired
    private UserInfoBiz userInfoBiz;

    /**
     * 重写loadUserByUsername 方法获得 userdetails 类型用户
     * @param username                      用户名
     * @return                              userDetails
     * @throws UsernameNotFoundException    用户未找到
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfoBO user = userInfoBiz.queryUserInfo(username);
        if(user == null){
            throw new UsernameNotFoundException("user is not exist");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities
        //authorities.add(new SimpleGrantedAuthority(user.getAuthNo()));
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), authorities);
    }
}