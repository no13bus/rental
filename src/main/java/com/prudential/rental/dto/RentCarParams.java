package com.prudential.rental.dto;

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
    private Integer uid;

    @NotNull(message = "car id required")
    private Integer carId;

    @NotNull(message = "startTime required")
    private Date startTime;

    @NotNull(message = "endTime required")
    private Date endTime;

}
