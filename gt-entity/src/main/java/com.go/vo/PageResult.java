package com.go.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PageResult<T> {

    private List<T> list;//分页数据
    private long total;//总记录数

}
