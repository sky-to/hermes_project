package com.jy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: jy
 * @time: 2020/12/21 10:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult <T>{

    private long total;
    private List<T> rows;
}