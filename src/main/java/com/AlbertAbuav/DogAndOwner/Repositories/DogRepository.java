package com.AlbertAbuav.DogAndOwner.Repositories;

import com.AlbertAbuav.DogAndOwner.beans.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Integer> {

}
