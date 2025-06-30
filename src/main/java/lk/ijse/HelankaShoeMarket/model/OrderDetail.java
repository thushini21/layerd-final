package lk.ijse.HelankaShoeMarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetail {
    private String order_id;
    private String product_id;
    private int qty_on_hand;
}
