package com.lambdaschool.javaorderssqlite.repository;

import com.lambdaschool.javaorderssqlite.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
    @Query(value = "SELECT * FROM Customers", nativeQuery = true)
    List<Customers> getAll();

    @Query(value = "SELECT * FROM Customers WHERE custcode = :custcode", nativeQuery = true)
    List<Customers> findById(@Param("custcode") long custcode);

    @Query(value = "SELECT c.custcode, c.custname, o.ordnum, o.advanceamount, o.ordamount, o.orddescription FROM Customers c, Orders o WHERE c.custcode = o.custcode ORDER BY c.custcode", nativeQuery = true)
    List<Object> findCustomerOrders();

    @Modifying
    @Query(value = "DELETE FROM Customers WHERE custcode = :custcode", nativeQuery = true)
    void deleteById(@Param("custcode") long custcode);
}