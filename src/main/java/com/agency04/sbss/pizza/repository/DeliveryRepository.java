package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
