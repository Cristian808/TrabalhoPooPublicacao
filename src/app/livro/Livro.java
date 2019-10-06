package app.livro;

import java.text.NumberFormat;

import app.autor.Autor;

public abstract class Livro {

    private String nome, descricao;
    private double valor;
    private int paginas;
    private long isbnDez;
    private long isbnTreze;

    private Autor autor = new Autor();

    public void mostrarInformacoesLivro(NumberFormat moeda){
        System.out.println("Nome: "+this.nome);
        System.out.println("Descrição: "+this.descricao);
        System.out.println("Valor: "+moeda.format(this.valor));
        if(this.isbnDez!=0){
            System.out.println("ISBN-10: "+this.isbnDez);
        }
        if(this.isbnTreze!=0){
            System.out.println("ISBN-13: "+this.isbnTreze);
        }
        System.out.println("Paginas: "+this.paginas);
        
        if(verificaAutor(this.autor) == true){
            this.autor.mostrarInformacoesAutor();
        }else{
            System.out.println("Não há autor cadastrado");
        }
    }
    
    public boolean verificaAutor(Autor autor){
        if(autor==null){
            return false;
        }
        return true;
    }

    public boolean ajustarValor(double reajuste){
        if(reajuste > 0.3){
            return false;
        }
        else{
            setValor(this.valor+=this.valor * reajuste);
            return true;
        }
    }

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

    public long getIsbnDez() {
		return this.isbnDez;
	}

    public void setIsbnDez(long isbnDez) {
		this.isbnDez = isbnDez;
	}

    public long getIsbnTreze() {
        return this.isbnTreze;
    }

    public void setIsbnTreze(long isbnTreze) {
        this.isbnTreze = isbnTreze;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}