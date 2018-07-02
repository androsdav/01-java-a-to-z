package com.adidyk;

/**
 * Class Block for create bomber-man (object) with params: cell, name.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 02.07.2018.
 * @version 1.0.
 */
public class Block extends Heroes {

    /**
     * BomberMan - constructor.
     * @param cell - is start position of hero (link variable).
     * @param name - is name hero.
     */
    Block(Cell cell, String name) {
        super(cell, name);
    }

    /**
     * way - randomly selects direction of travel (up, right, down, left) and
     * returns new cell for bomber-man.
     * @return - returns new cell for bomber-man.
     */
    @Override
    public Cell way() {
        return null;
    }

}
