package org.example;

import javax.swing.*;

import org.example.common.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerManagement extends JFrame {
    private static int count;
    private static boolean isServerWorking = false;
    private static JButton btnStart, btnStop;
    private static JScrollPane jScrollPane;
    private JTextArea logTextArea;

    public ServerManagement() {
        initializeWindow();
        initializeComponents();
        setupListeners();
        layoutComponents();
        setVisible(true);


    }

    public static boolean isIsServerWorking() {
        return isServerWorking;
    }

    private static void setIsServerWorking(boolean isServerWorking) {
        ServerManagement.isServerWorking = isServerWorking;
    }

    private void initializeWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle(Constants.WINDOW_TITLE);
    }

    private void initializeComponents() {
        btnStart = new JButton(Constants.START_BUTTON_TEXT);
        btnStop = new JButton(Constants.STOP_BUTTON_TEXT);
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        logTextArea.setLineWrap(true);
        logTextArea.setWrapStyleWord(true);
        jScrollPane = new JScrollPane(logTextArea);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setPreferredSize(new Dimension(400, 300));
    }

    private void setupListeners() {
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if (isServerWorking) {
                    logTextArea.append(" " + count + ". " + Constants.SERVER_ALREADY_START_MESSAGE + "\n");
                } else {
                    isServerWorking = true;
                    logTextArea.append(" " + count + ". " + Constants.SERVER_START_MESSAGE + "\n");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if (isServerWorking) {
                    isServerWorking = false;
                    logTextArea.append(" " + count + ". " + Constants.SERVER_STOP_MESSAGE + "\n");
                } else {
                    logTextArea.append(" " + count + ". " + Constants.SERVER_ALREADY_STOP_MESSAGE + "\n");
                }
            }
        });
    }

    private void layoutComponents() {
        JPanel panelTop = new JPanel(new GridLayout(1, 2));
        panelTop.add(btnStart);
        panelTop.add(btnStop);
        add(panelTop, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
    }
}
