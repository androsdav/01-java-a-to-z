package com.adidyk;

/**
 * Class Block for create static block on the board (object) with params: cell, name.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 02.07.2018.
 * @version 1.0.
 */
class Block extends Heroes {

    /**
     * Block - constructor.
     * @param cell - is position of block (link variable).
     * @param name - is name block.
     */
    Block(Cell cell, String name) {
        super(cell, name);
    }

    /**
     * way - does not do anything.
     * @return - returns positions of block.
     */
    @Override
    public Cell way() {
        return cell();
    }

}