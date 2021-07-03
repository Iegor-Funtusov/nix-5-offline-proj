package ua.com.nix.task3;

public final class FindMinPathBetweenTwoNodes {

    public static int findPah(int source, int end){
        CityFactory factory = CityFactory.getInstance();
        SearchMinPath.computePaths(factory.getCity(source));
        return factory.getCity(end).getMinPath();
    }

}
