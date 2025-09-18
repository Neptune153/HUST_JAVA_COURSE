package homework.ch11_13.p4;

public class CompositeComponent extends Component{
    protected ComponentList children;

    public CompositeComponent(){
        super();
        children = new ComponentList();
    }

    public CompositeComponent(int id, String name, double price) {
        super(id, name, price);
        children = new ComponentList();
    }

    @Override
    public void add(Component component) throws UnsupportedOperationException{
        if(!children.contains(component)){
            children.add(component);
        }
    }

    @Override
    public void remove(Component component) throws UnsupportedOperationException{
        children.remove(component);
    }

    @Override
    public double calcPrice() {
        double sum =0;
        for(Component component : children){
            sum+=component.getPrice();
        }
        this.price = sum;
        return sum;
    }


    @Override
    public ComponentIterator createIterator() {
        return new CompositeIterator(children.createIterator());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()); // 调用父类的 toString() 方法

        // 如果有子组件，递归调用toString打印子组件信息
        if (children != null && !children.isEmpty()) {
            sb.append(" [");
            for (Component child : children) {
                sb.append(child.toString()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()); // 删除最后的逗号和空格
            sb.append("]");
        }

        return sb.toString();
    }
}
