package cn.edu.ahut;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by zhushuangfei on 2017/11/1.
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()//为当前包路径
                .apis(RequestHandlerSelectors.basePackage("cn.edu.ahut.Controller"))
                .paths(PathSelectors.any())
                .build();
    }


    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder() //页面标题
                .title("人脸识别签到 Swagger2 RESTful API")
                .termsOfServiceUrl("http://localhost/") //创建人
                .contact("zhushuangfei") //版本号
                .version("1.0") //描述
                .description("API 描述")
                .build();
    }
}
