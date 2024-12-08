package com.iitposs.pos.service.impl;

import com.iitposs.pos.Exception.NotFoundException;
import com.iitposs.pos.dto.request.OrderSaveRequestDTO;
import com.iitposs.pos.entity.Customer;
import com.iitposs.pos.entity.OrderDetails;
import com.iitposs.pos.entity.Orders;
import com.iitposs.pos.repo.CustomerRepo;
import com.iitposs.pos.repo.ItemRepo;
import com.iitposs.pos.repo.OrderDetailsRepo;
import com.iitposs.pos.repo.OrderRepo;
import com.iitposs.pos.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Transactional
    @Override
    public String saveOrder(OrderSaveRequestDTO saveRequestDTO) {
        Orders orders = new Orders();
        Customer customer = customerRepo.getReferenceById(saveRequestDTO.getCustomerID());


        orders.setCustomer(customer);
        orders.setDate(saveRequestDTO.getDate());
        orders.setOrderTotal(saveRequestDTO.getTotal());

        orderRepo.save(orders);

        if (orderRepo.existsById(orders.getOrderID())) {
            List<OrderDetails> orderDetailsList = modelMapper.map(
                    saveRequestDTO.getSaveRequestDTOList(), new TypeToken<List<OrderDetails>>(){}.getType()
            );
            for (int i=0; i < orderDetailsList.size(); i++) {
                orderDetailsList.get(i).setOrders(orders);
                orderDetailsList.get(i).setItems(
                        itemRepo.getReferenceById(
                                saveRequestDTO.getSaveRequestDTOList().get(i).getItem_id()
                        )
                );
            }
            if (!orderDetailsList.isEmpty()){
                orderDetailsRepo.saveAll(orderDetailsList);
                return "Order Details successfully";
            }else {
                throw new NotFoundException("No Order Details found");
            }

        }

        return null;
    }
}
