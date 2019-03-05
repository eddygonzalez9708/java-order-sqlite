package com.lambdaschool.javaorderssqlite;

import com.lambdaschool.javaorderssqlite.models.Customers;
import com.lambdaschool.javaorderssqlite.repository.AgentRepository;
import com.lambdaschool.javaorderssqlite.repository.CustomerRepository;
import com.lambdaschool.javaorderssqlite.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class JavaOrdersSQLiteController {
    @Autowired
    AgentRepository agentrepos;

    @Autowired
    CustomerRepository custrepos;

    @Autowired
    OrderRepository ordrepos;

    // GET /customers - returns all the customers

    @GetMapping("/customers")
    public List<Customers> getAllCustomers() {
        return custrepos.findAll();
    }

    // GET /orders - return all the orders

    // GET /agents - return all the agents

    // GET /customers/custcode/{custcode}

    // GET /orders/ordnum/{ordnum}

    // GET /agents/agentcode/{agentcode}

    // POST /customers - adds a customer

    // POST /orders - adds an order

    // POST /agents - adds an agent

    // PUT /customers/custocode/{custcode} - updates a customer based on custcode

    // PUT /orders/ordnum/{ordnum} - updates an order based on ordnum

    // PUT /agents/agentcode/{agentcode} - updates an agent based on ordnum

    // DELETE /customers/custcode/{custcode} - Deletes a customer based off of their custcode and deletes all their associated orders

    // DELETE /orders/ordnum/{ordnum} - deletes an order based off its ordnum

    // DELETE agents/agentcode/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)

    // /customers/order - Returns all customers with their orders

    // /customers/name/{custname} - Returns all orders for a particular customer based on name

    // /customers/order/{custcode} - Returns all orders for a particular customer based on custcode

    // /agents - Returns all agents with their customers

    // /agents/orders - Return a list with the agents name and associated order number and order description

    // /customers/{custcode} - Deletes a customer based off of their custcode and deletes all their associated orders

    // /agents/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)
}