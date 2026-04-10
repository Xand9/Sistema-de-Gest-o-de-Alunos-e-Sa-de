package view;

import javax.swing.*;
import dao.AlunoDAO;
import model.Aluno;
import java.awt.Font;

/*
 * Classe TelaPrincipal
 * 
 * Responsável pela interface gráfica do sistema (VIEW).
 * 
 * Aqui o usuário interage com o sistema:
 * - Digita dados
 * - Clica nos botões
 * - Visualiza resultados
 */

public class TelaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;

    // ============================
    // CAMPOS DA INTERFACE
    // ============================

    private JTextField txtNome, txtEndereco, txtTelefone, txtCPF, txtCurso;
    private JTextField txtPeso, txtAltura, txtSangue, txtRH;
    private JTextField txtContatoEmerg, txtFoneEmerg;

    private JLabel lblIMC;

    public TelaPrincipal() {

        setTitle("Sistema de Gestão de Alunos");
        setSize(600, 780);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font titulo = new Font("Arial", Font.BOLD, 14);

        // ============================
        // SEÇÃO: DADOS PESSOAIS
        // ============================

        JLabel sec1 = new JLabel("=== Dados Pessoais ===");
        sec1.setFont(titulo);
        sec1.setBounds(50, 10, 300, 20);
        add(sec1);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(50, 40, 150, 20);
        txtNome = new JTextField();
        txtNome.setBounds(50, 60, 450, 25);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(50, 90, 150, 20);
        txtEndereco = new JTextField();
        txtEndereco.setBounds(50, 110, 450, 25);

        JLabel lblTelefone = new JLabel("Telefone (xx xxxxx-xxxx):");
        lblTelefone.setBounds(50, 140, 200, 20);
        txtTelefone = new JTextField();
        txtTelefone.setBounds(50, 160, 200, 25);

        JLabel lblCPF = new JLabel("CPF (xxx.xxx.xxx-xx):");
        lblCPF.setBounds(270, 140, 200, 20);
        txtCPF = new JTextField();
        txtCPF.setBounds(270, 160, 230, 25);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(50, 190, 150, 20);
        txtCurso = new JTextField();
        txtCurso.setBounds(50, 210, 450, 25);

        // ============================
        // SEÇÃO: SAÚDE
        // ============================

        JLabel sec2 = new JLabel("=== Dados de Saúde ===");
        sec2.setFont(titulo);
        sec2.setBounds(50, 250, 300, 20);
        add(sec2);

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setBounds(50, 280, 100, 20);
        txtPeso = new JTextField();
        txtPeso.setBounds(50, 300, 100, 25);

        JLabel lblAltura = new JLabel("Altura (m):");
        lblAltura.setBounds(170, 280, 100, 20);
        txtAltura = new JTextField();
        txtAltura.setBounds(170, 300, 100, 25);

        JLabel lblSangue = new JLabel("Tipo Sanguíneo:");
        lblSangue.setBounds(290, 280, 120, 20);
        txtSangue = new JTextField();
        txtSangue.setBounds(290, 300, 80, 25);

        JLabel lblRH = new JLabel("RH:");
        lblRH.setBounds(390, 280, 50, 20);
        txtRH = new JTextField();
        txtRH.setBounds(390, 300, 50, 25);

        lblIMC = new JLabel("IMC: ---");
        lblIMC.setBounds(50, 340, 200, 25);

        // ============================
        // SEÇÃO: EMERGÊNCIA
        // ============================

        JLabel sec3 = new JLabel("=== Emergência ===");
        sec3.setFont(titulo);
        sec3.setBounds(50, 380, 300, 20);
        add(sec3);

        JLabel lblContato = new JLabel("Contato:");
        lblContato.setBounds(50, 410, 150, 20);
        txtContatoEmerg = new JTextField();
        txtContatoEmerg.setBounds(50, 430, 250, 25);

        JLabel lblFoneEmerg = new JLabel("Telefone:");
        lblFoneEmerg.setBounds(320, 410, 150, 20);
        txtFoneEmerg = new JTextField();
        txtFoneEmerg.setBounds(320, 430, 180, 25);

        // ============================
        // BOTÕES
        // ============================

        JButton btnCalcular = new JButton("Calcular IMC");
        btnCalcular.setBounds(50, 480, 200, 30);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(270, 480, 200, 30);

        JButton btnListar = new JButton("Listagem");
        btnListar.setBounds(50, 530, 130, 30);

        JButton btnRelatorio = new JButton("Relatório");
        btnRelatorio.setBounds(200, 530, 130, 30);

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(350, 530, 130, 30);

        JButton btnRemover = new JButton("Remover");
        btnRemover.setBounds(50, 580, 430, 30);

        // ============================
        // ADICIONANDO NA TELA
        // ============================

        add(lblNome); add(txtNome);
        add(lblEndereco); add(txtEndereco);
        add(lblTelefone); add(txtTelefone);
        add(lblCPF); add(txtCPF);
        add(lblCurso); add(txtCurso);

        add(lblPeso); add(txtPeso);
        add(lblAltura); add(txtAltura);
        add(lblSangue); add(txtSangue);
        add(lblRH); add(txtRH);
        add(lblIMC);

        add(lblContato); add(txtContatoEmerg);
        add(lblFoneEmerg); add(txtFoneEmerg);

        add(btnCalcular);
        add(btnCadastrar);
        add(btnListar);
        add(btnRelatorio);
        add(btnAlterar);
        add(btnRemover);

        // ============================
        // AÇÕES DOS BOTÕES
        // ============================

        // CALCULAR IMC
        btnCalcular.addActionListener(e -> {
            try {
                double peso = Double.parseDouble(txtPeso.getText());
                double altura = Double.parseDouble(txtAltura.getText());

                double imc = peso / (altura * altura);

                lblIMC.setText("IMC: " + String.format("%.2f", imc));

                // Mensagens obrigatórias do trabalho
                if (imc < 18.5)
                    JOptionPane.showMessageDialog(this, "Você está abaixo do peso ideal");
                else if (imc <= 25)
                    JOptionPane.showMessageDialog(this, "Peso ideal");
                else
                    JOptionPane.showMessageDialog(this, "Você está acima do peso ideal!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Preencha corretamente peso e altura!");
            }
        });

        // CADASTRAR
        btnCadastrar.addActionListener(e -> {
            try {
                Aluno a = capturarDados();
                new AlunoDAO().cadastrar(a);
                limpar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar!");
            }
        });

        // ALTERAR
        btnAlterar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
                Aluno a = capturarDados();
                a.setId(id);
                new AlunoDAO().alterar(a);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao alterar!");
            }
        });

        // REMOVER
        btnRemover.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
                new AlunoDAO().remover(id);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao remover!");
            }
        });

        // LISTAGEM COMPLETA (TODOS OS CAMPOS)
        btnListar.addActionListener(e -> {

            String colunas[] = {
                "ID", "Nome", "Endereço", "Telefone", "CPF",
                "Curso", "Sangue", "Contato Emerg.", "Tel Emerg.",
                "Altura", "Peso", "IMC"
            };

            javax.swing.table.DefaultTableModel modelo =
                    new javax.swing.table.DefaultTableModel(colunas, 0);

            JTable tabela = new JTable(modelo);

            try {

                for (Aluno a : new AlunoDAO().listar()) {

                    modelo.addRow(new Object[]{
                        a.getId(),
                        a.getNome(),
                        a.getEndereco(),
                        a.getTelefone(),
                        a.getCpf(),
                        a.getCurso(),
                        a.getTipoSanguineo() + a.getFatorRh(),
                        a.getContatoEmergencia(),
                        a.getTelefoneEmergencia(),
                        a.getAltura(),
                        a.getPeso(),
                        a.getImc()
                    });
                }

                JOptionPane.showMessageDialog(this, new JScrollPane(tabela));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao listar!");
            }
        });

        // RELATÓRIO
        btnRelatorio.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, new AlunoDAO().relatorio());
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ============================
    // MÉTODOS AUXILIARES
    // ============================

    /*
     * Captura os dados da tela e cria um objeto Aluno
     */
    private Aluno capturarDados() {

        Aluno a = new Aluno();

        a.setNome(txtNome.getText());
        a.setEndereco(txtEndereco.getText());
        a.setTelefone(txtTelefone.getText());
        a.setCpf(txtCPF.getText());
        a.setCurso(txtCurso.getText());
        a.setTipoSanguineo(txtSangue.getText());
        a.setFatorRh(txtRH.getText());
        a.setContatoEmergencia(txtContatoEmerg.getText());
        a.setTelefoneEmergencia(txtFoneEmerg.getText());

        double peso = Double.parseDouble(txtPeso.getText());
        double altura = Double.parseDouble(txtAltura.getText());

        a.setPeso(peso);
        a.setAltura(altura);
        a.setImc(a.calcularIMC());

        return a;
    }

    /*
     * Limpa todos os campos da tela
     */
    private void limpar() {

        txtNome.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtCPF.setText("");
        txtCurso.setText("");
        txtPeso.setText("");
        txtAltura.setText("");
        txtSangue.setText("");
        txtRH.setText("");
        txtContatoEmerg.setText("");
        txtFoneEmerg.setText("");

        lblIMC.setText("IMC: ---");
    }
}