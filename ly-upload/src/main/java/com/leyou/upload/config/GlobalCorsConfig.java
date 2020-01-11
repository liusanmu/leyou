package com.leyou.upload.config;

/**
 * @author: ls
 * @description: 解决跨域
 * @create: 2020-01-08 23:29
 */
/*
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
    */
/*    //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //1.1允许的域，否则ccookie就无法使用了
        config.addAllowedOrigin("http://manage.leyou.com");
        //1.2 是否发送Cookie信息
        config.setAllowCredentials(false);
        //1.3允许的请求方式
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("POST");
        config.addAllowedHeader("*");
        //2. 添加映射路劲，拦截一切请求
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", config);
        //3.返回
        return new CorsFilter(configurationSource);*//*

        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //1) 允许的域,不要写*，否则cookie就无法使用了
        config.addAllowedOrigin("http://manage.leyou.com");
        //2) 是否发送Cookie信息
        config.setAllowCredentials(false);
        //3) 允许的请求方式
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("POST");
        config.addAllowedHeader("*");

        //2.添加映射路径，我们拦截一切请求
        // 5)有效时长
        config.setMaxAge(3600L);

        //2.添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);


        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}
*/
