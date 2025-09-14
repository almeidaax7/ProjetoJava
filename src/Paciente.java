public class Paciente {
    private static int contadorId = 1; // contador estático
    private int id;
    private String nome;
    private int idade;
    private String sintoma;

    public Paciente(String nome, int idade, String sintoma) {
        this.id = contadorId++;
        this.nome = nome;
        this.idade = idade;
        this.sintoma = sintoma;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getSintoma() { return sintoma; }
    public void setSintoma(String sintoma) { this.sintoma = sintoma; }

    // Método personalizado para exibir informações
    public String exibirInfo() {
        return "ID: " + id + " | Nome: " + nome + " | Idade: " + idade + " | Sintoma: " + sintoma;
    }
}
