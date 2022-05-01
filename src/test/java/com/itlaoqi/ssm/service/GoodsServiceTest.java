package com.itlaoqi.ssm.service;

import com.itlaoqi.ssm.entity.Goods;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.text.ParseException;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})

public class GoodsServiceTest {
    //@BeforeClass代表在初始化测试用例类前执行的操作
    //@BeforeClass必须是static静态方法
    @BeforeClass
    public static void init(){
        System.out.println("正在导入Goods表数据");
    }

    @Resource
    private GoodsService goodsService;


    @Before
    public void doBefore(){
        System.out.println("获取数据库Connection对象");
    }

    @After
    public void doAfter(){
        System.out.println("释放数据库Connection对象");
    }


    @Test
    //@Transactional默认在测试用例执行成功后,为了保证原始数据不被测试数据污染
    //自动进行回滚,要解决这个问题需要设置@Rollback(false)关闭自动回滚
    @Transactional
    @Rollback(false)
    public void initGoods() throws ParseException {
        goodsService.initGoods();
    }

    /**
     * 程序运行成功 绿色对勾
     * 程序运行失败 红色叹号
     * 程序运行逻辑错误 黄色叉号
     */
    @Test
    public void findById() {

        Goods goods = goodsService.findById(9000);
        //Assert 断言,对程序产生的结果进行判断
        assertTrue("未找到Goods对象" , goods != null);
    }
    /*测试用例类执行完成后,执行的操作
    通常用于清除结果*/
    @AfterClass
    public static void destory(){
        System.out.println("清空Goods表数据");
    }
}