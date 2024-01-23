import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Screen extends JFrame implements ActionListener {

    private JFrame novaInterface; // Adicionado atributo para a nova interface

    public Screen() {
        try {
            // Configuração do tema
            UIManager.put("nimbusBase", new Color(136, 168, 218));
            UIManager.put("nimbusBlueGrey", new Color(119, 165, 227));
            UIManager.put("control", new Color(119, 165, 227));
            UIManager.put("text", new Color(35, 27, 37, 252));
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Configurações da janela inicial
        setVisible(true);
        setSize(500, 500);
        getContentPane().setBackground(new Color(187, 198, 218));
        setTitle("Ajuste de Curvas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configuração do Botão
        setLayout(null);
        JButton botao = new JButton("SELECIONAR");
        botao.setBounds(110, 200, 250, 70);
        botao.setFont(new Font("Arial", Font.BOLD, 20));
        add(botao);
        botao.addActionListener(this);

        // Configuração do Texto acima do Botão
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

                // Fecha a janela inicial
                dispose();

                // Cria a nova interface e passa a referência da tela inicial
                novaInterface = new NovaInterface(selectedFile, this);
            }
        }
    }

    

    public static void main(String[] args) {
        new Screen();
    }
}

class NovaInterface extends JFrame {

    private Screen telaInicial; // Adicionado atributo para a tela inicial

    public NovaInterface(File selectedFile, Screen telaInicial) {
        this.telaInicial = telaInicial;

        // Configurações da nova janela
        setVisible(true);
        setSize(800, 700);
        getContentPane().setBackground(new Color(187, 198, 218));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Adiciona a barra 1 em destaque
        JPanel barraSuperior1 = new JPanel();
        barraSuperior1.setBackground(new Color(187, 198, 218)); // Cor de fundo da barra igual à cor da interface
        barraSuperior1.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN)); // Borda verde na parte superior
        barraSuperior1.setLayout(null); // Define o layout como null
        barraSuperior1.setBounds(40, 20, 700, 70); // Posiciona a barra na parte superior
        add(barraSuperior1);
        
        // Adiciona a barra 2 em destaque
        JPanel barraSuperior2 = new JPanel();
        barraSuperior2.setBackground(new Color(187, 198, 218)); // Cor de fundo da barra igual à cor da interface
        barraSuperior2.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN)); // Borda verde na parte superior
        barraSuperior2.setLayout(null); // Define o layout como null
        barraSuperior2.setBounds(40, 100, 700, 70); // Posiciona a barra na parte superior
        add(barraSuperior2);

        // Adiciona a barra 3 em destaque
        JPanel barraSuperior3 = new JPanel();
        barraSuperior3.setBackground(new Color(187, 198, 218)); // Cor de fundo da barra igual à cor da interface
        barraSuperior3.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN)); // Borda verde na parte superior
        barraSuperior3.setLayout(null); // Define o layout como null
        barraSuperior3.setBounds(40, 180, 700, 70); // Posiciona a barra na parte superior
        add(barraSuperior3);

        // Adiciona a barra 4 em destaque
        JPanel barraSuperior4 = new JPanel();
        barraSuperior4.setBackground(new Color(187, 198, 218)); // Cor de fundo da barra igual à cor da interface
        barraSuperior4.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN)); // Borda verde na parte superior
        barraSuperior4.setLayout(null); // Define o layout como null
        barraSuperior4.setBounds(40, 260, 700, 70); // Posiciona a barra na parte superior
        add(barraSuperior4);

        // Adiciona a barra 5 em destaque
        JPanel barraSuperior5 = new JPanel();
        barraSuperior5.setBackground(new Color(187, 198, 218)); // Cor de fundo da barra igual à cor da interface
        barraSuperior5.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN)); // Borda verde na parte superior
        barraSuperior5.setLayout(null); // Define o layout como null
        barraSuperior5.setBounds(40, 340, 700, 70); // Posiciona a barra na parte superior
        add(barraSuperior5);

        // Adiciona a barra 6 em destaque
        JPanel barraSuperior6 = new JPanel();
        barraSuperior6.setBackground(new Color(187, 198, 218)); // Cor de fundo da barra igual à cor da interface
        barraSuperior6.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN)); // Borda verde na parte superior
        barraSuperior6.setLayout(null); // Define o layout como null
        barraSuperior6.setBounds(40, 420, 700, 70); // Posiciona a barra na parte superior
        add(barraSuperior6);

        // Adiciona a barra 7 em destaque
        JPanel barraSuperior7 = new JPanel();
        barraSuperior7.setBackground(new Color(187, 198, 218)); // Cor de fundo da barra igual à cor da interface
        barraSuperior7.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN)); // Borda verde na parte superior
        barraSuperior7.setLayout(null); // Define o layout como null
        barraSuperior7.setBounds(40, 500, 700, 70); // Posiciona a barra na parte superior
        add(barraSuperior7);


        // Adicione aqui os componentes da nova interface ou faça o que for necessário
        // ...

        // Exemplo de leitura do arquivo selecionado
        try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Faça o que quiser com cada linha do arquivo na nova interface
                System.out.println(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Adiciona botão de voltar
        setLayout(null);
        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(680, 610, 90, 40);
        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 12));
        add(botaoVoltar);

        // Adiciona ação para o botão de voltar
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fecha a nova interface
                dispose();

                // Reabre a tela inicial
                telaInicial.setVisible(true);
            }
        });
    }
}
