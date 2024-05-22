package com.d2y.btpnteststore.services;

import com.d2y.btpnteststore.dto.CustomerDto;
import com.d2y.btpnteststore.exceptions.CustomException;
import com.d2y.btpnteststore.models.Customer;
import com.d2y.btpnteststore.repositories.CustomerRepository;
import com.d2y.btpnteststore.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = mapToEntity(customerDto);
        customer = customerRepository.save(customer);

        return mapToDto(customer);
    }


    public CustomerDto updateCustomer(Long customerId, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomException(Constants.CUSTOMER_NOT_FOUND));

        updateEntityFromDto(customer, customerDto);
        customer = customerRepository.save(customer);
        return mapToDto(customer);
    }


    public CustomerDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findByCustomerIdAndIsActive(customerId, true)
                .orElseThrow(() -> new CustomException(Constants.CUSTOMER_NOT_FOUND));

        return mapToDto(customer);
    }


    public CustomerDto deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findByCustomerIdAndIsActive(customerId, true)
                .orElseThrow(() -> new CustomException(Constants.CUSTOMER_NOT_FOUND));

        customer.setIsActive(false);
        customer = customerRepository.save(customer);
        return mapToDto(customer);
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAllActiveCustomers();
        return customers.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private Customer mapToEntity(CustomerDto customerDto) {
        return Customer.builder()
                .customerCode(customerDto.getCustomerCode())
                .customerName(customerDto.getCustomerName())
                .customerAddress(customerDto.getCustomerAddress())
                .customerPhone(customerDto.getCustomerPhone())
                .isActive(true)
                .lastOrderDate(LocalDateTime.now())
                .pic(customerDto.getPic())
                .build();
    }

    private CustomerDto mapToDto(Customer customer) {
        return CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .customerCode(customer.getCustomerCode())
                .customerName(customer.getCustomerName())
                .customerAddress(customer.getCustomerAddress())
                .customerPhone(customer.getCustomerPhone())
                .isActive(customer.getIsActive())
                .lastOrderDate(LocalDateTime.now())
                .pic(customer.getPic())
                .build();
    }

    private void updateEntityFromDto(Customer customer, CustomerDto customerDto) {
        if (customerDto.getCustomerCode() != null) {
            customer.setCustomerCode(customerDto.getCustomerCode());
        }
        if (customerDto.getCustomerName() != null) {
            customer.setCustomerName(customerDto.getCustomerName());
        }
        if (customerDto.getCustomerAddress() != null) {
            customer.setCustomerAddress(customerDto.getCustomerAddress());
        }
        if (customerDto.getCustomerPhone() != null) {
            customer.setCustomerPhone(customerDto.getCustomerPhone());
        }
        if (customerDto.getIsActive() != null) {
            customer.setIsActive(customerDto.getIsActive());
        }
        if (customerDto.getLastOrderDate() != null) {
            customer.setLastOrderDate(customerDto.getLastOrderDate());
        }
        if (customerDto.getPic() != null) {
            customer.setPic(customerDto.getPic());
        }
    }
}
