package app.livro;

import java.text.NumberFormat;

public class LivroFisico extends Livro {
    private double altura, largura, peso;

    public void mostrarInformacoesLivroFisico(NumberFormat moeda){
        mostrarInformacoesLivro(moeda);
    	System.out.println("Altura: " +this.altura);
        System.out.println("Largura: " +this.largura);
        System.out.println("Peso: " +this.peso+" Kg");
        
    }
    
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
}