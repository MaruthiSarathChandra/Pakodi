package com.Api.Pakodi.Repository.ordersRepo;

import com.Api.Pakodi.domain.order.PakodiOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PakodiOrdersRepo extends JpaRepository<PakodiOrders, Long> {

}
