package examples.builder;

public class Pizza {
  private String size;
  private boolean cheese;
  private boolean pepperoni;
  private boolean bacon;

  private Pizza(Builder builder) {
    size = builder.size;
    cheese = builder.cheese;
    pepperoni = builder.pepperoni;
    bacon = builder.bacon;
  }

  public String toString(){
    StringBuffer pizzaString = new StringBuffer("This is a ");
    pizzaString.append(size + " ");
    pizzaString.append("pizza with: ");

    pizzaString.append((cheese) ? "\n - cheese" : "");
    pizzaString.append((pepperoni) ? "\n - pepperoni" : "");
    pizzaString.append((bacon) ? "\n - bacon" : "");

    return pizzaString.toString();
  }

  public static class Builder {
    //required
    private final String size;

    //optional
    private boolean cheese = false;
    private boolean pepperoni = false;
    private boolean bacon = false;

    public Builder(String size) {
      this.size = size;
    }

    public Builder cheese(boolean value) {
      cheese = value;
      return this;
    }

    public Builder pepperoni(boolean value) {
      pepperoni = value;
      return this;
    }

    public Builder bacon(boolean value) {
      bacon = value;
      return this;
    }

    public Pizza build() {
      return new Pizza(this);
    }
  }
}
