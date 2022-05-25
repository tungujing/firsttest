package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("雇员实体类")
public class Emp {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("名字")
    private String name;
    @ApiModelProperty("性别")
    private Integer gender;
    @ApiModelProperty("部门编号")
    private Dept dept;
    @ApiModelProperty("状态")
    private Integer status;
}
