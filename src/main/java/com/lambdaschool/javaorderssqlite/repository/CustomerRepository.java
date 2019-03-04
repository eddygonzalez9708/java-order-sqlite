package com.lambdaschool.javaorderssqlite.repository;

import com.lambdaschool.javaorderssqlite.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
    @Query(value = "SELECT c.custcode, c.custname, o.ordnum, o.advanceamount, o.ordamount, o.orddescription FROM Customers c, Orders o WHERE c.custcode = o.custcode ORDER BY custcode", nativeQuery = true)
    List<Object> findCustomerOrders();
}
