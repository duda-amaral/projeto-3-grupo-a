package main.java.utils;


import main.java.enums.Perfil;
import main.java.enums.StatusClassificacao;
import main.java.enums.StatusEmprestimo;
import main.java.models.Biblioteca;
import main.java.models.Estoque;
import main.java.models.Usuario;
import main.java.models.itens.*;
import main.java.services.UsuarioService;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static main.java.utils.DataUtil.fmt;


/**
 * todo: Coloque aqui, toda a instância para o start do programa
 * Essa classe também tem objetivo de evitar que qualquer mudança de atributo que afete os construtores seja mudado
 * na classe principal (Main)
 */
public class ObjectFactoryUtil {

    public static Biblioteca construirBiblioteca() {
        Estoque estoque = new Estoque();
        Biblioteca biblioteca = new Biblioteca(estoque);
        return biblioteca;
    }

    public static UsuarioService usuarioService(Biblioteca biblioteca) {
        UsuarioService usuarioService = new UsuarioService(biblioteca);
        return usuarioService;
    }

    public static Usuario newUsuario() {
        return new Usuario();
    }


    public static void construirAdm(UsuarioService usuarioService) {
        Usuario usuario = newUsuario();
        usuarioService.setUsuario(usuario);
        try {
            usuarioService.criar("adm", "emailAdm", "senhaAdm", LocalDate.parse("21/10/1988", fmt), Perfil.ADM);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void generateDataBase(Biblioteca biblioteca) {

        Estoque estoque = biblioteca.getEstoque();
        List<Revista> revistas = generateRevistas();
        List<Tese> teses = generateTeses();
        List<CD> cds = generateCDs();
        List<DVD> dvds = generateDVDs();
        List<Livro> livros = generateLivros();

        revistas.forEach(estoque::addItem);
        teses.forEach(estoque::addItem);
        cds.forEach(estoque::addItem);
        dvds.forEach(estoque::addItem);
        livros.forEach(estoque::addItem);

        System.out.println();
    }

    private static List<Livro> generateLivros() {

        List<Livro> livros = new ArrayList<>();
        Object[][] livrosInfo = {
                {"Nossas incriveis serpentes", LocalDate.of(2002, 5, 1), StatusClassificacao.LIVRE, StatusEmprestimo.DISPONIVEL, "Joaozinho", 100, "Editora Brasil", "n.01", "vol.01", "PT-BR", "Ciencia", "Livro sobre serpentes"},
                {"Aracnideos do cerrado", LocalDate.of(2000, 2, 2), StatusClassificacao.MAIOR_DE_16, StatusEmprestimo.DISPONIVEL, "Paulito", 200, "Editora Colombia", "n.11", "vol.01", "PT-BR", "Ciencia", "Livro sobre aracnideos"},
                {"Little principe", LocalDate.of(2000, 2, 2), StatusClassificacao.MAIOR_DE_18, StatusEmprestimo.DISPONIVEL, "Jorge", 300, "Editora EUA", "n.15", "vol.01", "PT-BR", "Ciencia", "Livro sobre principes"}
        };

        Arrays.stream(livrosInfo).toList().forEach(livro -> {
            Livro l = new Livro();
            l.setTitulo((String) livro[0]);
            l.setDataPublicacao((LocalDate) livro[1]);
            l.setStatusClassificacao((StatusClassificacao) livro[2]);
            l.setStatusEmprestimo((StatusEmprestimo) livro[3]);
            l.setAutor((String) livro[4]);
            l.setNumeroPaginas((Integer) livro[5]);
            l.setEditora((String) livro[6]);
            l.setEdicao((String) livro[7]);
            l.setVolume((String) livro[8]);
            l.setIdioma((String) livro[9]);
            l.setGenero((String) livro[10]);
            l.setSinopse((String) livro[11]);
            livros.add(l);
        });

        return livros;
    }

    private static List<CD> generateCDs() {

        List<CD> cds = new ArrayList<>();
        Object[][] dvdInfo = {
                {"Barons of the little step", LocalDate.of(2002, 5, 1), StatusClassificacao.LIVRE, StatusEmprestimo.DISPONIVEL, "Barons of the little step", Duration.ofMinutes(60) , new ArrayList<>(Arrays.asList("Faixa 01", "Faixa 02"))},
                {"Lincoln parque", LocalDate.of(2000, 2, 2), StatusClassificacao.MAIOR_DE_16, StatusEmprestimo.DISPONIVEL, "Lincoln parque", Duration.ofMinutes(30), new ArrayList<>(Arrays.asList("Faixa 01", "Faixa 02"))},
                {"Godjira", LocalDate.of(2000, 2, 2), StatusClassificacao.MAIOR_DE_18, StatusEmprestimo.DISPONIVEL, "Godjira", Duration.ofMinutes(45), new ArrayList<>(Arrays.asList("Faixa 01", "Faixa 02"))}
        };

        Arrays.stream(dvdInfo).toList().forEach(cd -> {
            CD c = new CD();
            c.setTitulo((String) cd[0]);
            c.setDataPublicacao((LocalDate) cd[1]);
            c.setStatusClassificacao((StatusClassificacao) cd[2]);
            c.setStatusEmprestimo((StatusEmprestimo) cd[3]);
            c.setArtista((String) cd[4]);
            c.setDuracao((Duration) cd[5]);
            c.setFaixas((List<String>) cd[6]);
            cds.add(c);
        });

        return cds;
    }

    private static List<DVD> generateDVDs() {

        List<DVD> dvds = new ArrayList<>();
        Object[][] dvdInfo = {
                {"A freira", LocalDate.of(2002, 5, 1), StatusClassificacao.LIVRE, StatusEmprestimo.DISPONIVEL, "Pinoquio", Duration.ofMinutes(60), "PT-BR", "Filme de terror", "Terror"},
                {"Ace ventura", LocalDate.of(2000, 2, 2), StatusClassificacao.MAIOR_DE_16, StatusEmprestimo.DISPONIVEL, "Gepeto", Duration.ofMinutes(30), "PT-BR", "Filme de comedia", "Comedia"},
                {"007", LocalDate.of(2000, 2, 2), StatusClassificacao.MAIOR_DE_18, StatusEmprestimo.DISPONIVEL, "Baleia", Duration.ofMinutes(45), "PT-BR", "Filme de acao e aventura", "Acao e aventura"}
        };

        Arrays.stream(dvdInfo).toList().forEach(dvd -> {
            DVD d = new DVD();
            d.setTitulo((String) dvd[0]);
            d.setDataPublicacao((LocalDate) dvd[1]);
            d.setStatusClassificacao((StatusClassificacao) dvd[2]);
            d.setStatusEmprestimo((StatusEmprestimo) dvd[3]);
            d.setDiretor((String) dvd[4]);
            d.setDuracao((Duration) dvd[5]);
            d.setIdioma((String) dvd[6]);
            d.setSinopse((String) dvd[7]);
            d.setGenero((String) dvd[8]);
            dvds.add(d);
        });

        return dvds;
    }

    private static List<Tese> generateTeses() {

        List<Tese> teses = new ArrayList<>();
        Object[][] teseInfo = {
                {"Tese de mestrado", LocalDate.of(2002, 5, 1), StatusClassificacao.LIVRE, "Juanito Jones", "Pantoro", LocalDate.of(2002, 10, 1), new ArrayList<>(Arrays.asList("Introducao", "Metodologia", "Conclusao"))},
                {"Tese de doutorado", LocalDate.of(2000, 2, 2), StatusClassificacao.MAIOR_DE_16, "Franco columbu", "Treinador misterioso", LocalDate.of(2000, 7, 2), new ArrayList<>(Arrays.asList("Introducao", "Resultados", "Constatacoes"))},
                {"Tese de pos-doutorado", LocalDate.of(2000, 2, 2), StatusClassificacao.MAIOR_DE_18, "Mickey mouse", "Walter", LocalDate.of(2000, 11, 3), new ArrayList<>(Arrays.asList("Introducao", "Resultados", "Constatacoes"))}
        };

        Arrays.stream(teseInfo).toList().forEach(tese -> {
            Tese t = new Tese();
            t.setTitulo((String) tese[0]);
            t.setDataPublicacao((LocalDate) tese[1]);
            t.setStatusClassificacao((StatusClassificacao) tese[2]);
            t.setAutor((String) tese[3]);
            t.setOrientador((String) tese[4]);
            t.setDataDefesa((LocalDate) tese[5]);
            t.setCapitulos((List<String>) tese[6]);
            teses.add(t);
        });

        return teses;
    }

    private static List<Revista> generateRevistas() {

        List<Revista> revistas = new ArrayList<>();
        Object[][] revistaInfo = {
                {"Turma da monica", LocalDate.of(1970, 5, 1), StatusClassificacao.LIVRE, "Editora Abril", "n.01", new ArrayList<>(Arrays.asList("Monica vs Cebolinha", "Cascao contra ataca!", "Chico bento"))},
                {"Jornal", LocalDate.of(2000, 2, 2), StatusClassificacao.MAIOR_DE_16, "Editora Brasil", "n.99", new ArrayList<>(Arrays.asList("Tiroteio no rio", "Transito em sao paulo", "Queijo em minas"))},
                {"Revista 18+", LocalDate.of(2000, 3, 3), StatusClassificacao.MAIOR_DE_18, "Editora Colombia", "n.666", new ArrayList<>(Arrays.asList("Gays", "Mulheres", "Homens", "Outros"))}
        };

        Arrays.stream(revistaInfo).toList().forEach(revista -> {
            Revista r = new Revista();
            r.setTitulo((String) revista[0]);
            r.setDataPublicacao((LocalDate) revista[1]);
            r.setStatusClassificacao((StatusClassificacao) revista[2]);
            r.setEditora((String) revista[3]);
            r.setEdicao((String) revista[4]);
            r.setArtigos((List<String>) revista[5]);
            revistas.add(r);
        });

        return revistas;
    }

}