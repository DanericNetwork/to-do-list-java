package nl.daneric;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ToDoList extends JPanel {
    ArrayList<Object> items = new ArrayList<>();
    private boolean sortedOnName = true;
    public ToDoList() {
        super();
        JLabel label = new JLabel("ToDoList");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(label);
        setVisible(true);
        for (Object item : items) {
            add((Component) item);
        }
    }

    public void addItem(String text) {
        ToDoItem item = new ToDoItem();
        item.setName(text);
        items.add(item);
        add((Component) items.get(items.size() - 1));
        revalidate();
        repaint();
    }

    public void removeSelected() {
        // Use an iterator to safely remove items
        Iterator<Object> iterator = items.iterator();
        while (iterator.hasNext()) {
            Object item = iterator.next();
            if (item instanceof ToDoItem && ((ToDoItem) item).isSelected()) {
                // Remove the item from the collection
                iterator.remove();
                // Remove the item from the container
                remove((Component) item);
            }
        }

        // Revalidate and repaint after the loop
        revalidate();
    }

    public void changeSorting() {
        sortedOnName = !sortedOnName;
        if(sortedOnName) {
            items.sort(Comparator.comparing(o -> ((ToDoItem) o).getName()));
//            System.out.println(items);
        } else {
            items.sort(Comparator.comparing(o -> ((ToDoItem) o).isDone()));
//            reverse the list
            for (int i = 0; i < items.size() / 2; i++) {
                Object temp = items.get(i);
                items.set(i, items.get(items.size() - i - 1));
                items.set(items.size() - i - 1, temp);
            }
//            System.out.println(items);
        }
    }

    public void refreshList() {
        removeAll();
        for (Object item : items) {
            add((Component) item);
        }
        revalidate();
    }
}

