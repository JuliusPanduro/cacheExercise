package com.example.demo.controllers;

import com.example.demo.services.Cache;
import com.example.demo.services.Database;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Julius Panduro
 */
@Controller
public class MapController {
    Cache cache = new Cache(60); //TTL in seconds
    Database database = new Database();

    @GetMapping("/")
    public String renderIndex(){
        return "index.html";
    }

    @GetMapping("/get-user-data")
    @ResponseBody
    public String returnUserData(@RequestParam String id) throws InterruptedException{
        if (!cache.hasCache(id)){
            cache.setCache(id,database.getDataSlow());
        }
        return cache.getCache(id);
    }
}
