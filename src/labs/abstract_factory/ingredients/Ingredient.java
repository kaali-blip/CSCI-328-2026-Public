package labs.abstract_factory.ingredients;

public abstract class Ingredient {

    protected String name;

    public Ingredient(){
        name = "Ingredient";
    }

    public String toString(){
        return name;
    }

}
