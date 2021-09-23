package com.seclib.bull.hateoas.demo.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seclib.bull.hateoas.demo.order.entity.OrderEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * <p>Description: </p>
 * @date  
 * @author   
 * @version 1.0
 * @name   
 * <p>Copyright:Copyright(c)2020</p>
 */
@RepositoryRestResource(path ="/order")
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    /**
     * 根据用户查找获取所有的订单信息
     * @param user
     * @return
     */
    public List<OrderEntity> findByUser(@Param("user") String user);
}
