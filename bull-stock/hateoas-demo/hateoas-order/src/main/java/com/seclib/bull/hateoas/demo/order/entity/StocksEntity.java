package com.seclib.bull.hateoas.demo.order.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Description: </p>
 * @date  
 * @author   
 * @version 1.0
 * @name   
 * <p>Copyright:Copyright(c)2020</p>
 */
@Entity
@Data
@Table(name = "T_STOCKS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StocksEntity extends BaseEntity{

    /**
     * 股票名称
     */
    private String name;

    /**
     * 股票价格
     */
    private Double price;
}
