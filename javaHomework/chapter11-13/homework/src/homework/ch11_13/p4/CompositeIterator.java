package homework.ch11_13.p4;

import java.util.ArrayList;
import java.util.List;

public class CompositeIterator implements ComponentIterator {

    protected List<ComponentIterator> iterators;


    public CompositeIterator(ComponentIterator iterator) {
        iterators = new ArrayList<>();
        iterators.add(iterator);
    }


    @Override
    public boolean hasNext() {
        while (!iterators.isEmpty()) {
            ComponentIterator currentIterator = iterators.get(iterators.size() - 1); // 查看栈顶
            if (currentIterator.hasNext()) {
                return true;
            } else {
                iterators.remove(iterators.size() - 1); // 当前迭代器用完，出栈
            }
        }
        return false;
    }


    @Override
    public Component next() {
        if (!hasNext()) return null;

        ComponentIterator currentIterator = iterators.get(iterators.size() - 1);
        Component component = currentIterator.next();

        if (component instanceof CompositeComponent) {
            ComponentIterator childIterator = component.createIterator();
            iterators.add(childIterator);
        }
        return component;
    }
}
