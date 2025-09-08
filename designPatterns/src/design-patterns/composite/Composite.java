package composite;

import java.util.*;

public class Composite implements IComponent {

    String name;
    List<IComponent> component = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public void addComponent(IComponent comp) {
        component.add(comp);
    }

    @Override
    public void showPrice() {
        System.out.println(name);

        for (IComponent c : component) {
            c.showPrice();
        }

    }

}
