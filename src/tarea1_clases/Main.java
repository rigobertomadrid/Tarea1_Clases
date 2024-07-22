package tarea1_clases;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    private Transito transito;

    public Main(){
        transito=new Transito();
        createUI();
    }

    private void createUI(){
        JFrame frame = new JFrame("Sistema de Multas de Transito");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        Font font = new Font("Arial", Font.PLAIN, 14);
        
        JLabel codigoLabel = new JLabel("Codigo:");
        codigoLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(codigoLabel, gbc);

        JTextField codigoField = new JTextField(10);
        codigoField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(codigoField, gbc);

        JLabel nombreLabel = new JLabel("Nombre del Infractor:");
        nombreLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(nombreLabel, gbc);

        JTextField nombreField = new JTextField(10);
        nombreField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(nombreField, gbc);

        JLabel tipoLabel = new JLabel("Tipo de Multa:");
        tipoLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(tipoLabel, gbc);

        JTextField tipoField = new JTextField(10);
        tipoField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(tipoField, gbc);

        JLabel codigoBuscarLabel = new JLabel("Codigo a Buscar:");
        codigoBuscarLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(codigoBuscarLabel, gbc);

        JTextField codigoBuscarField = new JTextField(10);
        codigoBuscarField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(codigoBuscarField, gbc);

        JButton agregarButton = new JButton("Agregar Multa");
        setupButton(agregarButton, font, Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(agregarButton, gbc);

        JButton pagarButton = new JButton("Pagar Multa");
        setupButton(pagarButton, font, Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(pagarButton, gbc);

        JButton imprimirButton = new JButton("Imprimir Multas");
        setupButton(imprimirButton, font, Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(imprimirButton, gbc);

        JButton estadisticasButton = new JButton("Imprimir Estadisticas");
        setupButton(estadisticasButton, font, Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(estadisticasButton, gbc);

        JButton salirButton = new JButton("Salir");
        setupButton(salirButton, font, Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(salirButton, gbc);

        agregarButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    int codigo = Integer.parseInt(codigoField.getText());
                    String nombre = nombreField.getText();
                    String tipo = tipoField.getText();
                    transito.agregarMulta(codigo, nombre, tipo);
                    limpiarCampos(codigoField, nombreField, tipoField);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "El codigo debe ser un numero entero.");
                }
            }
        });

        pagarButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    int codigo = Integer.parseInt(codigoBuscarField.getText());
                    transito.pagarMulta(codigo);
                    limpiarCampos(codigoBuscarField);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "El codigo debe ser un numero entero.");
                }
            }
        });

        imprimirButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                transito.imprimirMultas();
            }
        });

        estadisticasButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                transito.imprimirEstadisticas();
            }
        });

        salirButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void setupButton(JButton button, Font font, Color color){
        button.setFont(font);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    private void limpiarCampos(JTextField... campos){
        for (JTextField campo:campos){
            campo.setText("");
        }
    }

    public static void main(String[] args){
        new Main();
    }
}
