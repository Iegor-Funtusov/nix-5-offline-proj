package com.nix.hw.app;

import com.nix.hw.lib.CrudFactory;
import com.nix.hw.lib.CrudService;

import java.util.Collection;

public class VehicleService {

    CrudService<Vehicle> vehicleCrudService = CrudFactory.getInstance().getCurrent();

    public void create(Vehicle vehicle) {
        vehicleCrudService.create(vehicle);
    }

    public void delete(String id) {
        vehicleCrudService.delete(id);
    }

    public void update(Vehicle vehicle) {
        vehicleCrudService.update(vehicle);
    }

    public Vehicle read(String id) {
        return vehicleCrudService.read(id);
    }

    public Collection<Vehicle> read() {
        return vehicleCrudService.read();
    }

}
