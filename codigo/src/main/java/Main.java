package main.java;

import java.util.NoSuchElementException;
import main.java.models.Biblioteca;
import main.java.services.UsuarioService;
import main.java.utils.InputScannerUtil;
import main.java.utils.ObjectFactoryUtil;
import main.java.views.menus.AdmMenu;
import main.java.views.menus.UsuarioMenu;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = ObjectFactoryUtil.construirBiblioteca();
        UsuarioService usuarioService = ObjectFactoryUtil.usuarioService(biblioteca);
        ObjectFactoryUtil.construirAdm(usuarioService);

        //...
        //todo: Outras chamadas de métodos do tipo void do ObjectFactorUtil para popular o programa
        //...

        while(true) {
            System.out.println("Você é usuário ou administrador? (escolha o número abaixo)");
            System.out.println("1 - Usuário");
            System.out.println("2 - Administrador");
            try {
                System.out.print("\nOpção: ");
                int escolha = InputScannerUtil.scanner.nextInt();
                switch (escolha) {
                    case 1:
                        UsuarioMenu.menuPrincipal(usuarioService);
                        break;
                    case 2:
                        AdmMenu.menuPrincipal(usuarioService);
                        break;
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
