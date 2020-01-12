package com.leyou;

import com.leyou.item.mapper.SkuMapper;
import com.leyou.item.pojo.Sku;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

/**
 * @author: ls
 * @description:
 * @create: 2020-01-12 23:32
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemTest {

    @Autowired
    SkuMapper skuMapper;

    @Test
   // @Transactional
    public void testLocalDateToDb() {
        Sku sku = new Sku();
       /* private Long spuId;
        private String title;
        private String images;
        private Long price;
        private String ownSpec;// 商品特殊规格的键值对
        private String indexes;// 商品特殊规格的下标
        private Boolean enable;// 是否有效，逻辑删除用
        private LocalDate createTime;// 创建时间
        private LocalDate lastUpdateTime;// 最后修改时间*/
        sku.setId(123456L);
        sku.setImages("12213");
        sku.setOwnSpec("1212");
        sku.setIndexes("1212");
        sku.setEnable(false);
        sku.setSpuId(12344144L);
        sku.setTitle("afasf");
        sku.setPrice(121L);
        sku.setCreateTime(LocalDate.now());
        sku.setLastUpdateTime(LocalDate.now());
        int insert = skuMapper.insert(sku);
        Sku sku1 = skuMapper.selectByPrimaryKey(123456L);
        System.out.println(sku1);

    }
}
