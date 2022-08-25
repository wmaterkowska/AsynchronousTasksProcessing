package com.example.asynchronous.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Modifying
    @Query("UPDATE Task t SET t.status =:status WHERE t.id =:id")
    void updateStatus(@Param(value = "id") long id, @Param(value = "status") float status);

}
