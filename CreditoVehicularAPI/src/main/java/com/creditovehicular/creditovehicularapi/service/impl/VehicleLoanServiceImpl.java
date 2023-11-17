package com.creditovehicular.creditovehicularapi.service.impl;

import com.creditovehicular.creditovehicularapi.entities.VehicleLoan;
import com.creditovehicular.creditovehicularapi.repository.IVehicleLoanRepository;
import com.creditovehicular.creditovehicularapi.service.IVehicleLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class VehicleLoanServiceImpl implements IVehicleLoanService {

    private final IVehicleLoanRepository vehicleLoanRepository;

    public VehicleLoanServiceImpl(IVehicleLoanRepository vehicleLoanRepository) {
        this.vehicleLoanRepository = vehicleLoanRepository;
    }

    @Override
    @Transactional
    public VehicleLoan save(VehicleLoan vehicleLoan) throws Exception {
        return vehicleLoanRepository.save(vehicleLoan);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        vehicleLoanRepository.deleteById(id);
    }

    @Override
    public List<VehicleLoan> getAll() throws Exception {
        return vehicleLoanRepository.findAll();
    }

    @Override
    public Optional<VehicleLoan> getById(Long id) throws Exception {
        return vehicleLoanRepository.findById(id);
    }

    @Override
    public List<VehicleLoan> findByUserId(Long userId) throws Exception {
        return vehicleLoanRepository.findByUserId(userId);
    }

    @Override
    public VehicleLoan findByCode(String code) throws Exception {
        return vehicleLoanRepository.findByCode(code);
    }
}
