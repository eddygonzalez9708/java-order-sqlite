package com.lambdaschool.javaorderssqlite;

import com.lambdaschool.javaorderssqlite.models.Agents;
import com.lambdaschool.javaorderssqlite.models.Customers;
import com.lambdaschool.javaorderssqlite.models.Orders;
import com.lambdaschool.javaorderssqlite.repository.AgentRepository;
import com.lambdaschool.javaorderssqlite.repository.CustomerRepository;
import com.lambdaschool.javaorderssqlite.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/orders")
    public List<Orders> getAllOrders() {
        return ordrepos.findAll();
    }

    // GET /agents - return all the agents

    @GetMapping("/agents")
    public List<Agents> getAllAgents() {
        return agentrepos.findAll();
    }

    // GET /customers/custcode/{custcode}

    @GetMapping("/customers/custcode/{custcode}")
    public List<Customers> getCustomerByCode(@PathVariable long custcode) {
        return custrepos.findById(custcode).stream().collect(Collectors.toList());
    }

    // GET /orders/ordnum/{ordnum}

    @GetMapping("/orders/ordnum/{ordnum}")
    public List<Orders> getOrderByOrdNum(@PathVariable long ordnum) {
        return ordrepos.findById(ordnum).stream().collect(Collectors.toList());
    }

    // GET /agents/agentcode/{agentcode}

    @GetMapping("/agents/agentcode/{agentcode}")
    public List<Agents> getAgentByAgentCode(@PathVariable long agentcode) {
        return agentrepos.findById(agentcode).stream().collect(Collectors.toList());
    }

    // POST /customers - adds a customer

    @PostMapping("/customers")
    public Customers addCustomer(@RequestBody Customers customer) {
        return custrepos.save(customer);
    }

    // POST /orders - adds an order

    @PostMapping("/orders")
    public Orders addOrder(@RequestBody Orders singleOrder) {
        return ordrepos.save(singleOrder);
    }

    // POST /agents - adds an agent

    @PostMapping("/agents")
    public Agents addAgent(@RequestBody Agents agent) {
        return agentrepos.save(agent);
    }

    // PUT /customers/custcode/{custcode} - updates a customer based on custcode

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