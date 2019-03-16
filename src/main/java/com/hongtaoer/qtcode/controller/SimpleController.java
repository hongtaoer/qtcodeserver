package com.hongtaoer.qtcode.controller;

import com.alibaba.fastjson.JSON;
import com.hongtaoer.qtcode.service.ContentBean;
import com.hongtaoer.qtcode.service.FreeMarkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pdf")
public class SimpleController {

    public static final Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @Autowired
    FreeMarkerService freeMarkerService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String parameter) {

        logger.debug("===============parameter:" + parameter);

        ContentBean contentBean = JSON.parseObject(parameter, ContentBean.class);
        freeMarkerService.createHTML(contentBean);

        return "0";

    }


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam String id) {

        System.out.println("get a pdf file for query");

        return "";

    }

}
