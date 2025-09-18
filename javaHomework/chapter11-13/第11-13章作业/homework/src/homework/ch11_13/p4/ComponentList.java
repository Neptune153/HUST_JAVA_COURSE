package homework.ch11_13.p4;

import java.util.ArrayList;

public class ComponentList extends ArrayList<Component> implements ComponentIterator{
    private int position = 0;

    public ComponentList(){
        super();
    }
    @Override
    public boolean hasNext(){
        return position < this.size();
    }

    @Override
    public Component next(){
        if (!hasNext()) {
            return null;
        }
        return this.get(position++);
    }

    public ComponentIterator createIterator(){
        return this;
    }
}
