import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tela extends JFrame implements ActionListener{
    public tela(){
        setVisible(true);
        setSize(800, 500);
        setTitle("Ajuste de Curvas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);
        setLocationRelativeTo(null);

        //BOTÃO//
        setLayout(null);
        JButton botao = new JButton("Clique Aqui");
        botao.setBounds(100, 200, 250, 70);
        botao.setFont(new Font("Arial", Font.BOLD, 20));
        add(botao);
        botao.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Tudo certo", "Teste", JOptionPane.INFORMATION_MESSAGE);
    }
}
