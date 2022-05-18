package com.prudential.rental.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * users information table
 * </p>
 *
 * @author jarvis.jia
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RentOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value="id",type = IdType.AUTO)
    private Integer id;

    /**
     * user id
     */
    private Integer uid;

    /**
     * car id
     */
    private Integer carId;

    /**
     * renting start time
     */
    private Date startTime;

    /**
     * renting end time
     */
    private Date endTime;

    /**
     * order state: 1. renting  -1: canceled 2:finished
     */
    private Integer state;

    /**
     * create time
     */
    private Date createTime;

    /**
     * update time
     */
    private Date updateTime;


}
