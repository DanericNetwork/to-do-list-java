package nl.daneric;

import javax.swing.*;

public class ToDoWindow  extends JFrame {
    public ToDoWindow() {
        super("ToDo");
        ToDoList itemsList = new ToDoList();
        add(itemsList);
        setSize(150, 0);
        JButton button = new JButton("Add");
        button.addActionListener(e -> {
            String text = JOptionPane.showInputDialog("What do you want to do?");
            if (text != null) {
                ((ToDoList) getContentPane().getComponent(0)).addItem(text);
            }
            pack();
        });
        JButton button2 = new JButton("Remove");
        button2.addActionListener(e -> {
            ((ToDoList) getContentPane().getComponent(0)).removeSelected();
            pack();
        });
        JButton changeSortBtn = new JButton("Sorting");
        changeSortBtn.addActionListener(e -> {
            itemsList.changeSorting();
            itemsList.refreshList();
        });
        add(changeSortBtn);
        add(button2);
        add(button);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        pack(); // resize window to fit contents
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
