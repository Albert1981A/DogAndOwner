package com.AlbertAbuav.DogAndOwner.Repositories;

import com.AlbertAbuav.DogAndOwner.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);
}
