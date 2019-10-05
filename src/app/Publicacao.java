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
        livroTop.setIsbn("123123123");
        livroTop.setLargura(1);
        livroTop.setNome("Livro dos machos");
        livroTop.setPaginas(1);
        livroTop.setPeso(12);
        livroTop.setValor(123);
        listaLivrosFisicos.add(livroTop);
        Autor autor = new Autor();
        autor.setNomeAutor("Valesco");
        autor.setEscolaLiteraria("Romantismo");
        autor.setAnoNascimento(1875);
        LivroEletronico livroTop1= new LivroEletronico();
        livroTop1.setAsin("1");
        livroTop1.setAutor(autor);
        livroTop1.setDescricao("abamnkf mkdamdkas0");
        livroTop1.setIsbn("123123123");
        livroTop1.setAudioBook(false);
        livroTop1.setNome("Livro dos homi");
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
        System.exit(0);
    }

    static void textosMenu(){
        System.out.println("//////////");
        System.out.println("    SISTEMA TOP DE CADASTROS DE LIVROS");
        System.out.println(dataBR.format(new Date()));
        System.out.println("1 - Registrar livros");
        System.out.println("2 - Listar livros");
        // System.out.println(" 4- List Authors.");
        // System.out.println(" 5- Readjust book price.");
        System.out.println("6- Sair do programa");
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
                listarLivros();
                certo=true;
                break;
            // case 4:
            //     readjustPrice();
            //     break;
            // case 5:
            //     authorRegistration();
            //     break;
            case 6:
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

    static void listarLivros(){
        System.out.println("//////// Livros fisicos ////////");
        listarLivrosFIsicos();
        System.out.println("//////// Livros eletronicos ////////");
        listarLivrosEletronicos();
        System.out.println();
        if(listaLivrosFisicos.size()>0 || listaLivrosEletronicos.size()>0) livroDetalhe();
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
        System.out.println("Insira o ISBN:");
        livroFisico.setIsbn(scan.next());
        System.out.println("Insira a altura:");
        livroFisico.setAltura(scan.nextDouble());
        System.out.println("Insira a largura:");
        livroFisico.setLargura(scan.nextDouble());
        System.out.println("Insira o peso em kg:");
        livroFisico.setPeso(scan.nextDouble());
        System.out.println("Insira o valor:");
        livroFisico.setValor(scan.nextDouble());
        livroFisico.setAutor(cadastrarAutorLivro());

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
        System.out.println("Insira o ISBN:");
        livroEletronico.setIsbn(scan.next());
        System.out.println("Insira a ASIN:");
        livroEletronico.setAsin(scan.next());
        System.out.println("Insira o tamanho em MB:");
        livroEletronico.setTamanhoMb(scan.nextDouble());
        System.out.println("Possui audio?(Sim(1)/Nao(Qualquer numero))");
        livroEletronico.setAudioBook(scan.nextInt()==1?true:false);
        System.out.println("Insira o valor:");
        livroEletronico.setValor(scan.nextDouble());
        livroEletronico.setAutor(cadastrarAutorLivro());

        listaLivrosEletronicos.add(livroEletronico);
        System.out.println("//////////");
    }

    static Autor cadastrarAutorLivro(){
        Autor autor=new Autor();
        int possuiAutor=0;
        while(possuiAutor!=1 && possuiAutor!=2){
            System.out.println("Possui autor?(Sim(1)/Nao(2))");
            possuiAutor = scan.nextInt();
            if(possuiAutor!=1 && possuiAutor!=2){
                System.out.println("Insira um valor valido!!!");
            }
        }
        if(possuiAutor==1){
            System.out.println("Insira o nome do autor:");
            scan.nextLine();
            autor.setNomeAutor(scan.nextLine());
            System.out.println("Insira a escola literaria do autor:");
            autor.setEscolaLiteraria(scan.nextLine());
            System.out.println("Insira o ano de nascimento:");
            autor.setAnoNascimento(scan.nextInt());
            return autor;
        }
        return null;
    }
}