package com.eunmin.spring.cats.config

import org.springframework.context.annotation.{Bean, Configuration}
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.builders.{ApiInfoBuilder, PathSelectors, RequestHandlerSelectors}

@Configuration
@EnableSwagger2
class SwaggerConfig {
  @Bean
  def api(): Docket = new Docket(DocumentationType.SWAGGER_2)
    .select()
    .apis(RequestHandlerSelectors.basePackage("com.eunmin.spring.cats"))
    .paths(PathSelectors.any())
    .build()
    .useDefaultResponseMessages(false)
    .apiInfo(apiInfo())

  def apiInfo() = new ApiInfoBuilder()
    .title("Spring Boot Example with Cats")
    .description("Spring Boot Cats 예제")
    .build()
}
