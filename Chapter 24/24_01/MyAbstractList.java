/*
 * Author: Kaden Payne
 * Date: 9/14/2020
 * 
 * An abstract list that implement methods from MyList
 */

/**
 *
 * @author kjpay
 * @param <E>
 */
public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0;
    
    //Constructor
    protected MyAbstractList() {
        
    }
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }
    
    //Adding, removing, and checking List
    @Override
    public void add(E e) {
        add(size, e);
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        else {
            return false;
        }
    }
    
    //Adding all, removing all, and retaining all from another list
    @Override
    public boolean addAll(MyList<E> otherList) {
        if (otherList.size() > 0) {
            for (int i = 0; i < otherList.size(); i++) {
                add(otherList.get(i));
            }
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean removeAll(MyList<E> otherList) {
        boolean changed = false;
        for (int i = 0; i < otherList.size(); i++) {
            if (remove(otherList.get(i))) {
                changed = true;
            }
        }
        return changed;
    }
    @Override
    public boolean retainAll(MyList<E> otherList) {
        boolean changed = false;
        for (int i = 0; i < this.size(); ) {
            if (!otherList.contains(this.get(i))) {
                this.remove(get(i));
                changed = true;
            }
            else {
                i++;
            }
        }
        return changed;
    }
}
