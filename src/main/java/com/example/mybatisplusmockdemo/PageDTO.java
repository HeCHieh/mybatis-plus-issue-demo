package com.example.mybatisplusmockdemo;

import lombok.Data;

/**
 * 列表
 *
 * @author Roger
 */

@Data
public class PageDTO {

    /**
     * 当前页
     */
    private Long current;

    /**
     * 要查询记录数
     */
    private Long limit;
}
