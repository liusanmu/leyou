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
    CATEGORY_NOT_FOUND(400, "未查询到分类数据"),
    UPLOAD_FILE_ERROR(500, "文件上传错误"),
    INVALID_FILE_TYPE(400,"文件类型错误"),
    INSERT_OP_FAILD(500,"添加失败")

    ;

    private int code;
    private String msg;

    public enum INSERT_OP_FAILD {}

    // public enum UPLOAD_FILE_ERROR {}
}
