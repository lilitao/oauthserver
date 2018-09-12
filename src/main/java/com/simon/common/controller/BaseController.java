package com.simon.common.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Base Controller
 *
 * @author simon
 * @create 2018-09-06 17:49
 **/

public class BaseController {
    /**
     * 字符串绑定Date类型
     * @param binder
     */
    @InitBinder
    protected void initDateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        dateFormat.setLenient(false);
        //第二个参数是控制是否支持传入的值是空，这个值很关键，如果指定为false，那么如果前台没有传值的话就会报错
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 字符串绑定Time类型
     * @param binder
     */
    @InitBinder
    protected void initTimeBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        dateFormat.setLenient(false);
        //第二个参数是控制是否支持传入的值是空，这个值很关键，如果指定为false，那么如果前台没有传值的话就会报错
        binder.registerCustomEditor(Time.class, new CustomDateEditor(dateFormat, true));
    }
}