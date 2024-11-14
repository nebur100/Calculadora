
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Nota Final");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel correctLabel = new JLabel("Cuantos aciertos tienes:");
        correctLabel.setBounds(10, 20, 200, 25);
        panel.add(correctLabel);

        JTextField correctText = new JTextField(20);
        correctText.setBounds(220, 20, 165, 25);
        panel.add(correctText);

        JLabel incorrectLabel = new JLabel("Cuantas incorrectas tienes:");
        incorrectLabel.setBounds(10, 50, 200, 25);
        panel.add(incorrectLabel);

        JTextField incorrectText = new JTextField(20);
        incorrectText.setBounds(220, 50, 165, 25);
        panel.add(incorrectText);

        JButton calculateButton = new JButton("Calcular Nota");
        calculateButton.setBounds(10, 80, 150, 25);
        panel.add(calculateButton);

        JLabel resultLabel = new JLabel("Su nota final es: ");
        resultLabel.setBounds(10, 110, 200, 25);
        panel.add(resultLabel);

        JLabel result = new JLabel("");
        result.setBounds(220, 110, 200, 25);
        panel.add(result);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double aciertos = 0.333;
                    double fallos = 0.111;

                    int preguntasCorrectas = Integer.parseInt(correctText.getText());
                    int preguntasIncorrectas = Integer.parseInt(incorrectText.getText());

                    double notaFinal = (preguntasCorrectas * aciertos) - (preguntasIncorrectas * fallos);
                    result.setText(String.format("%.2f", notaFinal));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Por favor, ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

