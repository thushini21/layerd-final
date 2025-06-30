package lk.ijse.HelankaShoeMarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PlaceOrder {
    private Order order;
    private List<OrderDetail> odList;
}
