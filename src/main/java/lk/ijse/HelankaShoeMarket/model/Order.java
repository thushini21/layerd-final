package lk.ijse.HelankaShoeMarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@Data
@NoArgsConstructor

public class Order {
    private String order_id;
    private String customer_id;
    private Date Order_placed_date;
    private Date order_hand_over_date;
    private String status;
    private String description;

}
