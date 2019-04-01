package ge.edu.freeuni.oop.seminar8.anonymous;

public class Ingredient {
    private String name;
    private int grams;

    public Ingredient(String name, int grams) {
        this.name = name;
        this.grams = grams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }

    /**
     * Compares this ingredient to the given object (standard override).
     *
     * @return true if ingredient has the same value as the given object
     */
    @Override
    public boolean equals(Object obj) {
        // Note: our argument must be Object, not Ingredient,
        // to match the equals() prototype up in the Object class.

        // Standard equals() tests...
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Ingredient)) {
            return false;
        }

        // Now do deep compare
        Ingredient other = (Ingredient) obj;
        return (grams == other.getGrams() && name.equals(other.getName()));
    }

    /**
     * Returns an int hashcode for this ingredient (standard override).
     *
     * @return int hashcode of ingredient
     */
    @Override
    public int hashCode() {
        // if two objects are deeply the same, their
        // hash codes must be the same
        return (grams + name.length() * 11);
        // could use name.hashCode() instead of name.length()
    }
}
