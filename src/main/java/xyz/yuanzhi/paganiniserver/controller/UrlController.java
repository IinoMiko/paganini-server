package xyz.yuanzhi.paganiniserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {

    @GetMapping(value = "/file_url={url}")
    public String getUrl(@PathVariable String url){
        return "http://localhost:8080" + url;
    }

}
