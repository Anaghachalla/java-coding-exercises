package org.exercises.collections;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.*;

@Getter
@Setter
public class ListsDemo<T> {
    private List<T> arrayList;
    private List<T> vector;
    private List<T> linkedList;

    public ListsDemo() {
        arrayList = new ArrayList<>();
        vector = new Vector<>();
        linkedList = new LinkedList<>();
    }

    public ListsDemo(Collection<T> list) {
        arrayList = new ArrayList<>(list);
        vector = new Vector<>(list);
        linkedList = new LinkedList<>(list);
    }

    public void addElement(T value, Class<?> type) {
        if (type == ArrayList.class) {
            arrayList.add(value);
        }
        if (type == Vector.class) {
            vector.add(value);
        }
        if (type == LinkedList.class) {
            linkedList.add(value);
        }
    }

    public void removeElement(T value, Class<?> type) {
        if (type == ArrayList.class) {
            arrayList.remove(value);
        }
        if (type == Vector.class) {
            vector.remove(value);
        }
        if (type == LinkedList.class) {
            linkedList.remove(value);
        }
    }

    public void setElement(T value, int pos, Class<?> type) {
        if (type == ArrayList.class) {
            arrayList.set(pos, value);
        }
        if (type == Vector.class) {
            vector.set(pos, value);
        }
        if (type == LinkedList.class) {
            linkedList.set(pos, value);
        }
    }

    public void addAllElements(Collection<T> list, Class<?> type) {
        if (type == ArrayList.class) {
            arrayList.addAll(list);
        }
        if (type == Vector.class) {
            vector.addAll(list);
        }
        if (type == LinkedList.class) {
            linkedList.addAll(list);
        }
    }

    //more methods - indexOf, lastIndexOf, subList - for all 3

    public Iterator<T> getIterator(Class<?> type) {
        if (type == ArrayList.class) {
            return arrayList.iterator();
        }
        if (type == Vector.class) {
            return vector.iterator();
        }
        if (type == LinkedList.class) {
            return linkedList.iterator();
        }
        return null;
    }

    public ListIterator<T> getListIterator(Class<?> type) {
        if (type == ArrayList.class) {
            return arrayList.listIterator();
        }
        if (type == Vector.class) {
            return vector.listIterator();
        }
        if (type == LinkedList.class) {
            return linkedList.listIterator();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public T[] getArray(Class<?> type, Class<T> elementType) {

        if (type == ArrayList.class) {
            return arrayList.toArray(size ->
                    (T[]) Array.newInstance(elementType, size));
        }
        if (type == Vector.class) {
            //the lambda works because of this - list.toArray(Integer[]::new);
            return vector.toArray(size ->
                    (T[]) Array.newInstance(elementType, size));
        }
        if (type == LinkedList.class) {
            //return linkedList.toArray((T[]) new Object[0]); -> this would not work
            return linkedList.toArray(size ->
                    (T[]) Array.newInstance(elementType, size));
        }
        //in case generics are not used, people do list.toArray(new Integer[0]); -> can set the size to 0
        return null;
    }

    


}
