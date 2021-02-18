package com.jy.model;

import lombok.*;
import org.apache.ibatis.annotations.ConstructorArgs;

/**
 * @description:
 * @author: jy
 * @time: 2020/12/21 10:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Result {

    @NonNull
    private Integer code;

    @NonNull
    private String message;

    private Object data;


}
