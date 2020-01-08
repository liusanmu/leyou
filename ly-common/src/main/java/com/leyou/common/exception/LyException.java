package com.leyou.common.exception;

import com.leyou.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: ls
 * @description:
 * @create: 2020-01-05 23:04
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LyException extends RuntimeException{

    private ExceptionEnum exceptionEnum;

}
