package com.lambdaschool.javaorderssqlite.repository;

import com.lambdaschool.javaorderssqlite.models.Agents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agents, Long> {
    @Query(value = "SELECT a.agentname, o.ordnum, o.orddescription FROM Agents a, Orders o WHERE a.agentcode = o.agentcode ORDER BY agentname", nativeQuery = true)
    List<Object> findAgentOrders();
}
