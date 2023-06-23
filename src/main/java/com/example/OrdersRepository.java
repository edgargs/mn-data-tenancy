package com.example;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.transaction.annotation.TransactionalAdvice;

import java.util.List;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface OrdersRepository extends CrudRepository<Order, Integer> {

    @Override
    List<Order> findAll();
}
