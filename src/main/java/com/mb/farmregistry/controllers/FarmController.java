package com.mb.farmregistry.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("farms")
public class FarmController {

    @GetMapping("/search")
    public String getFarms() {
        return "first handler";
    }
}
