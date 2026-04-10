/*
 * Classe principal do sistema
 * 
 * Essa é a primeira classe que o Java executa quando o programa inicia.
 * 
 * Toda aplicação Java precisa ter um método chamado "main",
 * pois é por ele que o programa começa a rodar.
 */

import view.TelaPrincipal; // Importa a classe da interface gráfica (tela)

public class Main {

    /*
     * Método principal (ponto de entrada do programa)
     * 
     * public → pode ser acessado de qualquer lugar
     * static → não precisa criar objeto para executar
     * void → não retorna nenhum valor
     * main → nome padrão que o Java reconhece
     * String[] args → permite receber parâmetros externos (não usado aqui)
     */
    public static void main(String[] args) {

        /*
         * Aqui estamos criando um objeto da classe TelaPrincipal.
         * 
         * Quando usamos "new TelaPrincipal()", estamos:
         * 
         * 1. Criando a tela do sistema (interface gráfica)
         * 2. Executando o construtor da classe TelaPrincipal
         * 3. Tornando a janela visível para o usuário
         * 
         * Ou seja: é nesse momento que o sistema "abre" na tela.
         */
        new TelaPrincipal();

        /*
         * Resumindo:
         * Essa linha é responsável por iniciar todo o sistema visual.
         */
    }
}