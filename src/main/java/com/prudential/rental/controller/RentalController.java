package com.prudential.rental.controller;


import com.prudential.rental.dto.RentCarParams;
import com.prudential.rental.enums.OrderStateEnum;
import com.prudential.rental.service.IRentCarService;
import com.prudential.rental.service.IRentOrderService;
import com.prudential.rental.web.ApiResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <p>
 * Rental Api
 * </p>
 *
 * @author jarvis.jia
 * @since 2022-05-18
 */
@RestController
@Validated
@RequestMapping("/api/rental")
public class RentalController{

    @Autowired
    private IRentOrderService orderService;
    @Autowired
    private IRentCarService carService;


    @ApiOperation(value="list all of cars infos between start time and end time")
    @GetMapping("/cars")
    public ApiResponse carsList(@ApiParam(name = "startTime", value = "ex: 2022-05-18 10:00:00", required = true) @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startTime,
                                @ApiParam(name = "endTime", value = "ex: 2022-05-20 10:00:00", required = true)  @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime
                                ) {
        ApiResponse apiResponse = ApiResponse.buildSuccess();
        apiResponse.setData(carService.getCarListByParams(startTime, endTime));
        return apiResponse;
    }


    @ApiOperation(value="rent one car")
    @PostMapping("/cars")
    public ApiResponse rent(@RequestBody @Valid RentCarParams rentCarParams) {
        ApiResponse apiResponse = ApiResponse.buildSuccess();
        orderService.rent(rentCarParams);
        return apiResponse;
    }

    @ApiOperation(value="get the order list")
    @GetMapping("/orders")
    public ApiResponse orders(@ApiParam(name = "uid", value = "ex: 1", required = false) @RequestParam(required = false) Integer uid,
                              @ApiParam(name = "state", value = "ex: 1", required = false) @RequestParam(required = false) Integer state,
                              @ApiParam(name = "startTime", value = "ex: 2022-05-18 10:00:00", required = false) @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  Date startTime,
                              @ApiParam(name = "endTime", value = "ex: 2022-05-20 10:00:00", required = false) @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  Date endTime) {
        ApiResponse apiResponse = ApiResponse.buildSuccess();
        apiResponse.setData(orderService.getOrderListByParams(uid, state, startTime, endTime));
        return apiResponse;
    }


    @ApiOperation(value="cancel the rental order")
    @DeleteMapping("/orders/{orderId}")
    public ApiResponse deleteOrder(@ApiParam(name = "orderId", value = "ex: 1", required = true) @PathVariable("orderId") @NotNull(message = "orderId required") Integer orderId) {
        ApiResponse apiResponse = ApiResponse.buildSuccess();
        orderService.updateState(orderId, OrderStateEnum.CANCELED.getValue());
        return apiResponse;
    }


    @ApiOperation(value="return the car, finish the rental")
    @PutMapping("/orders/{orderId}")
    public ApiResponse finishOrder(@ApiParam(name = "orderId", value = "ex: 1", required = true)  @PathVariable("orderId") @NotNull(message = "orderId required") Integer orderId) {
        ApiResponse apiResponse = ApiResponse.buildSuccess();
        orderService.updateState(orderId, OrderStateEnum.FINISHED.getValue());
        return apiResponse;
    }
}
