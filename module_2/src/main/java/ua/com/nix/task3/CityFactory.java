package ua.com.nix.task3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class CityFactory {

    private final Map<Integer, City> cityMap;
    private static CityFactory factory;

    private CityFactory() {
        cityMap = new HashMap<>();
    }
    public static CityFactory getInstance() {
        if (factory == null) factory = new CityFactory();
        return factory;
    }

    public void addCity(City city) {
        cityMap.put(city.getIndex(),city);
    }

    public City getCity(Integer index) {
        return cityMap.get(index);
    }

    public City getCityByName(String name) {
        Collection<City> cities =  cityMap.values();
        return cities.stream().filter(city -> city.getName().equals(name)).findFirst().get();

    }
    public int getCount() {
        return cityMap.size();
    }

}
