package com.itlaoqi.ssm.mapper;

import com.itlaoqi.ssm.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 在学习过程中遇到任何问题可以加我的QQ群722570599(老齐的IT指导群)
 在这里老齐将给你直接提供帮助与解答，只为你可以学的更轻松。
 同时你也可以访问老齐的官网: www.itlaoqi.com , 这里课程更优惠
 */
public interface GoodsMapper {
    public Goods findById(Integer goodsId);
//    public List<Goods> findByCondition(Map param);
    public List<Goods> findByCondition(@Param("categoryId") Integer categoryId , @Param("currentPrice")Float currentPrice);

    public int insert(Goods goods);
}
