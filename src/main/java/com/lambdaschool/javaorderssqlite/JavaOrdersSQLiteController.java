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
        return custrepos.getAll();
    }

    // GET /orders - return all the orders

    @GetMapping("/orders")
    public List<Orders> getAllOrders() {
        return ordrepos.getAll();
    }

    // GET /agents - return all the agents

    @GetMapping("/agents")
    public List<Agents> getAllAgents() {
        return agentrepos.getAll();
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

    @PutMapping("/customers/custcode/{custcode}")
    public Customers updateCustomer(@RequestBody Customers customer, @PathVariable long custcode) {
        List<Customers> updatedCustomer = custrepos.findById(custcode);
        if (updatedCustomer.size() > 0) {
            customer.setCustcode(custcode);
            custrepos.save(customer);
            return customer;
        } else {
            throw new Error("The custcode " + custcode + " does not exist.");
        }
     }

    // PUT /orders/ordnum/{ordnum} - updates an order based on ordnum

    @PutMapping("/orders/ordnum/{ordnum}")
    public Orders updateOrder(@RequestBody Orders singleOrder, @PathVariable long ordnum) {
        List<Orders> updatedOrder = ordrepos.findById(ordnum);
        if (updatedOrder.size() > 0) {
            singleOrder.setOrdnum(ordnum);
            ordrepos.save(singleOrder);
            return singleOrder;
        } else {
            throw new Error("The ordnum " + ordnum + " does not exist.");
        }
    }

    // PUT /agents/agentcode/{agentcode} - updates an agent based on agentcode

    @PutMapping("/agents/agentcode/{agentcode}")
    public Agents updateAgent(@RequestBody Agents agent, @PathVariable long agentcode) {
        List<Agents> updatedAgent = agentrepos.findById(agentcode);
        if (updatedAgent.size() > 0) {
            agent.setAgentcode(agentcode);
            agentrepos.save(agent);
            return agent;
        } else {
            throw new Error("The agentcode " + agentcode + " does not exist.");
        }
    }

    // DELETE /customers/custcode/{custcode} - Deletes a customer based off of their custcode and deletes all of their associated orders

    @DeleteMapping("/customers/custcode/{custcode}")
    public Customers deleteCustomer(@PathVariable long custcode) {
        List<Customers> deletedCustomer = custrepos.findById(custcode);
        if (deletedCustomer.size() > 0) {
            custrepos.deleteById(custcode);
            return deletedCustomer.get(0);
        } else {
            throw new Error("The custcode " + custcode + " does not exist.");
        }
    }

    // DELETE /orders/ordnum/{ordnum} - deletes an order based off its ordnum

    @DeleteMapping("/orders/ordnum/{ordnum}")
    public List<Orders> deleteOrder(@PathVariable long ordnum) {
        List<Orders> deletedOrder = ordrepos.findById(ordnum);
        if (deletedOrder.size() > 0) {
            ordrepos.deleteById(ordnum);
            return deletedOrder;
        } else {
            throw new Error("The ordnum " + ordnum + " does not exist.");
        }
    }

    // DELETE agents/agentcode/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)

    @DeleteMapping("/agents/agent/{agentcode}")
    public Agents deleteAgent(@PathVariable long agentcode) {
        Agents deletedAgent = agentrepos.findById(agentcode).get(0);

        if (deletedAgent.getCustomers().size() == 0 || deletedAgent.getOrders().size() == 0) {
            throw new Error("Agent cannot be deleted if they are assigned to a customer or order.");
        } else {
            agentrepos.deleteById(agentcode);
            return deletedAgent;
        }
    }

    // /customers/order - Returns all customers with their orders

    @GetMapping("/customer/order")
    public List<Object> getCustomerOrders() {
        return custrepos.findCustomerOrders().stream().collect(Collectors.toList());
    }

    // /customers/name/{custname} - Returns all orders for a particular customer based on name

    @GetMapping("/customer/name/{custname}")
    public List<Object> getCustomerOrdersByName(@PathVariable String custname) {
        return ordrepos.findCustomerOrdersByName(custname);
    }

    // /customers/order/{custcode} - Returns all orders for a particular customer based on custcode

    @GetMapping("/customer/order/{custcode}")
    public List<Object> getCustomerOrdersByCustCode(@PathVariable long custcode) {
        return ordrepos.findCustomerOrdersByCustCode(custcode);
    }

    // /agents/orders - Return a list with the agents name and associated order number and order description

    @GetMapping("/agents/orders")
    public List<Object> getAgentOrders() {
        return agentrepos.findAgentOrders();
    }
}