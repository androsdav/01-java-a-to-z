package com.adidyk;

/** Class StartUi for create jar file and run program (Producer-Consumer).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 13.03.2018.
 * @version 1.0.
 */
public class Work {

    /**
     * @param number - is.
     */
    private final int id;

    /**
     * @param number - is.
     */
    private final String name;

    /**
     *
     * @param id - is id.
     * @param name - is id.
     */
    Work(final int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @param o - is.
     * @return - is.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Work)) {
            return false;
        }
        Work work = (Work) o;
        if (id != work.id) {
            return false;
        }
        return name.equals(work.name);
    }

    /**
     *
     * @return - is.
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format(" %s%s%s%s%s%s", "Work{", "id=", this.id, ", name=", this.name, "}");
    }
}