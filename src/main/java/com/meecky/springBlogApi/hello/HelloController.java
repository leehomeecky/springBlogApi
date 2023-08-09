package com.meecky.springBlogApi.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("say-hello/{name}")
    public HelloResponse hello(@PathVariable String name){
        return new HelloResponse("Hello ".concat(name));
    }
}
