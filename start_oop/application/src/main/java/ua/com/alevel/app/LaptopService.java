
import ua.com.alevel.app.Laptop;
import ua.com.alevel.lib.CrudFactory;
import ua.com.alevel.lib.CrudService;
import java.util.Collection;

public class LaptopService {
    CrudService<Laptop> laptopCrudService = CrudFactory.getInstance().getCurrent();

    public void create(Laptop laptop) {
        laptopCrudService.create(laptop);
    }

    public void delete(String id) {
        laptopCrudService.delete(id);
    }

    public void update(Laptop laptop) {
        laptopCrudService.update(laptop);
    }

    public Laptop read(String id) {
        return laptopCrudService.read(id);
    }

    public Collection<Laptop> read() {
        return laptopCrudService.read();
    }

}
