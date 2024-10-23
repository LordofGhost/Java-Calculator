package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Interface implements ActionListener {

    // create Objects
    Display display = new Display();
    Logic logic = new Logic();

    static final char[][] symbols = {
            {'⌫', ' ', ' ', '÷'},
            {'7', '8', '9', '×'},
            {'4', '5', '6', '-'},
            {'1', '2', '3', '+'},
            {' ', '0', '.', '='}
    };

    /**
     * @param e is used to get the symbol of the pressed button
     */
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        char symbol = button.getText().charAt(0);

        switch (symbol) {
            case '=':
                display.setResult(logic.getResult(display.getSymbolString()));
                display.clear();
                break;

            case '⌫':
                display.clear();
                display.refresh();
                break;

            case '0','1','2','3','4','5','6','7','8','9':
            case '+', '-', '×', '÷':
            case '.':
                display.createBox(symbol);
                display.refresh();
                break;

            default:
                break;
        }

    }

    // the constructor creates the hole GUI
    public Interface(){
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(400,500));

        // create box with grid layout for buttons
        JPanel buttons = new JPanel(new GridLayout(symbols.length, symbols[0].length, 0, 0));
        // go through the symbols array and print every array in one line
        for (char[] rowSymbol : symbols) {
            for (char symbol : rowSymbol) {
                JButton button = new JButton(Character.toString(symbol));
                button.addActionListener(this);
                buttons.add(button);
            }
        }

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.add(display);
        frame.add(buttons);

        frame.pack();
        frame.setVisible(true);
    }
}