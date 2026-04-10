package model;

/*
 * Classe Aluno
 * 
 * Essa classe representa a entidade "Aluno" dentro do sistema.
 * 
 * Em Programação Orientada a Objetos (POO), essa é uma classe do tipo "Model",
 * ou seja, ela representa os dados que serão manipulados e armazenados.
 * 
 * Cada atributo dessa classe corresponde diretamente a uma coluna
 * da tabela "aluno" no banco de dados MySQL.
 * 
 * Essa classe NÃO acessa o banco, ela apenas guarda os dados.
 */

public class Aluno {

    // ============================
    // ATRIBUTOS (VARIÁVEIS DA CLASSE)
    // ============================

    /*
     * ID do aluno
     * 
     * Representa a chave primária da tabela no banco.
     * Esse valor é gerado automaticamente pelo MySQL (AUTO_INCREMENT),
     * ou seja, o Java NÃO precisa definir esse valor ao cadastrar.
     */
    private int id;

    /*
     * Nome completo do aluno
     */
    private String nome;

    /*
     * Endereço do aluno
     */
    private String endereco;

    /*
     * Telefone do aluno
     */
    private String telefone;

    /*
     * CPF do aluno
     */
    private String cpf;

    /*
     * Tipo sanguíneo (A, B, AB ou O)
     */
    private String tipoSanguineo;

    /*
     * Fator RH (+ ou -)
     */
    private String fatorRh;

    /*
     * Curso em que o aluno está matriculado
     */
    private String curso;

    /*
     * Nome da pessoa de contato em caso de emergência
     */
    private String contatoEmergencia;

    /*
     * Telefone do contato de emergência
     */
    private String telefoneEmergencia;

    /*
     * Altura do aluno (em metros)
     * Exemplo: 1.75
     */
    private double altura;

    /*
     * Peso do aluno (em quilogramas)
     * Exemplo: 70.5
     */
    private double peso;

    /*
     * IMC (Índice de Massa Corporal)
     * 
     * Esse valor é calculado automaticamente com base no peso e altura.
     */
    private double imc;

    // ============================
    // MÉTODOS (COMPORTAMENTOS)
    // ============================

    /*
     * Método calcularIMC()
     * 
     * Esse método realiza o cálculo do IMC utilizando a fórmula:
     * 
     * IMC = peso / (altura * altura)
     * 
     * Importante:
     * - Ele NÃO acessa banco de dados
     * - Ele apenas usa os dados que já estão no objeto
     */
    public double calcularIMC() {

        /*
         * Retorna o valor do cálculo diretamente
         */
        return peso / (altura * altura);
    }

    // ============================
    // GETTERS E SETTERS
    // ============================

    /*
     * Esses métodos permitem acessar e modificar os atributos privados.
     * 
     * Isso segue o conceito de ENCAPSULAMENTO da POO,
     * protegendo os dados da classe.
     */

    /*
     * Retorna o ID do aluno
     */
    public int getId() {
        return id;
    }

    /*
     * Define o ID do aluno
     * (usado principalmente em ALTERAR e DELETE)
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
     * Retorna o nome do aluno
     */
    public String getNome() {
        return nome;
    }

    /*
     * Define o nome do aluno
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /*
     * Retorna o endereço do aluno
     */
    public String getEndereco() {
        return endereco;
    }

    /*
     * Define o endereço do aluno
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /*
     * Retorna o telefone do aluno
     */
    public String getTelefone() {
        return telefone;
    }

    /*
     * Define o telefone do aluno
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /*
     * Retorna o CPF do aluno
     */
    public String getCpf() {
        return cpf;
    }

    /*
     * Define o CPF do aluno
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /*
     * Retorna o tipo sanguíneo
     */
    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    /*
     * Define o tipo sanguíneo
     */
    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    /*
     * Retorna o fator RH
     */
    public String getFatorRh() {
        return fatorRh;
    }

    /*
     * Define o fator RH
     */
    public void setFatorRh(String fatorRh) {
        this.fatorRh = fatorRh;
    }

    /*
     * Retorna o curso do aluno
     */
    public String getCurso() {
        return curso;
    }

    /*
     * Define o curso do aluno
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /*
     * Retorna o contato de emergência
     */
    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    /*
     * Define o contato de emergência
     */
    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    /*
     * Retorna o telefone de emergência
     */
    public String getTelefoneEmergencia() {
        return telefoneEmergencia;
    }

    /*
     * Define o telefone de emergência
     */
    public void setTelefoneEmergencia(String telefoneEmergencia) {
        this.telefoneEmergencia = telefoneEmergencia;
    }

    /*
     * Retorna a altura
     */
    public double getAltura() {
        return altura;
    }

    /*
     * Define a altura
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /*
     * Retorna o peso
     */
    public double getPeso() {
        return peso;
    }

    /*
     * Define o peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /*
     * Retorna o IMC
     */
    public double getImc() {
        return imc;
    }

    /*
     * Define o IMC
     * 
     * Normalmente esse valor é definido automaticamente
     * usando o método calcularIMC()
     */
    public void setImc(double imc) {
        this.imc = imc;
    }
}