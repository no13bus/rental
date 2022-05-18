package com.prudential.rental.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author jarvis.jia
 * @date 2022/5/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentCarParams {

    @NotNull(message = "uid required")
    @ApiModelProperty(value = "uid",dataType="Integer",name="uid",example="1")
    private Integer uid;

    @NotNull(message = "car id required")
    @ApiModelProperty(value = "carId",dataType="Integer",name="carId",example="1")
    private Integer carId;


    @NotNull(message = "startTime required")
    @ApiModelProperty(value = "startTime",dataType="String",name="startTime",example="2022-05-18 10:00:00")
    private Date startTime;

    @NotNull(message = "endTime required")
    @ApiModelProperty(value = "endTime",dataType="String",name="endTime",example="2022-05-20 10:00:00")
    private Date endTime;

}
