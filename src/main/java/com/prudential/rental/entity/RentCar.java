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
 * Car information table
 * </p>
 *
 * @author jarvis.jia
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RentCar implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value="id",type = IdType.AUTO)
    private Integer id;

    /**
     * car number
     */
    private String carNumber;

    /**
     * car brand name
     */
    private String brand;

    /**
     * create time
     */
    private Date createTime;

    /**
     * update time
     */
    private Date updateTime;


}
