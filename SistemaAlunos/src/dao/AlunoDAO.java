package dao;

// Importa a classe de conexão com o banco
import conexao.Conexao;

// Importa o modelo (classe Aluno)
import model.Aluno;

// Importações da API JDBC
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Lista para armazenar vários alunos
import java.util.ArrayList;

// Para exibir mensagens na tela
import javax.swing.JOptionPane;

/*
 * DAO = Data Access Object
 * 
 * Essa classe é responsável por fazer TODA a comunicação com o banco de dados.
 * 
 * Aqui ficam os comandos SQL:
 * - INSERT (Cadastrar)
 * - UPDATE (Alterar)
 * - DELETE (Remover)
 * - SELECT (Buscar/Listar)
 * 
 * Ou seja: essa classe "conversa" com o banco.
 */

public class AlunoDAO {

    /*
     * ============================
     * MÉTODO: CADASTRAR
     * ============================
     * 
     * Insere um novo aluno no banco de dados.
     */
    public void cadastrar(Aluno a) {

        /*
         * Comando SQL com parâmetros (?)
         * 
         * Os "?" são substituídos pelos valores do objeto Aluno.
         * Isso evita SQL Injection (mais segurança).
         */
        String sql = "INSERT INTO aluno (nome, endereco, telefone, cpf, tipo_sanguineo, fator_rh, curso, "
                   + "contato_emergencia, telefone_emergencia, altura, peso, imc) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            // Abre conexão com o banco
            Connection con = Conexao.conectar();

            // Prepara o comando SQL
            PreparedStatement ps = con.prepareStatement(sql);

            // Substituindo os "?" pelos dados do objeto Aluno
            ps.setString(1, a.getNome());
            ps.setString(2, a.getEndereco());
            ps.setString(3, a.getTelefone());
            ps.setString(4, a.getCpf());
            ps.setString(5, a.getTipoSanguineo());
            ps.setString(6, a.getFatorRh());
            ps.setString(7, a.getCurso());
            ps.setString(8, a.getContatoEmergencia());
            ps.setString(9, a.getTelefoneEmergencia());
            ps.setDouble(10, a.getAltura());
            ps.setDouble(11, a.getPeso());
            ps.setDouble(12, a.getImc());

            // Executa o comando no banco
            ps.execute();

            // Fecha conexão (boa prática)
            ps.close();
            con.close();

            // Mensagem de sucesso (exigência do trabalho)
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");

        } catch (Exception e) {

            // Mostra erro no console
            e.printStackTrace();

            // Mensagem para o usuário
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
        }
    }

    /*
     * ============================
     * MÉTODO: ALTERAR
     * ============================
     * 
     * Atualiza os dados de um aluno existente.
     */
    public void alterar(Aluno a) {

        /*
         * Atualiza TODOS os campos baseado no ID
         */
        String sql = "UPDATE aluno SET nome=?, endereco=?, telefone=?, cpf=?, tipo_sanguineo=?, fator_rh=?, "
                   + "curso=?, contato_emergencia=?, telefone_emergencia=?, altura=?, peso=?, imc=? WHERE id=?";

        try {

            Connection con = Conexao.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            // Substituindo os parâmetros
            ps.setString(1, a.getNome());
            ps.setString(2, a.getEndereco());
            ps.setString(3, a.getTelefone());
            ps.setString(4, a.getCpf());
            ps.setString(5, a.getTipoSanguineo());
            ps.setString(6, a.getFatorRh());
            ps.setString(7, a.getCurso());
            ps.setString(8, a.getContatoEmergencia());
            ps.setString(9, a.getTelefoneEmergencia());
            ps.setDouble(10, a.getAltura());
            ps.setDouble(11, a.getPeso());
            ps.setDouble(12, a.getImc());

            // Aqui é o MAIS IMPORTANTE → define qual registro será alterado
            ps.setInt(13, a.getId());

            ps.execute();

            ps.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");

        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar!");
        }
    }

    /*
     * ============================
     * MÉTODO: REMOVER
     * ============================
     * 
     * Remove um aluno pelo ID.
     */
    public void remover(int id) {

        String sql = "DELETE FROM aluno WHERE id=?";

        try {

            Connection con = Conexao.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            // Define qual ID será deletado
            ps.setInt(1, id);

            ps.execute();

            ps.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");

        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao remover!");
        }
    }

    /*
     * ============================
     * MÉTODO: LISTAR
     * ============================
     * 
     * Busca TODOS os alunos do banco.
     */
    public ArrayList<Aluno> listar() {

        // Lista que vai armazenar os alunos
        ArrayList<Aluno> lista = new ArrayList<>();

        String sql = "SELECT * FROM aluno";

        try {

            Connection con = Conexao.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            // Executa SELECT
            ResultSet rs = ps.executeQuery();

            /*
             * Percorre cada linha do resultado
             */
            while (rs.next()) {

                // Cria um objeto Aluno para cada registro
                Aluno a = new Aluno();

                // Preenche os dados vindos do banco
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setEndereco(rs.getString("endereco"));
                a.setTelefone(rs.getString("telefone"));
                a.setCpf(rs.getString("cpf"));
                a.setTipoSanguineo(rs.getString("tipo_sanguineo"));
                a.setFatorRh(rs.getString("fator_rh"));
                a.setCurso(rs.getString("curso"));
                a.setContatoEmergencia(rs.getString("contato_emergencia"));
                a.setTelefoneEmergencia(rs.getString("telefone_emergencia"));
                a.setAltura(rs.getDouble("altura"));
                a.setPeso(rs.getDouble("peso"));
                a.setImc(rs.getDouble("imc"));

                // Adiciona na lista
                lista.add(a);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        // Retorna todos os alunos encontrados
        return lista;
    }

    /*
     * ============================
     * MÉTODO: RELATÓRIO
     * ============================
     * 
     * Gera estatísticas com base nos dados do banco.
     */
    public String relatorio() {

        StringBuilder rel = new StringBuilder();

        try {

            Connection con = Conexao.conectar();

            // ===== MÉDIAS =====
            String sqlMedia = "SELECT AVG(peso), AVG(altura), AVG(imc) FROM aluno";
            ResultSet rsMedia = con.prepareStatement(sqlMedia).executeQuery();

            if (rsMedia.next()) {

                rel.append("=== MÉDIAS ===\n");
                rel.append("Peso médio: " + String.format("%.2f", rsMedia.getDouble(1)) + "\n");
                rel.append("Altura média: " + String.format("%.2f", rsMedia.getDouble(2)) + "\n");
                rel.append("IMC médio: " + String.format("%.2f", rsMedia.getDouble(3)) + "\n\n");
            }

            // ===== MAIOR PESO =====
            String sqlMaiorPeso = "SELECT nome, tipo_sanguineo, fator_rh, peso FROM aluno ORDER BY peso DESC LIMIT 1";
            ResultSet rsMaiorPeso = con.prepareStatement(sqlMaiorPeso).executeQuery();

            if (rsMaiorPeso.next()) {

                rel.append("=== MAIOR PESO ===\n");
                rel.append("Nome: " + rsMaiorPeso.getString(1) + "\n");
                rel.append("Sangue: " + rsMaiorPeso.getString(2) + rsMaiorPeso.getString(3) + "\n");
                rel.append("Peso: " + rsMaiorPeso.getDouble(4) + "\n\n");
            }

            // ===== MENOR PESO =====
            String sqlMenorPeso = "SELECT nome, tipo_sanguineo, fator_rh, peso FROM aluno ORDER BY peso ASC LIMIT 1";
            ResultSet rsMenorPeso = con.prepareStatement(sqlMenorPeso).executeQuery();

            if (rsMenorPeso.next()) {

                rel.append("=== MENOR PESO ===\n");
                rel.append("Nome: " + rsMenorPeso.getString(1) + "\n");
                rel.append("Sangue: " + rsMenorPeso.getString(2) + rsMenorPeso.getString(3) + "\n");
                rel.append("Peso: " + rsMenorPeso.getDouble(4) + "\n\n");
            }

            // ===== MAIOR ALTURA =====
            String sqlMaiorAltura = "SELECT nome, curso, altura FROM aluno ORDER BY altura DESC LIMIT 1";
            ResultSet rsMaiorAltura = con.prepareStatement(sqlMaiorAltura).executeQuery();

            if (rsMaiorAltura.next()) {

                rel.append("=== MAIOR ALTURA ===\n");
                rel.append("Nome: " + rsMaiorAltura.getString(1) + "\n");
                rel.append("Curso: " + rsMaiorAltura.getString(2) + "\n");
                rel.append("Altura: " + rsMaiorAltura.getDouble(3) + "\n\n");
            }

            // ===== MENOR ALTURA =====
            String sqlMenorAltura = "SELECT nome, curso, altura FROM aluno ORDER BY altura ASC LIMIT 1";
            ResultSet rsMenorAltura = con.prepareStatement(sqlMenorAltura).executeQuery();

            if (rsMenorAltura.next()) {

                rel.append("=== MENOR ALTURA ===\n");
                rel.append("Nome: " + rsMenorAltura.getString(1) + "\n");
                rel.append("Curso: " + rsMenorAltura.getString(2) + "\n");
                rel.append("Altura: " + rsMenorAltura.getDouble(3) + "\n\n");
            }

            // ===== MAIOR IMC =====
            String sqlMaiorIMC = "SELECT nome, imc FROM aluno ORDER BY imc DESC LIMIT 1";
            ResultSet rsMaiorIMC = con.prepareStatement(sqlMaiorIMC).executeQuery();

            if (rsMaiorIMC.next()) {

                rel.append("=== MAIOR IMC ===\n");
                rel.append("Nome: " + rsMaiorIMC.getString(1) + "\n");
                rel.append("IMC: " + rsMaiorIMC.getDouble(2) + "\n\n");
            }

            // ===== MENOR IMC =====
            String sqlMenorIMC = "SELECT nome, imc FROM aluno ORDER BY imc ASC LIMIT 1";
            ResultSet rsMenorIMC = con.prepareStatement(sqlMenorIMC).executeQuery();

            if (rsMenorIMC.next()) {

                rel.append("=== MENOR IMC ===\n");
                rel.append("Nome: " + rsMenorIMC.getString(1) + "\n");
                rel.append("IMC: " + rsMenorIMC.getDouble(2) + "\n");
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
            return "Erro ao gerar relatório!";
        }

        /*
         * Retorna todo o relatório pronto em formato de texto
         */
        return rel.toString();
    }
}