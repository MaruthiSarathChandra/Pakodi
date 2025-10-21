package com.Api.Pakodi.Repository.ordersRepo;

import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.order.OrdersItems;
import com.Api.Pakodi.request.dto.GetPastOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersItemsRepo extends JpaRepository<OrdersItems, Long> {
    @Query(value =
            "SELECT distinct o.menu_id " +
                    "from " +
                    "orders_items o " +
                    "WHERE o.order_status = ?2 " +
                    "AND " +
                    "o.gmail_id = ?1" , nativeQuery = true)
    List<Long> findMenuByGmailId(String GmailId, String orderStatus);


    List<OrdersItems> findByGmailId(String gmailId);
}
