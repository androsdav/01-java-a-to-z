package com.adidyk;

public interface Store<T extends Base> {

   void add(T object);
   void add(int index, T object);
   void set(int index, T object);
   void remove(T object);
   void remove(int index);
   T get(int index);
   Object[] getAll();
   int size();

}
