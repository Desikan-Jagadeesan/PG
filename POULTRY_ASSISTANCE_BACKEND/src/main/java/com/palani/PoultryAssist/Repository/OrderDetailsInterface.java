package com.palani.PoultryAssist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palani.PoultryAssist.Model.OrderDetails;

@Repository
public interface OrderDetailsInterface extends JpaRepository<OrderDetails, Long> {

}
