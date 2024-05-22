package com.d2y.btpnteststore.repositories;

import com.d2y.btpnteststore.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerIdAndIsActive(Long customerId, Boolean isActive);

    @Query("SELECT c FROM Customer c WHERE c.isActive = true")
    List<Customer> findAllActiveCustomers();
}