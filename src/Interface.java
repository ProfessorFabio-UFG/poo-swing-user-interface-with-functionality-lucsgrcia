import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame {
    private JTextField campoCodigo, campoNome;
    private JRadioButton rbFeminino, rbMasculino;
    private JTextArea areaCV;
    private JComboBox<String> comboInteresse, comboAtuacao;

    public Interface() {
        super("Ficha de Avaliação");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenu menuEditar = new JMenu("Editar");

        JMenu menuEnviar = new JMenu("Enviar");
        JMenuItem itemEmail = new JMenuItem("email");
        JMenuItem itemImpressora = new JMenuItem("impressora");
        menuEnviar.add(itemEmail);
        menuEnviar.add(itemImpressora);

        JMenuItem itemSalvar = new JMenuItem("Salvar");
        JMenuItem itemSair = new JMenuItem("Sair");

        menuArquivo.add(menuEnviar);
        menuArquivo.add(itemSalvar);
        menuArquivo.add(itemSair);

        menuBar.add(menuArquivo);
        menuBar.add(menuEditar);
        setJMenuBar(menuBar);

        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel titulo = new JLabel("Ficha de Avaliação", JLabel.CENTER);
        titulo.setForeground(Color.RED);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelPrincipal.add(titulo, gbc);

        JPanel painelDados = new JPanel(new GridBagLayout());
        painelDados.setBorder(BorderFactory.createTitledBorder("Dados Pessoais"));
        GridBagConstraints gbcDados = new GridBagConstraints();
        gbcDados.insets = new Insets(4, 4, 4, 4);
        gbcDados.fill = GridBagConstraints.HORIZONTAL;

        campoCodigo = new JTextField(15);
        campoNome = new JTextField(15);
        rbFeminino = new JRadioButton("Feminino");
        rbMasculino = new JRadioButton("Masculino");
        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(rbFeminino);
        grupoSexo.add(rbMasculino);

        gbcDados.gridx = 0; gbcDados.gridy = 0;
        painelDados.add(new JLabel("Código:"), gbcDados);
        gbcDados.gridx = 1;
        painelDados.add(campoCodigo, gbcDados);

        gbcDados.gridx = 0; gbcDados.gridy = 1;
        painelDados.add(new JLabel("Nome:"), gbcDados);
        gbcDados.gridx = 1;
        painelDados.add(campoNome, gbcDados);

        gbcDados.gridx = 0; gbcDados.gridy = 2;
        painelDados.add(new JLabel("Sexo:"), gbcDados);
        gbcDados.gridx = 1;
        JPanel painelSexo = new JPanel();
        painelSexo.add(rbFeminino);
        painelSexo.add(rbMasculino);
        painelDados.add(painelSexo, gbcDados);

        gbc.gridy = 1;
        painelPrincipal.add(painelDados, gbc);

        areaCV = new JTextArea(5, 30);
        JScrollPane scrollCV = new JScrollPane(areaCV);
        JPanel painelCV = new JPanel(new BorderLayout());
        painelCV.setBorder(BorderFactory.createTitledBorder("Curriculum Vitae"));
        painelCV.add(scrollCV, BorderLayout.CENTER);

        gbc.gridy = 2;
        painelPrincipal.add(painelCV, gbc);

        comboInteresse = new JComboBox<>(new String[]{"Desenvolvedor", "Analista", "Designer"});
        comboInteresse.setForeground(Color.RED);

        comboAtuacao = new JComboBox<>(new String[]{"Programação", "Testes", "Banco de Dados"});
        comboAtuacao.setForeground(Color.BLUE);

        JPanel painelAreas = new JPanel(new GridBagLayout());
        painelAreas.setBorder(BorderFactory.createTitledBorder("Áreas"));
        GridBagConstraints gbcAreas = new GridBagConstraints();
        gbcAreas.insets = new Insets(4, 4, 4, 4);
        gbcAreas.fill = GridBagConstraints.HORIZONTAL;

        gbcAreas.gridx = 0; gbcAreas.gridy = 0;
        painelAreas.add(new JLabel("Interesse:"), gbcAreas);
        gbcAreas.gridx = 1;
        painelAreas.add(comboInteresse, gbcAreas);
        gbcAreas.gridx = 2;
        painelAreas.add(new JLabel("Atuação:"), gbcAreas);
        gbcAreas.gridx = 3;
        painelAreas.add(comboAtuacao, gbcAreas);

        gbc.gridy = 3;
        painelPrincipal.add(painelAreas, gbc);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(Color.GREEN);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnAnterior = new JButton("Anterior");
        JButton btnProximo = new JButton("Proximo");
        JButton btnNovo = new JButton("Novo");
        JButton btnCancelar = new JButton("Cancelar");

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnAnterior);
        painelBotoes.add(btnProximo);
        painelBotoes.add(btnNovo);
        painelBotoes.add(btnCancelar);

        add(painelPrincipal, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        ActionListener salvarAction = e -> {
            String codigo = campoCodigo.getText();
            String nome = campoNome.getText();
            String sexo = rbFeminino.isSelected() ? "Feminino" : rbMasculino.isSelected() ? "Masculino" : "Não informado";
            String interesse = (String) comboInteresse.getSelectedItem();
            String atuacao = (String) comboAtuacao.getSelectedItem();
            String cv = areaCV.getText();

            JOptionPane.showMessageDialog(this,
                    "Código: " + codigo + "\nNome: " + nome + "\nSexo: " + sexo +
                            "\nInteresse: " + interesse + "\nAtuação: " + atuacao +
                            "\nCV: " + cv,
                    "Dados Salvos", JOptionPane.INFORMATION_MESSAGE);
        };

        btnSalvar.addActionListener(salvarAction);
        itemSalvar.addActionListener(salvarAction);

        btnNovo.addActionListener(e -> limparCampos());

        itemSair.addActionListener(e -> System.exit(0));
        btnCancelar.addActionListener(e -> System.exit(0));

        itemEmail.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Enviando por e-mail...", "Enviar", JOptionPane.INFORMATION_MESSAGE));
        itemImpressora.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Enviando para a impressora...", "Enviar", JOptionPane.INFORMATION_MESSAGE));

        btnAnterior.addActionListener(e -> JOptionPane.showMessageDialog(this, "Registro anterior..."));
        btnProximo.addActionListener(e -> JOptionPane.showMessageDialog(this, "Próximo registro..."));
    }

    private void limparCampos() {
        campoCodigo.setText("");
        campoNome.setText("");
        areaCV.setText("");
        comboInteresse.setSelectedIndex(0);
        comboAtuacao.setSelectedIndex(0);
        rbFeminino.setSelected(false);
        rbMasculino.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interface frame = new Interface();
            frame.setVisible(true);
        });
    }
}
