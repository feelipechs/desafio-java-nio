import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BibliotecaAutomatica {

    public static void main(String[] args) {
        Path biblioteca = Paths.get("Biblioteca");

        try {
            if (!Files.exists(biblioteca)) {
                Files.createDirectory(biblioteca);
                System.out.println("Biblioteca criada.");
            }

            String[] categorias = { "Romance", "Tecnologia", "Ficcao" };

            String[][] livros = {
                { "Orgulho_e_Preconceito.txt", "Como_Eu_Era_Antes_De_Voce.txt" },
                { "Java_Basico.txt", "Estrutura_De_Dados.txt" },
                { "Harry_Potter.txt", "Jogos_Vorazes.txt" },
            };

            for (int i = 0; i < categorias.length; i++) {
                Path pastaCategoria = biblioteca.resolve(categorias[i]);

                if (!Files.exists(pastaCategoria)) {
                    Files.createDirectory(pastaCategoria);
                    System.out.println("Categoria criada: " + categorias[i]);
                }

                for (String nomeLivro : livros[i]) {
                    Path arquivoLivro = pastaCategoria.resolve(nomeLivro);

                    if (!Files.exists(arquivoLivro)) {
                        Files.createFile(arquivoLivro);
                        System.out.println("Livro criado: " + nomeLivro);
                    }
                }
            }

            System.out.println("Biblioteca organizada com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
