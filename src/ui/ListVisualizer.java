package ui;

import tda.ArrayList;
import exceptions.NotFoundException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListVisualizer extends JFrame {
    private ArrayList<Integer> list; 
    private JPanel listPanel; // Panel para mostrar los elementos
    private JTextField inputField;

    public ListVisualizer() {
        list = new ArrayList<>();
        
        setTitle("Visualización de Lista");
        setSize(1200, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel que contendrá los elementos como cuadrados
        listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(0, 5, 10, 10)); // Filas dinámicas, 5 columnas, con espacio de 10px entre componentes.
        JScrollPane scrollPane = new JScrollPane(listPanel);

        inputField = new JTextField(10);
        JButton addButton = new JButton("Agregar");
        JButton removeButton = new JButton("Eliminar");
        JButton getByIndexButton = new JButton("Obtener por Indice");
        JButton getByElementButton = new JButton("Obtener por Elemento");

        // Panel inferior con el campo de texto y botones
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(getByIndexButton);
        panel.add(getByElementButton);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // Acción para agregar elementos
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String element = JOptionPane.showInputDialog("Ingrese un número para añadir:");
                if (element != null && !element.isEmpty()) {
                    try {
                        int elementToAdd = Integer.parseInt(element);
                        list.add(elementToAdd);
                        addElementToPanel(elementToAdd, list.size() - 1);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                    }
                }
            }
        });

        // Acción para eliminar elementos mediante cuadro de diálogo
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String indexStr = JOptionPane.showInputDialog("Ingrese el índice a eliminar:");
                if (indexStr != null && !indexStr.isEmpty()) {
                    try {
                        int index = Integer.parseInt(indexStr);
                        if (index >= 0 && index < list.size()) {
                            list.removeByIndex(index); 
                            removeElementFromPanel(index);
                        } else {
                            JOptionPane.showMessageDialog(null, "Índice fuera de rango.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un índice válido.");
                    }
                }
            }
        });

        // Acción para obtener el valor en un índice específico
        getByIndexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String indexStr = JOptionPane.showInputDialog("Ingrese el índice a obtener:");
                if (indexStr != null && !indexStr.isEmpty()) {
                    try {
                        int index = Integer.parseInt(indexStr);
                        if (index >= 0 && index < list.size()) {
                            int element = list.get(index);
                            JOptionPane.showMessageDialog(null, "El valor en el índice " + index + " es: " + element);
                        } else {
                            JOptionPane.showMessageDialog(null, "Índice fuera de rango.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un índice válido.");
                    }
                }
            }
        });

        // Acción para obtener el valor en un índice específico
        getByElementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String elementStr = JOptionPane.showInputDialog("Ingrese el elemento a obtener:");
                if (elementStr != null && !elementStr.isEmpty()) {
                    try {
                        Integer element = Integer.parseInt(elementStr);
                        
                        var data = list.indexOf(element);
                        if(data == -1){
                            throw new NotFoundException("El elemento no esta en la lista");
                        }
                        JOptionPane.showMessageDialog(null, "El elemento " + element + " está en el índice: " + data);
                    
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un índice válido.");
                    } catch (NotFoundException ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
    }

    // Método para añadir un elemento al panel
    private void addElementToPanel(int element, int index) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel indexLabel = new JLabel("Índice: " + index, JLabel.CENTER);
        JLabel elementLabel = new JLabel(String.valueOf(element), JLabel.CENTER);

        panel.add(indexLabel, BorderLayout.NORTH);
        panel.add(elementLabel, BorderLayout.CENTER);

        listPanel.add(panel);
        listPanel.revalidate(); // Refresca el panel para mostrar los nuevos elementos
        listPanel.repaint();
    }

    // Método para eliminar el elemento en un índice específico del panel
    private void removeElementFromPanel(int index) {
        if (index >= 0 && index < listPanel.getComponentCount()) {
            listPanel.remove(index);
            listPanel.revalidate();
            listPanel.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ListVisualizer visualizer = new ListVisualizer();
            visualizer.setVisible(true);
        });
    }
}
