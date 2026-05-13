package profmarceltanuri;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BibliotecaAutomatica {

    public static void main(String[] args) {
        Path biblioteca = Paths.get("Biblioteca");

        try {
            System.out.println("\n======================================");
            System.out.println("      SISTEMA DE BIBLIOTECA ADA     ");
            System.out.println("======================================\n");

            // Criar pasta principal
            if (!Files.exists(biblioteca)) {
                Files.createDirectory(biblioteca);
                System.out.println("📁 Biblioteca criada com sucesso.\n");
            }

            // Categorias
            String[] categorias = { "Python", "Java", "Linux" };

            // Livros de cada categoria
            String[][] livros = {
                { "Python_Basico.txt", "Python_Avancado.txt" },
                { "Java_Basico.txt", "POO_Java.txt" },
                { "Linux_Para_Iniciantes.txt", "Comandos_Linux.txt" },
            };

            // Criar categorias e livros
            for (int i = 0; i < categorias.length; i++) {
                Path pastaCategoria = biblioteca.resolve(categorias[i]);

                // Criar pasta da categoria
                if (!Files.exists(pastaCategoria)) {
                    Files.createDirectory(pastaCategoria);
                }

                System.out.println("📂 Categoria: " + categorias[i]);

                // Criar livros
                for (String nomeLivro : livros[i]) {
                    Path arquivoLivro = pastaCategoria.resolve(nomeLivro);

                    if (!Files.exists(arquivoLivro)) {
                        Files.createFile(arquivoLivro);
                    }

                    System.out.println("   └── 📘 Livro adicionado: " + nomeLivro);
                }

                System.out.println();
            }

            System.out.println("======================================");
            System.out.println("Biblioteca organizada com sucesso!");
            System.out.println("======================================");
        } catch (IOException e) {
            System.out.println("======================================");
            System.out.println("Erro ao organizar biblioteca");
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("======================================");
        }
    }
}
