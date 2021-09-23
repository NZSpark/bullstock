package com.seclib.bull.hateoas.demo.stocks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.seclib.bull.hateoas.demo.stocks.entity.StocksEntity;

/**
 * <p>Description: </p>
 * @date  
 * @author   
 * @version 1.0
 * @name   
 * <p>Copyright:Copyright(c)2020</p>
 */
@RepositoryRestResource(path = "/stocks")
public interface StocksRepository  extends JpaRepository<StocksEntity, Long> {

    /**
     * 根据股票名称查找所对应的股票数据
     * @param list
     * @return
     */
    List<StocksEntity> findByNameInOrderById(@Param("list")List<String> list);

    /**
     * 根据名称查询股票信息
     * @param name
     * @return
     */
    public StocksEntity findByName(@Param("name")String name);
}
