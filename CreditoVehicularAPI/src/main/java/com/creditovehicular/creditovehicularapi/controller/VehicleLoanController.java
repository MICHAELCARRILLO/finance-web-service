package com.creditovehicular.creditovehicularapi.controller;

import com.creditovehicular.creditovehicularapi.entities.Client;
import com.creditovehicular.creditovehicularapi.entities.User;
import com.creditovehicular.creditovehicularapi.entities.VehicleLoan;
import com.creditovehicular.creditovehicularapi.service.IClientService;
import com.creditovehicular.creditovehicularapi.service.IUserService;
import com.creditovehicular.creditovehicularapi.service.IVehicleLoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicleLoans")
@CrossOrigin(origins = "*")
public class VehicleLoanController {

    private final IClientService clientService;
    private final IUserService userService;
    private final IVehicleLoanService vehicleLoanService;

    public VehicleLoanController(IClientService clientService, IUserService userService, IVehicleLoanService vehicleLoanService) {
        this.clientService = clientService;
        this.userService = userService;
        this.vehicleLoanService = vehicleLoanService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleLoan>> getAllVehicleLoans()   {
         try{
             List<VehicleLoan> vehicleLoans = vehicleLoanService.getAll();
             if(vehicleLoans.isEmpty()){
                 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }
            return new ResponseEntity<>(vehicleLoans, HttpStatus.OK);

         } catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleLoan> getVehicleLoanById(@PathVariable("id") Long id)   {
        try{
            Optional<VehicleLoan> vehicleLoan = vehicleLoanService.getById(id);
            if(!vehicleLoan.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(vehicleLoan.get(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/createLoan/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleLoan> createVehicleLoan(@PathVariable("userId") Long userId, @Valid @RequestBody VehicleLoan vehicleLoan)   {
        try {
            // Fetch existing User
            Optional<User> user = userService.getById(userId);
            if (!user.isPresent()) {
                return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
            }

                Client newClient = vehicleLoan.getClient();
                newClient.setId(null); // Set the ID to null to ensure it's treated as a new entity
                Client clientCreated = clientService.save(newClient);

            vehicleLoan.setUser(user.get());
            vehicleLoan.setClient(clientCreated);
            // Save the new VehicleLoan
            VehicleLoan vehicleLoanCreated = vehicleLoanService.save(vehicleLoan);

            return ResponseEntity.status(HttpStatus.CREATED).body(vehicleLoanCreated);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleLoan> updateVehicleLoan(@PathVariable("id") Long vehicleLoanId, @Valid @RequestBody VehicleLoan vehicleLoan)   {
        try{
            Optional<VehicleLoan> vehicleLoanData = vehicleLoanService.getById(vehicleLoanId);
            if(!vehicleLoanData.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            vehicleLoan.setId(vehicleLoanId);
            VehicleLoan vehicleLoanUpdated = vehicleLoanService.save(vehicleLoan);
            return new ResponseEntity<>(vehicleLoanUpdated, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleLoan> deleteVehicleLoan(@PathVariable("id") Long id)   {
        try{
            Optional<VehicleLoan> vehicleLoan = vehicleLoanService.getById(id);
            if(!vehicleLoan.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            vehicleLoanService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //find by user id
    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleLoan>> findVehicleLoanByUserId(@PathVariable("userId") Long userId)   {
        try{
            List<VehicleLoan> vehicleLoans = vehicleLoanService.findByUserId(userId);
            if(vehicleLoans.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicleLoans, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //find by code
    @GetMapping(value = "/code/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleLoan> findVehicleLoanByCode(@PathVariable("code") String code)   {
        try{
            Optional<VehicleLoan> vehicleLoan = Optional.ofNullable(vehicleLoanService.findByCode(code));
            if(!vehicleLoan.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(vehicleLoan.get(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}