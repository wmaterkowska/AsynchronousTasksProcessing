package com.example.asynchronous.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Modifying
    @Query("UPDATE Task t SET t.status =:status, t.result =:result where t.id =:id")
    @Transactional
    void updateTask(@Param(value = "id") long id, @Param(value = "status") float status, @Param(value= "result") long result);

}
