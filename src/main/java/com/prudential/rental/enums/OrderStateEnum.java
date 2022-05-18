package com.prudential.rental.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jarvis.jia
 * @date 2022/5/18
 */
@Getter
@AllArgsConstructor
public enum OrderStateEnum {

    RENTING(1, "renting"),
    CANCELED(-1, "canceled"),
    FINISHED(2,"finished");

    private Integer value;
    private String name;
}
