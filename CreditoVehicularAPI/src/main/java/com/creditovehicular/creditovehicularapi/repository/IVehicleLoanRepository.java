package com.creditovehicular.creditovehicularapi.repository;

import com.creditovehicular.creditovehicularapi.entities.VehicleLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleLoanRepository extends JpaRepository<VehicleLoan, Long> {
    List<VehicleLoan> findByUserId( Long userId);
    VehicleLoan findByCode(String code);
}
