package cn.yu.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Yu
 * @version 1.0
 * @date 2019/1/27 13:44
 **/
//相当于把该类作为spring的xml配置文件中的<beans>,作用为：配置spring容器(应用上下文)
@Configuration
//启动swagger注解
@EnableSwagger2
@EnableWebMvc
@ComponentScan("cn.yu.shop.controller")
public class SwaggerConfig {

    @Bean
    public Docket buildDocket(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select().apis(RequestHandlerSelectors.basePackage("cn.yu.shop.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("商城项目的api接口")
                .termsOfServiceUrl("http://blog.csdn.net/u014231523网址链接")
                .description("商城的所有controller接口")
                .contact(new Contact("yu", "http://blog.csdn.net/u014231523", "455766338@qq.com"))
                .build();

    }
}
