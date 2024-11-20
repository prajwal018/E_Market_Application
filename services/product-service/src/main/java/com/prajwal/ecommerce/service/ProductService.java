package com.prajwal.ecommerce.service;

import com.prajwal.ecommerce.exception.ProductPurchaseException;
import com.prajwal.ecommerce.mapper.ProductMapper;
import com.prajwal.ecommerce.record.ProductPurchaseRequest;
import com.prajwal.ecommerce.record.ProductPurchaseResponse;
import com.prajwal.ecommerce.record.ProductRequest;
import com.prajwal.ecommerce.record.ProductResponse;
import com.prajwal.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public Integer createProduct(ProductRequest request) {
        var product = mapper.toProduct(request);
        return repository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {

        //extract productIds from products that users wants to purchase
        var productIds = request.stream()
                .map(ProductPurchaseRequest::productId)
                .toList();

        //extract products from stores database which user wants to buy
        var storedProducts = repository.findAllByIdInOrderById(productIds);

        //checks for product existence in database
        if (productIds.size() != storedProducts.size())
            throw new ProductPurchaseException("One or more products does not exists");

        //sort incoming purchase product list
        var storedRequest = request.stream()
                .sorted(Comparator
                        .comparing(ProductPurchaseRequest::productId))
                .toList();

        // resulting list declaration
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();

        //looping over each product
        for (int i = 0; i < storedRequest.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storedRequest.get(i);

            //checks for stock of products
            if (product.getAvailableQuantity() < productRequest.quantity())
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.productId());

            //calculate new quantity after purchase is performed
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);

            //update product stock to db
            repository.save(product);

            //collecting results
            purchasedProducts.add(mapper.toProductPurchaseResponse(product, productRequest.quantity()));
        }

        return purchasedProducts;
    }

    public ProductResponse findById(Integer productId) {
        return repository.findById(productId)
                .map(mapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with provided Id:: " + productId));
    }

    public List<ProductResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
