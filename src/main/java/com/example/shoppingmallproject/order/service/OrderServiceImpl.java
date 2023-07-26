package com.example.shoppingmallproject.order.service;

import com.example.shoppingmallproject.order.dto.OrderDetailsDto;
import com.example.shoppingmallproject.order.dto.OrderRequestDto;
import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.order.repository.OrderRepository;
import com.example.shoppingmallproject.orderProduct.service.OrderProductService;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.product.service.ProductService;
import com.example.shoppingmallproject.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderProductService orderProductService;
    private final ProductService productService;

    // TODO: Product의 stock(재고) 차감 시점을 언제로 할지 정책을 정해야합니다.
    @Override
    @Transactional
    public Long createOrder(OrderRequestDto dto, User user) {
        List<Product> products = productService.getProductsByIds(dto.getProductIds());
        Map<Long, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));
        Long totalPrice = calculateTotalPrice(dto.getOrderDetailsDtos(), productMap);
        Order order = Order.builder()
                .user(user)
                .totalPrice(totalPrice)
                .build();
        orderRepository.save(order);
        createOrderProducts(dto.getOrderDetailsDtos(), productMap, order);
        return order.getId();
    }

    private Long calculateTotalPrice(List<OrderDetailsDto> orderDetailsDtos, Map<Long, Product> productMap) {
        long totalPrice = 0L;
        for (OrderDetailsDto dto: orderDetailsDtos){
            Long price = productMap.get(dto.getProductId()).getPrice();
            totalPrice += dto.getQuantity() * price;
        }
        return totalPrice;
    }

    private void createOrderProducts(List<OrderDetailsDto> orderDetailsDtos, Map<Long, Product> productMap, Order order){
        for (OrderDetailsDto detailsDto: orderDetailsDtos){
            Product product = productMap.get(detailsDto.getProductId());
            Long eachTotalPrice = detailsDto.getQuantity() * product.getPrice();
            orderProductService.createOrderProduct(order, product, product.getSeller(),
                    detailsDto.getQuantity(), eachTotalPrice);
        }
    }
}
