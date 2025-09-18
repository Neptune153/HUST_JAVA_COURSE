package homework.p1;

/*
 1. 上述代码存在什么问题？请分析存在问题的原因。

Integer 类型的对象不能直接强制转换为 String 类型的对象，从而会抛出 ClassCastException
当迭代器遍历到整数元素（10）时，这种强制类型转换就会失败
 */



/**
 * 迭代器接口，用于遍历组件树里的每一个组件. 注意这不是java.util.Iterator接口
 */
interface Iterator<T> {
    /**
     *  是否还有元素
     * @return 如果元素还没有迭代完，返回true;否则返回false
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     * @return  下一个元素
     */
    T next();
}


/**
 * 数组迭代器
 */
class  ArrayIterator<T> implements Iterator<T>{
    private int pos = 0;
    private T[] a = null;

    public ArrayIterator(T[] array){
        a = array;
    }

    @Override
    public boolean hasNext() {
        return !(pos >= a.length);
    }

    @Override
    public T next() {
        if(hasNext()){
            T c = a[pos];
            pos ++;
            return c;
        }
        else
            return null;
    }
}


/**
 * 容器类，内部用Object[]保存元素
 */
class Container<T> {
    private T[] elements;
    private int elementsCount = 0;
    private int size = 0;

    public Container(int size){
        elements = (T[])new Object[size];
        this.size = size;
    }

    public boolean add(T e){
        if(elementsCount < size){
            elements[elementsCount ++] = e;
            return true;
        }
        else{
            return  false;
        }
    }

    /**
     * 返回容器的迭代器
     * @return
     */
    public Iterator<T> iterator(){
        return new ArrayIterator<>(elements);
    }
}

public class Test{
    public static void main(String[] args){
        Container<Object> container = new Container(6);
        container.add("12");
        container.add("34");
        container.add("56");
        container.add("78");
        container.add("9");
        container.add(10);
        Iterator<Object> it = container.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj.toString());
        }
    }
}
