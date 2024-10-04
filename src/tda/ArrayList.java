package tda;

import abstractions.*;
import helpers.ArrayUtils;

public class ArrayList<T> implements IList<T> {
    private T[] data;
    private int elementCount;
    private int MAX_CAPACITY = 20;
    private int RESIZE_DEFAULT = 100;

    /**
     * Empty list with max capacity set to <i><b>MAX_CAPCITY<b/><i/>
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        data = (T[]) new Object[MAX_CAPACITY];
        elementCount = 0;
    }

    /**
     * Empty list with max capacity set to <i><b>size<b/><i/>
     * @param size initial size of list
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int size){
        data = (T[]) new Object[size];
        MAX_CAPACITY = size;
    }
    
    /**
     * Constructor with initial data
     * @param _data initial data
     */
    public ArrayList(T[] _data){
        elementCount = ArrayUtils.realArrayLength(_data);
        data = _data;
        MAX_CAPACITY = _data.length;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int indexOf(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public void add(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void insert(T element, int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public T removeByIndex(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeByIndex'");
    }

    @Override
    public T removeByElement(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeByElement'");
    }

}
