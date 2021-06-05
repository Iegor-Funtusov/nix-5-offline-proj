package ua.com.alevel.entity;


public class RecipeBook {
    private Dessert dessert;
    private Confectioner confectioner;
    private String id;

    public Confectioner getConfectioner() {
        return confectioner;
    }

    public void setConfectioner(Confectioner confectioner) {
        this.confectioner = confectioner;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RecipeBook{" +
                "dessert=" + dessert +
                ", confectioner=" + confectioner +
                ", id='" + id + '\'' +
                "}\n";
    }
}