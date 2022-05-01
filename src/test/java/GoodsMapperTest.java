import com.itlaoqi.ssm.entity.Goods;
import com.itlaoqi.ssm.mapper.GoodsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * SpringJUnit4ClassRunner.class是Spring-Test提供的整合类
 * Junit将单元测试管理权交给Spring,便可以在测试用例启动时
 * 自动加载applicationContext.xml并初始化IOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class GoodsMapperTest {
    @Resource
    private GoodsMapper goodsMapper;
    //@Test说明下面方法是可以单独执行的单元测试方法
    @Test
    public void testFindById(){
        Goods goods = goodsMapper.findById(900);
        System.out.println(goods.getTitle());
    }
}
