package com.gracegh.ToDoList.Repository;

import com.gracegh.ToDoList.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmailAddress(String email);
}
