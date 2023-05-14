package cn.llynsyw.design.pattern.exp.composition;

import java.util.*;

public class Group extends Component {
    private String name;
    private ArrayList<Component> components = new ArrayList<>();


    public Group(String name) {
        this.name = name;
    }

    @Override
    public void share(Component component) {
        ArrayList<Component> queue = new ArrayList<>();
        addToQueue(queue, getComponents());
        while (!queue.isEmpty()) {
            Component comp = queue.remove(0);
            if (comp instanceof Group) {
                Group group = (Group) comp;
                addToQueue(queue, group.getComponents());
            } else {
                if (comp != component)
                    component.share(comp);
            }
        }

    }

    public void addToQueue(ArrayList<Component> array1, ArrayList<Component> array2) {
        array1.addAll(array2);
    }

    public ArrayList<Component> getComponents() {
        return this.components;
    }

    public void add(Component component) {
        // TODO: implement
        if (!components.contains(component)) {
            components.add(component);
        }
    }

    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public String toString() {
        return name;
    }
}