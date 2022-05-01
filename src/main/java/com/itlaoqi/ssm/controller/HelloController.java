package com.itlaoqi.ssm.controller;

import com.itlaoqi.ssm.entity.Goods;
import com.itlaoqi.ssm.mapper.GoodsMapper;
import com.itlaoqi.ssm.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 在学习过程中遇到任何问题可以加我的QQ群722570599(老齐的IT指导群)
 在这里老齐将给你直接提供帮助与解答，只为你可以学的更轻松。
 同时你也可以访问老齐的官网: www.itlaoqi.com , 这里课程更优惠
 */
@Controller
public class HelloController {
    /*使用@Resource动态注入实现类
    默认beanId就是接口名首字母小写*/
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private GoodsService goodsService;

    @GetMapping("/hello")
    public ModelAndView showHello(){
        ModelAndView mav = new ModelAndView("/hello");
        Goods goods = goodsMapper.findById(777);
        mav.addObject("goods", goods);

//        Map param = new HashMap();
//        param.put("categoryId", 44);
//        param.put("currentPrice", 300);
        List<Goods> list = goodsMapper.findByCondition(44,300f);
        for (Goods g : list) {
            System.out.println(g.getTitle());
        }
        return mav;
    }

    @GetMapping("/init")
    @ResponseBody
    public String initGoods() throws ParseException {
        goodsService.initGoods();
        return "SUCCESS";
    }
}
