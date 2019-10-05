package app.autor;

public class Autor {
    private String nomeAutor,escolaLiteraria;
    private int anoNascimento;
    
    public void mostrarInformacoesAutor(){
    	System.out.println("Nome do autor: " +this.nomeAutor);
        System.out.println("Escola literaria: " +this.escolaLiteraria);
        System.out.println("Ano nascimento: " +this.anoNascimento);
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getEscolaLiteraria() {
        return escolaLiteraria;
    }

    public void setEscolaLiteraria(String escolaLiteraria) {
        this.escolaLiteraria = escolaLiteraria;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
}
