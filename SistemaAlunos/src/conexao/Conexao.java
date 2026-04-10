package conexao;

// Importação das classes necessárias da API JDBC
import java.sql.Connection;      // Representa uma conexão com o banco
import java.sql.DriverManager;   // Gerencia os drivers e cria conexões

/*
 * Classe Conexao
 * 
 * Essa classe é responsável por estabelecer a comunicação entre
 * o sistema Java e o banco de dados MySQL.
 * 
 * Ela utiliza a API JDBC (Java Database Connectivity),
 * que é a tecnologia padrão do Java para acesso a banco de dados.
 */

public class Conexao {

    /*
     * Método conectar()
     * 
     * Esse método cria e retorna uma conexão com o banco de dados.
     * 
     * static → permite chamar o método sem precisar instanciar a classe
     * Exemplo: Conexao.conectar();
     */
    public static Connection conectar() {

        try {

            /*
             * URL de conexão com o banco de dados
             * 
             * jdbc:mysql:// → define que estamos usando MySQL
             * localhost → servidor local (seu próprio computador)
             * 3306 → porta padrão do MySQL
             * sistema_alunos → nome do banco de dados criado
             */
            String url = "jdbc:mysql://localhost:3306/sistema_alunos";

            /*
             * Credenciais de acesso ao banco
             * 
             * usuario → geralmente "root" no MySQL local
             * senha → a senha definida no seu MySQL
             */
            String usuario = "root";
            String senha = "Root";

            /*
             * DriverManager:
             * 
             * Classe responsável por gerenciar os drivers JDBC
             * e criar conexões com o banco.
             * 
             * getConnection(...) → tenta abrir a conexão com os dados fornecidos
             */
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            /*
             * Se chegou até aqui, significa que a conexão foi realizada com sucesso
             */
            System.out.println("Conexão realizada com sucesso!");

            /*
             * Retorna o objeto Connection para ser usado em outras classes,
             * como o DAO (onde executamos SQL)
             */
            return conexao;

        } catch (Exception e) {

            /*
             * Caso ocorra erro:
             * - Banco desligado
             * - Senha incorreta
             * - Nome do banco errado
             * - Driver não configurado
             * 
             * Esse bloco captura o erro e mostra no console
             */
            System.out.println("Erro ao conectar no banco!");

            /*
             * printStackTrace() mostra detalhes do erro,
             * ajudando na depuração (debug)
             */
            e.printStackTrace();

            /*
             * Retorna null indicando que a conexão falhou
             */
            return null;
        }
    }
}