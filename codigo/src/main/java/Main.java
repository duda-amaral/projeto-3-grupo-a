package main.java;

import java.util.NoSuchElementException;
import java.util.Scanner;

import main.java.models.Biblioteca;
import main.java.models.Estoque;
import main.java.services.UsuarioService;
import main.java.utils.InputScannerUtil;
import main.java.views.menus.UsuarioMenu;

public class Main {

    public static void main(String[] args) {

        Estoque estoque = new Estoque();
        Biblioteca biblioteca = new Biblioteca(estoque);
        UsuarioService usuarioService = new UsuarioService(biblioteca);

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Você é usuário ou administrador? (escolha o número abaixo)");
            System.out.println("1 - Usuário");
            System.out.println("2 - Administrador");
            try {
                System.out.print("\nOpção: ");
                int escolha = sc.nextInt();
                switch (escolha) {
                    case 1:
                        UsuarioMenu.usuarioConta(usuarioService);
                    case 2:
                        //AdmMenu.admSistema(biblioteca);
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        InputScannerUtil.close();
                }
            } catch (NoSuchElementException e) {
                System.out.println("Entrada inválida.");
                InputScannerUtil.scanner.nextLine();
            }
        }

    }

}
