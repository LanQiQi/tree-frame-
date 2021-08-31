package com.lq.ztreedemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String id;
    private String pid;
    private Integer level;
    private String name;
}
