package assignments.singleton_pattern.ingredients;

public abstract class Ingredient {

    protected String name;

    public Ingredient(){
        name = "Ingredient";
    }

    public String toString(){
        return name;
    }

}
