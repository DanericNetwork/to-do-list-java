package nl.daneric;

import javax.swing.*;
import java.awt.*;

public class ToDoItem extends JPanel {
    private boolean done = false;
    private String text;
    public ToDoItem() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(new Checkbox());
        add(new JLabel("Not done"));
        JButton doneBtn = new JButton("Change State");
        doneBtn.addActionListener(e -> {
            changeState();
        });
        add(doneBtn);
        JButton editBtn = new JButton("Edit");
        editBtn.addActionListener(e -> {
            String text = JOptionPane.showInputDialog("What do you want to do?");
            if (text != null) {
                setName(text);
            }
        });
        add(editBtn);
    }

    public void setName(String text) {
        this.text = text;
        ((Checkbox) getComponent(0)).setLabel(text);
    }

    public String getName() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    public void changeState() {
        this.done = !done;
        if(done) {
            ((JLabel) getComponent(1)).setText("Done");
        } else {
            ((JLabel) getComponent(1)).setText("Not Done");
        }
    }

    public boolean isSelected() {
        return ((Checkbox) getComponent(0)).getState();
    }
}
