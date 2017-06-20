package com.adidyk;

public interface Store<T extends Base> {

   void add(T object);
   void set(T oldObject, T newObject);
   void remove(T object);
   Object[] getAll();

}
