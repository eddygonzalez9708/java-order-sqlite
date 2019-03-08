package com.lambdaschool.javaorderssqlite.repository;

import com.lambdaschool.javaorderssqlite.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT * FROM Orders", nativeQuery = true)
    List<Orders> getAll();

    @Query(value = "SELECT * FROM Orders WHERE ordnum = :ordnum", nativeQuery = true)
    List<Orders> findById(@Param("ordnum") long ordnum);

    @Query(value = "SELECT o.ordnum, o.advanceamount, o.ordamount, o.orddescription FROM Orders o WHERE o.custcode IN (SELECT c.custcode FROM Customers c WHERE c.custname = :custname)", nativeQuery = true)
    List<Object> findCustomerOrdersByName(@Param("custname") String custname);

    @Query(value = "SELECT o.ordnum, o.advanceamount, o.ordamount, o.orddescription FROM Orders o WHERE o.custcode = :custcode", nativeQuery = true)
    List<Object> findCustomerOrdersByCustCode(@Param("custcode") long custname);

    @Modifying
    @Query(value = "DELETE FROM Orders WHERE ordnum = :ordnum", nativeQuery = true)
    void deleteById(@Param("ordnum") long ordnum);
}
