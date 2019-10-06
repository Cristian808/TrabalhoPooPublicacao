package app;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import app.autor.Autor;
import app.livro.LivroEletronico;
import app.livro.LivroFisico;

public class Publicacao {
    static Locale localeBR = new Locale("pt", "BR");
    static DateFormat dataBR = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, localeBR);
    static NumberFormat real = NumberFormat.getCurrencyInstance(localeBR);
    static ArrayList<LivroFisico> listaLivrosFisicos = new ArrayList<>();
    static ArrayList<LivroEletronico> listaLivrosEletronicos = new ArrayList<>();
        
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        LivroFisico livroTop= new LivroFisico();
        livroTop.setAltura(1);
        livroTop.setAutor(null);
        livroTop.setDescricao("abamnkf mkdamdkas0");
        livroTop.setIsbnDez(1234567891);
        livroTop.setLargura(1);
        livroTop.setNome("Livro fisico top");
        livroTop.setPaginas(1);
        livroTop.setPeso(12);
        livroTop.setValor(123);
        listaLivrosFisicos.add(livroTop);
        Autor autor = new Autor();
        autor.setNomeAutor("Valesco");
        autor.setEscolaLiteraria("Romantismo");
        autor.setAnoNascimento(1875);
        LivroEletronico livroTop1= new LivroEletronico();
        livroTop1.setAutor(autor);
        livroTop1.setDescricao("abamnkf mkdamdkas0");
        livroTop1.setIsbnTreze(Long.parseLong("1236549874563"));
        livroTop1.setAudioBook(false);
        livroTop1.setNome("Livro eletronico top");
        livroTop1.setPaginas(1);
        livroTop1.setTamanhoMb(12);
        livroTop1.setValor(123);
        listaLivrosEletronicos.add(livroTop1);
        menu();
    }

    static void menu(){
        boolean mostrarMenu=true;
        while(mostrarMenu){
            textosMenu();
            escolhasMenu();
            System.out.println("Para voltar ao menu digite 1");
            System.out.println("Para sair digite qualquer numero");
            mostrarMenu= scan.nextInt()==1 ? true : false;
        }
        scan.close();
        System.exit(0);
    }

    static void textosMenu(){
        System.out.println("//////////");
        System.out.println("    SISTEMA TOP DE CADASTROS DE LIVROS");
        System.out.println(dataBR.format(new Date()));
        System.out.println("1 - Registrar livros");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Reajustar valor livro");
        System.out.println("4 - Sair do programa");
        System.out.println("//////////");
    }

    static void escolhasMenu(){
        boolean certo=false;
        int escolha=0;
        while(!certo){
            escolha=scan.nextInt();
        switch (escolha){
            case 1:
                registrarLivros();
                certo=true;
                break;
            case 2: 
                listarLivrosComDetalhes();
                certo=true;
                break;
            case 3:
                reajusteValor();
                certo=true;
                break;
            case 4:
                scan.close();
                System.exit(0);
                break;
            default:
                certo=false;
                System.err.println("Insira um numero valido!!!");
                break;
            }
        }
        System.out.println();
    }

    static void reajusteValor(){
        int lista=0;
        int indiceLivro;
        while ((lista != 1 || (lista == 1 && listaLivrosFisicos.size() == 0))
                && (lista != 2 || (lista == 2 && listaLivrosEletronicos.size() == 0))) {
            System.out.println(
                    "Deseja reajustar o valor do livro de qual lista?(Livros fisicos(1) Livros Eletronicos(2))");
            listarLivros();
            lista = scan.nextInt();
            if ((lista != 1 || (lista == 1 && listaLivrosFisicos.size() == 0))
                    && (lista != 2 || (lista == 2 && listaLivrosEletronicos.size() == 0))) {
                System.out.println("Insira um numero valido!!!");
            }
        }
        if(lista==1){
            for(boolean valido=false; valido==false;){
                System.out.println("Insira o indice do livro");
                indiceLivro=scan.nextInt();
                if(indiceLivro-1<listaLivrosFisicos.size()){
                    valido=true;
                    reajustarLivroFisico(listaLivrosFisicos.get(indiceLivro-1));
                }
            }
        }else if(lista==2){
            for(boolean valido=false; valido==false;){
                System.out.println("Insira o indice do livro");
                indiceLivro=scan.nextInt();
                if(indiceLivro-1<listaLivrosEletronicos.size()){
                    valido=true;
                    reajustarLivroEletronico(listaLivrosEletronicos.get(indiceLivro-1));
                }
            }
        }
    }

    static void reajustarLivroFisico(LivroFisico livro){
        System.out.println("Insira o valor de reajuste:");
        double reajuste=Double.parseDouble(scan.next());
        if(livro.ajustarValor(reajuste)){
            System.out.println("Reajustado!");
        }else{
            System.out.println("Reajuste maior que 30% negado!");
        }
    }

    static void reajustarLivroEletronico(LivroEletronico livro){
        System.out.println("Insira o valor de reajuste:");
        double reajuste=Double.parseDouble(scan.next());
        if(livro.ajustarValor(reajuste)){
            System.out.println("Reajustado!");
        }else{
            System.out.println("Reajuste maior que 30% negado!");
        }
    }

    static void registrarLivros(){
        int tipoLivro=0;
        while(tipoLivro!=1 && tipoLivro!=2){
            System.out.println("Qual tipo de livro deseja cadastrar ?");
            System.out.println("Livro Fisico(1)");
            System.out.println("Livro Eletronico(2)");
            tipoLivro = scan.nextInt();
            if(tipoLivro!=1 && tipoLivro!=2){
                System.out.println("Insira um numero valido!!!");
            }
        }
        System.out.println("Quantos livros deseja cadastrar?");
        int quantidade = scan.nextInt();

        if(tipoLivro==1){
            for(int c=0; c < quantidade; c++){
                cadastrarLivroFisico();
            }
        }
        else{
            for(int c=0; c < quantidade; c++){
                cadastrarLivroEletronico();
            }
        }
    }

    static void listarLivrosComDetalhes(){
        listarLivros();
        if(listaLivrosFisicos.size()>0 || listaLivrosEletronicos.size()>0) livroDetalhe();
    }

    static void listarLivros(){
        System.out.println("//////// Livros fisicos ////////");
        listarLivrosFIsicos();
        System.out.println("//////// Livros eletronicos ////////");
        listarLivrosEletronicos();
        System.out.println();
    }

    

    static void cadastrarLivroFisico(){
        LivroFisico livroFisico = new LivroFisico();
        
        System.out.println("Insira o nome do livro:");
        scan.nextLine();
        livroFisico.setNome(scan.nextLine());
        System.out.println("Insira a quantidade de paginas:");
        livroFisico.setPaginas(scan.nextInt());
        System.out.println("Insira a descricao:");
        scan.nextLine();
        livroFisico.setDescricao(scan.nextLine());
        System.out.println("Insira o ISBN (Caso nao possua digite 0):");
        String isbn= scan.next();
        if(isbn.length()==10){
            livroFisico.setIsbnDez(Long.parseLong(isbn));
            livroFisico.setIsbnTreze(0);

        }
        else if(isbn.length()==13){
            livroFisico.setIsbnDez(0);
            livroFisico.setIsbnTreze(Long.parseLong(isbn));
        }else{
            livroFisico.setIsbnDez(0);
            livroFisico.setIsbnTreze(0);
        }
        System.out.println("Insira a altura:");
        livroFisico.setAltura(Double.parseDouble(scan.next()));
        System.out.println("Insira a largura:");
        livroFisico.setLargura(Double.parseDouble(scan.next()));
        System.out.println("Insira o peso em kg:");
        livroFisico.setPeso(Double.parseDouble(scan.next()));
        System.out.println("Insira o valor:");
        livroFisico.setValor(Double.parseDouble(scan.next()));
        livroFisico.setAutor(possuiAutor());

        listaLivrosFisicos.add(livroFisico);
        System.out.println("//////////");
    }

    static void livroDetalhe() {
        boolean certo = false;
        boolean detalhe = true;
        System.out.println("Deseja ver os detalhes de algum livro?(Sim(1) Nao(Qualquer numero))");
        if (scan.nextInt() == 1) {
            while (detalhe) {
                System.out.println("Qual tipo de livro deseja ver o detalhe?");
                System.out.println((listaLivrosFisicos.size() > 0 ? "1 - Fisico" : "")
                        + (listaLivrosEletronicos.size() > 0 ? "\n2 - Eletronico" : ""));
                while (certo == false) {
                    int tipo = scan.nextInt();
                    if (tipo == 1) {
                        if (listaLivrosFisicos.size() > 0) {
                            livroFisicoDetalhe();
                            certo = true;
                        } else {
                            System.out.println("Insira um numero valido!!!");
                            certo = false;
                        }
                    } else if (tipo == 2) {
                        if (listaLivrosEletronicos.size() > 0) {
                            livroEletronicoDetalhe();
                            certo = true;
                        } else {
                            System.out.println("Insira um numero valido!!!");
                            certo = false;
                        }
                    } else {
                        certo = false;
                        System.out.println("Insira um numero valido!!!");
                    }
                }
                System.out.println("Deseja ver detalhes de mais livros?(Sim(1) Nao(Qualquer numero))");
                if (scan.nextInt() != 1) {
                    detalhe = false;
                }
                certo = false;
            }
        }
    }

    static void livroFisicoDetalhe(){
        boolean numeroValido=false;
        boolean outroLivro=true;
        int numeroLivro;
        while(outroLivro){
            while(numeroValido==false){
                System.out.println("Qual livro da lista deseja ver o detalhe?");
                numeroLivro=scan.nextInt();
                if(numeroLivro<=listaLivrosFisicos.size()){
                    listaLivrosFisicos.get(numeroLivro-1).mostrarInformacoesLivroFisico(real);
                    System.out.println();
                    numeroValido=true;
                }else if(numeroLivro>listaLivrosFisicos.size()){
                    System.out.println("Insira um numero valido!!!");
                    numeroValido=false;
                }
            }
            System.out.println("Deseja ver o detalhe de mais algum livro fisico?(Sim(1) Nao(Qualquer Numero))");
            if(scan.nextInt()!=1){
                outroLivro=false;
            }
            numeroValido=false;
        }
    }
    
    static void livroEletronicoDetalhe(){
        boolean numeroValido=false;
        boolean outroLivro=true;
        int numeroLivro;
        while(outroLivro){
            while(numeroValido==false){
                System.out.println("Qual livro da lista deseja ver o detalhe?");
                numeroLivro=scan.nextInt();
                if(numeroLivro<=listaLivrosEletronicos.size()){
                    listaLivrosEletronicos.get(numeroLivro-1).mostrarInformacoesLivroEletronico(real);
                    System.out.println();
                    numeroValido=true;
                }else{
                    System.out.println("Insira um numero valido!!!");
                    numeroValido=false;
                }
            }
            System.out.println("Deseja ver o detalhe de mais algum livro eletronico?(Sim(1) Nao(Qualquer Numero))");
            if(scan.nextInt()!=1){
                outroLivro=false;
            }
            numeroValido=false;
        }
    }

    static void listarLivrosFIsicos() {
        if(listaLivrosFisicos.size()>0){
            for (int c = 0; c < listaLivrosFisicos.size(); c++) {
                System.out.println(c + 1 + " - " + listaLivrosFisicos.get(c).getNome());
            }
        }else{
            System.out.println("Nao ha livros fisico cadastrados");
        }
    }

    static void listarLivrosEletronicos() {
        if(listaLivrosEletronicos.size()>0){
            for (int c = 0; c < listaLivrosEletronicos.size(); c++) {
                System.out.println(c + 1 + " - " + listaLivrosEletronicos.get(c).getNome());
            }
        }else{
            System.out.println("Nao ha livros eletronicos cadastrados");
        }
    }

    static void cadastrarLivroEletronico(){
        LivroEletronico livroEletronico = new LivroEletronico();

        System.out.println("Insira o nome do livro:");
        scan.nextLine();
        livroEletronico.setNome(scan.nextLine());
        System.out.println("Insira a quantidade de paginas:");
        livroEletronico.setPaginas(scan.nextInt());
        System.out.println("Insira a descricao:");
        scan.nextLine();
        livroEletronico.setDescricao(scan.nextLine());
        System.out.println("Insira o ISBN (Caso nao possua digite 0):");
        String isbn= scan.next();
        if(isbn.length()==10){
            livroEletronico.setIsbnDez(Long.parseLong(isbn));
            livroEletronico.setIsbnTreze(0);

        }
        else if(isbn.length()==13){
            livroEletronico.setIsbnDez(0);
            livroEletronico.setIsbnTreze(Long.parseLong(isbn));
        }else{
            livroEletronico.setIsbnDez(0);
            livroEletronico.setIsbnTreze(0);
        }
        System.out.println("Insira o tamanho em MB:");
        livroEletronico.setTamanhoMb(Double.parseDouble(scan.next()));
        System.out.println("Possui audio?(Sim(1)/Nao(Qualquer numero))");
        livroEletronico.setAudioBook(scan.nextInt()==1?true:false);
        System.out.println("Insira o valor:");
        livroEletronico.setValor(Double.parseDouble(scan.next()));
        livroEletronico.setAutor(possuiAutor());

        listaLivrosEletronicos.add(livroEletronico);
        System.out.println("//////////");
    }

    static Autor possuiAutor(){
        int possuiAutor=0;
        while(possuiAutor!=1 && possuiAutor!=2){
            System.out.println("Possui autor?(Sim(1)/Nao(2))");
            possuiAutor = scan.nextInt();
            if(possuiAutor!=1 && possuiAutor!=2){
                System.out.println("Insira um valor valido!!!");
            }
        }
        if(possuiAutor==1){
            return(cadastrarAutorLivro());
        }
        return null;
    }

    static Autor cadastrarAutorLivro(){
        Autor autor=new Autor();
        System.out.println("Insira o nome do autor:");
        scan.nextLine();
        autor.setNomeAutor(scan.nextLine());
        System.out.println("Insira a escola literaria do autor:");
        autor.setEscolaLiteraria(scan.nextLine());
        System.out.println("Insira o ano de nascimento:");
        autor.setAnoNascimento(scan.nextInt());
        return autor;
    }
}