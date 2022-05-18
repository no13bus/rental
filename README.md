## api design

```
1. GET /api/rental/cars api can get the available car list between startTime and endTime.
2. POST /api/rental/cars api can rent a car between startTime and endTime.
3. GET /api/rental/orders api can get the order list in some conditions.
4. DELETE /api/rental/orders/{orderId} api can cancel order
5. PUT /orders/{orderId} api can finish the order.
```

## database design

```
CREATE TABLE `rent_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL DEFAULT '' COMMENT 'user name',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `update_time` datetime DEFAULT NULL COMMENT 'update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='users information table';
```

```
CREATE TABLE `rent_car` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `car_number` varchar(200) NOT NULL DEFAULT '' COMMENT 'car number',
  `brand` varchar(200) NOT NULL DEFAULT '' COMMENT 'car brand name',
  `state` tinyint(2) NOT NULL DEFAULT '1' COMMENT 'car state. 1:valid -1: not valid',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `update_time` datetime DEFAULT NULL COMMENT 'update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Car information table';
```

```
CREATE TABLE `rent_order` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `uid` int(20) NOT NULL COMMENT 'user id',
  `car_id` int(20) NOT NULL COMMENT 'car id',
  `start_time` datetime DEFAULT NULL COMMENT 'renting start time',
  `end_time` datetime DEFAULT NULL COMMENT 'renting end time',
  `state` tinyint(2) NOT NULL DEFAULT '1' COMMENT 'order state: 1. renting  -1: canceled 2:finished',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `update_time` datetime DEFAULT NULL COMMENT 'update time',
  PRIMARY KEY (`id`),
  KEY `idx_start_end_time` (`start_time`,`end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='users information table';
```



## What's more
According to the "A working customer facing web client online that could be used to quickly test the service",
you can use swagger to make a quickly api test about the service. enjoy it.

here is the swagger website:
http://rental.v2j.tech:8888/swagger-ui/index.html