package com.adidyk;

public interface Store<T extends Base> {

    void setId(String id);
    String getId();

}
