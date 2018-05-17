package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Ride;

public interface RideRepository extends JpaRepository<Ride, Integer>{

}
