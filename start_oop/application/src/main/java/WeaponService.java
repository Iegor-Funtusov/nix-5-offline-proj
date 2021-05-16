import java.util.Collection;

public class WeaponService {

    private CrudService<Weapon> weaponCrudService = CrudFactory.getInstance().getCurrent();

    public void create(Weapon weapon) { weaponCrudService.create(weapon); }

    public void delete(String id) { weaponCrudService.delete(id); }

    public void update(Weapon weapon) {
        weaponCrudService.update(weapon);
    }

    public Weapon read(String id) { return weaponCrudService.read(id); }

    public Collection<Weapon> read() {
        return weaponCrudService.read();
    }
}
