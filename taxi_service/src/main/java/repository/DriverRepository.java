package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer>{

}
