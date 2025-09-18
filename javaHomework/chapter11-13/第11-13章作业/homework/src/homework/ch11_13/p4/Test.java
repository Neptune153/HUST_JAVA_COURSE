package homework.ch11_13.p4;

public class Test {
    public static void main(String[] args) {
        Component computer = ComponentFactory.create();

        System.out.println(computer);

        System.out.println("id: " + computer.getId() + ", name: " +
                computer.getName() + ", price: " + computer.getPrice());
        System.out.println("sub-component of "+computer.getName()+":");

        ComponentIterator it = computer.createIterator();
        while (it.hasNext()) {

            Component c = it.next();
            System.out.println("id: " + c.getId() + ", name: " +
                    c.getName() + ", price: " + c.getPrice());
            if(c instanceof CompositeComponent) {
                System.out.println("sub-component of "+c.getName()+":");
            }
        }
    }
}
