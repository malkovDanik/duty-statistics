package ru.tvgtu.dutystatistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Danik
 */
@Controller
public class MainController {

    @RequestMapping("/statistic")
    public static String statisticPage() {
        return "statistic";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Тест пройден!";
    }
}
