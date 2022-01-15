package rekord.test;

import java.util.*;

/**
 * Imitate and implement a mini ArrayList
 */
public class RekordArrayList implements java.io.Serializable, Cloneable{
    private static final long serialVersionUID = 8683452581122892188L;

    // Default initial capacity
    private static final int DEFAULT_CAPACITY = 10;

    // Shared empty array instance used for empty instances.
    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData; // non-private to simplify nested class access

    private int size;

    public RekordArrayList(int initialCapacity){
        if (initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
        }else if (initialCapacity == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        }else{
            throw new IllegalArgumentException("Illegal Capacity: "+
                                                initialCapacity);
        }
    }

    // Construct an empty list with an initial capacity of ten.
    public RekordArrayList(){
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public RekordArrayList(Collection c){
        Object[] a = c.toArray();
        if ((size = a.length) != 0){
            if (c.getClass() == ArrayList.class){
                elementData = a;
            }else{
                elementData = Arrays.copyOf(a,size,Object[].class);
            }
        }else{
            // replace with empty array
            elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     * Trims the capacity of this ArrayList instance to be the list's current size.
     * An application can use this operation to minimize the storage of an ArrayList instance.
     */
    public void trimToSize(){

    }

    /**
     * Increases the capacity of this ArrayList instance,if necessary,
     * to ensure that it can hold at least the number of elements specified by the minimum capacity argument.
     * Params:minCapacity - the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity){
        if (minCapacity > elementData.length
            && !(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
                && minCapacity <= DEFAULT_CAPACITY)) {
//            modCount++;
            grow(minCapacity);
        }
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * Increases the capacity to ensure that it can hold at least the number of elements
     * specified by the minimum capacity argument.
     * Params:minCapacity - the desired minimum capacity
     * Throws:OutOfMemoryError - if minCapacity is less than zero
     */
    private Object[] grow(int minCapacity){
        return elementData = Arrays.copyOf(elementData,
                                            newCapacity(minCapacity));
    }

    private Object[] grow(){
        return grow(size+1);
    }

    /**
     * Returns a capacity at least as large as the given minimum capacity.
     * Returns the current capacity increased by 50% if that suffices.
     * Will not return a capacity greater than MAX_ARRAY_SIZE unless the given minimum capacity
     * is greater than MAX_ARRAY_SIZE.
     * Params:minCapacity - the desired minimum capacity
     * Throws:OutOfMemoryError - if minCapacity is less than zero
     */
    private int newCapacity(int minCapacity){
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0){
            if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0)
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }

    private static int hugeCapacity(int minCapacity){
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

    /**
     * Returns the number of elements in this list.
     * Returns:the number of elements in this list
     */
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public boolean contains(Object o){
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o){
        return indexOfRange(o,0,size);
    }

    int indexOfRange(Object o, int start, int end){
        Object[] es = elementData;
        if(o == null) {
            for (int i=start;i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o){
        return lastIndexOfRange(o,0,size);
    }

    int lastIndexOfRange(Object o, int start, int end) {
        Object[] es = elementData;
        if (o == null){
            for (int i = end -1; i >= start; i--){
                if (es[i] == null){
                    return i;
                }
            }
        } else {
            for (int i = end - 1; i >= start; i--) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Object clone(){
        try{
            RekordArrayList v = (RekordArrayList)super.clone();
            v.elementData = Arrays.copyOf(elementData, size);
            return v;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }

        if (!(o instanceof List)) {
            return false;
        }

//        final int expectedModCount = modCount;

        boolean equal = (o.getClass() == RekordArrayList.class)
                ? equalsArrayList((RekordArrayList) o)
                : equalsRange((List) o, 0, size);
//        checkForComodification(expectedModCount);
        return equal;
    }

    boolean equalsRange(List other, int from, int to) {
        final Object[] es = elementData;
        if (to > es.length) {
            throw new ConcurrentModificationException();
        }
        var oit = other.iterator();
        for(; from < to; from++) {
            if (!oit.hasNext() || !Objects.equals(es[from], oit.next())) {
                return false;
            }
        }
        return !oit.hasNext();
    }

    private boolean equalsArrayList(RekordArrayList other) {
//        final int otherModCount = other.modCount;
        final int s = size;
        boolean equal;
        if (equal = (s == other.size)) {
            final Object[] otherEs = other.elementData;
            final Object[] es = elementData;
            if (s > es.length || s > otherEs.length) {
                throw new ConcurrentModificationException();
            }
            for (int i=0; i < s; i++){
                if (!Objects.equals(es[i], otherEs[i])) {
                    equal = false;
                    break;
                }
            }
        }
//        other.checkForComodification(otherModCount);
        return equal;
    }

//    private void checkForComodification(final int expectedModCount){
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//    }
}

















