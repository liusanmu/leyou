package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: ls
 * @description:
 * @create: 2020-01-05 22:57
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    PRICE_CANNOT_NULL(400,"价格不能为空"),
    CATEGORY_NOT_FOUND(400, "未查询到分类数据")
    ;

    private int code;
    private String msg;

}
