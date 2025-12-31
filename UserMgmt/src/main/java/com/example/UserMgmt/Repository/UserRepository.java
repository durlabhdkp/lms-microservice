
package com.example.UserMgmt.Repository;

import com.example.UserMgmt.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
