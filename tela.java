import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Screen extends JFrame implements ActionListener {

    public Screen() {
        try {
            //Configuração do tema
            UIManager.put("nimbusBase", new Color(136, 168, 218));
            UIManager.put("nimbusBlueGrey", new Color(119, 165, 227));
            UIManager.put("control", new Color(119, 165, 227));
            UIManager.put("text", new Color(35, 27, 37, 252));
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //Configurações da janela
        setVisible(true);
        setSize(500, 500);
        getContentPane().setBackground(new Color(187, 198, 218));
        setTitle("Ajuste de Curvas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Configuração do Botão
        setLayout(null);
        JButton botao = new JButton("SELECIONAR");
        botao.setBounds(110, 200, 250, 70);
        botao.setFont(new Font("Arial", Font.BOLD, 20));
        add(botao);
        botao.addActionListener(this);

        //Configuração do Texto acima do Botão
        JLabel labelTexto = new JLabel("Clique no botão para selecionar o arquivo '.txt'");
        labelTexto.setBounds(67, 150, 400, 30);
        labelTexto.setFont(new Font("Arial", Font.BOLD, 14));
        add(labelTexto);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setTitle("Ajuste de Curvas");
        if (e.getActionCommand().equals("SELECIONAR")) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de Texto (.txt)", "txt"));

            int result = fileChooser.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Faça o que quiser com cada linha do arquivo
                        System.out.println(line);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
