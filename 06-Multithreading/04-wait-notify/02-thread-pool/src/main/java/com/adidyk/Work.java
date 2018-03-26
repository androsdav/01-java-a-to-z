package com.adidyk;

/** Class Work for create work (object) with params: id, name.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 13.03.2018.
 * @version 1.0.
 */
public class Work {

    /**
     * @param id - work id.
     */
    private final int id;

    /**
     * @param number - work name.
     */
    private final String name;

    /**
     * Work - constructor.
     * @param id - work id.
     * @param name - work name.
     */
    Work(final int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * equals - return boolean result.
     * @param obj - object of class Work.
     * @return - returns boolean result "true" if id of work and name of product is same, and returns "false" - isn`t same.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Work)) {
            return false;
        }
        Work work = (Work) obj;
        return this.id == work.id && this.name.equals(work.name);
    }

    /**
     * hashCode - returns hashCode for work.
     * @return - returns hashCode for work.
     */
    @Override
    public int hashCode() {
        int result = this.id;
        result = 31 * result + this.name.hashCode();
        return result;
    }

    /**
     * toString - returns string format.
     * @return - returns all information for work.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s", "Work{", "id=", this.id, ", name=", this.name, "}");
    }

}