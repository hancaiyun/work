package com.nicehancy.configuration;

import com.nicehancy.work.service.security.CustomUserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN;


/**
 * <p>
 *     安全控制配置
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/16 9:34
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    //注册UserDetailsService的bean
    @Bean
    UserDetailsService customUserService(){
        return new CustomUserServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //user Details Service验证
        auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * 重写权限控制
     * @param http                      http
     * @throws Exception                异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //解决iframe框架不允许内嵌问题
        http.headers().frameOptions().disable();

        //http.headers().frameOptions().sameOrigin();

        http.authorizeRequests()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                //.antMatchers("/admin/**").hasRole("ROLE_ADMIN") //将权限分配给角色
                .logout().permitAll(); //注销行为任意访问
    }
}