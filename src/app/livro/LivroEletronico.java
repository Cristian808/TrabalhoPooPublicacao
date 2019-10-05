package app.livro;

import java.text.NumberFormat;

public class LivroEletronico extends Livro {
    private double tamanhoMb;
    private boolean audioBook;
    private String asin;

    public void mostrarInformacoesLivroEletronico(NumberFormat moeda){
        mostrarInformacoesLivro(moeda);
        System.out.println("Tamanho em Mb: " +this.tamanhoMb);
        System.out.println("Asin: " +this.asin);
        System.out.println("Possui audio: " +((this.audioBook) ? "Sim":"Não"));
        
    }
    
    public double getTamanhoMb() {
        return tamanhoMb;
    }

    public void setTamanhoMb(double tamanhoMb) {
        this.tamanhoMb = tamanhoMb;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public boolean isAudioBook() {
        return audioBook;
    }

    public void setAudioBook(boolean audioBook) {
        this.audioBook = audioBook;
    }
}