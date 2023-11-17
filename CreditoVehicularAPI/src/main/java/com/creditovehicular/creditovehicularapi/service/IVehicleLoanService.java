package com.creditovehicular.creditovehicularapi.service;

import com.creditovehicular.creditovehicularapi.entities.VehicleLoan;

import java.util.List;

public interface IVehicleLoanService extends CrudService<VehicleLoan>{

    List<VehicleLoan> findByUserId(Long userId) throws Exception;
    VehicleLoan findByCode(String code) throws Exception;

}
