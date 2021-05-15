package ua.com.alevel.app;

import ua.com.alevel.lib.CrudService;
import ua.com.alevel.lib.CrudFactory;

import java.util.Collection;

public class BusDriverService {

    CrudService<BusDriver> driverCrudProcess = CrudFactory.getInstance().getCrudProcess();

    public void create(BusDriver busDriver) {
        driverCrudProcess.create(busDriver);
    }

    public void update(BusDriver busDriver) {
        driverCrudProcess.update(busDriver);
    }

    public void delete(String id) {
        driverCrudProcess.delete(id);
    }

    public Collection<BusDriver> read() {
        return driverCrudProcess.read();
    }

    public BusDriver read(String id) {
        return driverCrudProcess.read(id);
    }

}
