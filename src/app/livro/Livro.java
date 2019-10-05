package app.livro;

import java.text.NumberFormat;

import app.autor.Autor;

public abstract class Livro {

    private String nome, descricao, isbn;
    private double valor;
    private int paginas;
    private Autor autor = new Autor();

    public void mostrarInformacoesLivro(NumberFormat moeda){
        System.out.println("Nome: "+this.nome);
        System.out.println("Descrição: "+this.descricao);
        System.out.println("Valor: "+moeda.format(this.valor));
        System.out.println("ISBN: "+this.isbn);
        System.out.println("Paginas: "+this.paginas);
        
        if(verificaAutor(this.autor) == true){
            this.autor.mostrarInformacoesAutor();
        }else{
            System.out.println("Não há autores");
        }
        
    }
    
    public boolean verificaAutor(Autor autor){
        if(autor==null){
            return false;
        }
        return true;
    }

    // public void ajustarValor(double reajuste){
    //     if(reajuste > 0.3){
    //         System.out.println("Reajuste nao permitido");
    //     }
    //     else{
    //         setValor(this.valor * reajuste);
    //     }
    // }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return this.paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}