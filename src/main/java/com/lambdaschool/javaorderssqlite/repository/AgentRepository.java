package com.lambdaschool.javaorderssqlite.repository;

import com.lambdaschool.javaorderssqlite.models.Agents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agents, Long> {
    @Query(value = "SELECT * FROM Agents WHERE agentcode = :agentcode", nativeQuery = true)
    List<Agents> findById(@Param("agentcode") long agentcode);

    @Query(value = "SELECT a.agentname, o.ordnum, o.orddescription FROM Agents a, Orders o WHERE a.agentcode = o.agentcode ORDER BY agentname", nativeQuery = true)
    List<Object> findAgentOrders();

    @Modifying
    @Query(value = "DELETE FROM Agents WHERE agentcode = :agentcode", nativeQuery = true)
    void deleteById(@Param("agentcode") long agentcode);
}
