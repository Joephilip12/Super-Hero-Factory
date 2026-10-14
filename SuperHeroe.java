import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperHeroe extends JFrame {

    private final JTextField campoNombre = new JTextField(15);
    private final JLabel resultado = new JLabel("Escribe tu super poder.");

    public SuperHeroe() {
        super("Lava carros 3000");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. Crear el contenedor y elegir su layout.
        JPanel panel = new JPanel(new GridLayout(0, 1, 8, 8));

        // Espacio entre el borde del panel y los componentes.
        panel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // 2. Crear un botón.
        JButton botonSaludar = new JButton("Obtener tu nombre de superheroe");

        // 3. Definir qué sucede cuando se presiona.
        botonSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtenemos el texto y quitamos espacios al inicio y final
                String texto = campoNombre.getText().trim();

                if (texto.isEmpty()) {
                    resultado.setText("Primero escribe tu super poder, jaja.");
                    return;
                }

                // --- NUEVA LÓGICA PARA QUITAR LA 'R' ---

                // 1. Dividir el texto en palabras usando los espacios
                // "\\s+" asegura que funcione incluso si escriben varios espacios seguidos
                String[] palabras = texto.split("\\s+");

                // 2. Tomar la primera palabra (index 0)
                String primeraPalabra = palabras[0];

                // 3. Verificar si termina en 'r' o 'R'
                if (primeraPalabra.toLowerCase().endsWith("r")) {
                    // 4. Remover la última letra usando substring y length()
                    primeraPalabra = primeraPalabra.substring(0, primeraPalabra.length() - 1);

                    // Actualizamos la primera palabra en nuestro arreglo original
                    palabras[0] = primeraPalabra;
                }

                // 5. Reconstruir el texto uniendo las palabras de nuevo con espacios
                String poderModificado = String.join("", palabras);

                // Mostrar el resultado final
                resultado.setText(poderModificado + "-man! Ese es tu nuevo nombre de superheroe jaja");
            }
        });

        // 4. Incorporar los componentes al panel.
        panel.add(new JLabel("Tu superpower:"));
        panel.add(campoNombre);
        panel.add(botonSaludar);
        panel.add(resultado);

        // 5. Incorporar el panel a la ventana.
        setContentPane(panel);

        // 6. Ajustar el tamaño y centrar.
        setSize(600, 300); // 600 píxeles de ancho por 300 de alto
        setLocationRelativeTo(null); // apareciendo centrada
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SuperHeroe ventana = new SuperHeroe();
                ventana.setVisible(true);
            }
        });
    }
}
