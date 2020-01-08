package com.leyou.common.vo;

import com.leyou.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * @author: ls
 * @description:
 * @create: 2020-01-05 23:42
 */
@Data
public class ExceptionResult {
    private int status;

    private String msg;

    private Long timestamp;

    public ExceptionResult(ExceptionEnum em) {
        this.status = em.getCode();
        this.msg = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
