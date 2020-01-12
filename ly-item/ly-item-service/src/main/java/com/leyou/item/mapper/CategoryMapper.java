package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: ls
 * @description:
 * @create: 2020-01-05 23:55
 */

public interface CategoryMapper extends Mapper<Category>, SelectByIdListMapper<Category, Long> {
}
