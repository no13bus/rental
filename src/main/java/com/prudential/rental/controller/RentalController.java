package com.prudential.rental.controller;


import com.prudential.rental.dto.RentCarParams;
import com.prudential.rental.enums.OrderStateEnum;
import com.prudential.rental.service.IRentCarService;
import com.prudential.rental.service.IRentOrderService;
import com.prudential.rental.web.ApiResponse;
import com.prudential.rental.web.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/api/rental")
public class RentalController extends BaseController {

    @Autowired
    private IRentOrderService orderService;
    @Autowired
    private IRentCarService carService;


    @ApiOperation(value="list all of cars infos between start time and end time")
    @GetMapping("/cars")
    public ApiResponse carsList(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startTime,
                                @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime) {
        ApiResponse apiResponse = ApiResponse.buildSuccess();
        apiResponse.setData(carService.getCarListByParams(startTime, endTime));
        return apiResponse;
    }


    @ApiOperation(value="rent one car")
    @PostMapping("/cars")
    public ApiResponse rent(@RequestBody @Valid RentCarParams rentCarParams, BindingResult br) {
        checkParameters(br);
        ApiResponse apiResponse = ApiResponse.buildSuccess();
        orderService.rent(rentCarParams);
        return apiResponse;
    }

    @ApiOperation(value="get the order list")
    @GetMapping("/orders")
    public ApiResponse orders(@RequestParam(required = false) Integer uid,
                              @RequestParam(required = false) Integer state,
                              @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  Date startTime,
                              @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  Date endTime) {
        ApiResponse apiResponse = ApiResponse.buildSuccess();
        apiResponse.setData(orderService.getOrderListByParams(uid, state, startTime, endTime));
        return apiResponse;
    }


    @ApiOperation(value="cancel the rental order")
    @DeleteMapping("/orders/{orderId}")
    public ApiResponse deleteOrder(@PathVariable("orderId") @NotNull(message = "orderId required") Integer orderId) {
        ApiResponse apiResponse = ApiResponse.buildSuccess();
        orderService.updateState(orderId, OrderStateEnum.CANCELED.getValue());
        return apiResponse;
    }


    @ApiOperation(value="return the car, finish the rental")
    @PutMapping("/orders/{orderId}")
    public ApiResponse finishOrder(@PathVariable("orderId") @NotNull(message = "orderId required") Integer orderId) {
        ApiResponse apiResponse = ApiResponse.buildSuccess();
        orderService.updateState(orderId, OrderStateEnum.FINISHED.getValue());
        return apiResponse;
    }
}
