package util;

/**
 *
 * @author ANNY FIORESE
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ArquivoTexto {

    private String nome;
    private File file;

    public ArquivoTexto(String nome) {
        this.nome = nome;
        criar();
    }

    private void criar() {
        this.file = new File(this.nome);
        try {
            if (!file.exists()) { // file.exists() == false
                file.createNewFile();
                System.out.println("LOG: O arquivo " + this.nome + " foi criado com sucesso!");
            } else {
                System.out.println("LOG: O arquivo " + this.nome + " j� existe!");
            }
        } catch (IOException e) {
            System.out.println("ERRO: N�o foi poss�vel criar o arquivo " + this.nome + "!");
        }
    }

    public void inserir(String texto) {
        try {
            FileWriter fileWriter = new FileWriter(this.file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            System.out.println("LOG: O texto '" + texto + "' foi inserido no arquivo " + this.nome);
            printWriter.println(texto);
            System.out.println("LOG: O texto foi salvo com sucesso");
            printWriter.close();
        } catch (IOException e) {
            System.out.println("ERRO: Ocorreu um erro ao inserir os dados no arquivo " + this.nome);
        }
    }

    public List<String> ler() {
        System.out.println("LOG: Efetuando a leitura do arquivo " + this.nome + " ...");

        List<String> lista = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();
            while (linha != null) {
                lista.add(linha);
                linha = bufferedReader.readLine();
            }
            System.out.println("LOG: Leitura realizada com sucesso");
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERRO: N�o foi poss�vel localizar o arquivo " + this.nome);
        } catch (IOException e) {
            System.out.println("ERRO: N�o foi poss�vel ler os dados do arquivo " + this.nome);
        }
        return lista;
    }

    public void apagar() {
        try {
            FileWriter fileWriter = new FileWriter(this.file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("");
            System.out.println("LOG: O arquivo " + this.nome + " foi apagado com sucesso");
            printWriter.close();
        } catch (IOException e) {
            System.out.println("ERRO: Ocorreu um erro ao apagar os dados do arquivo " + this.nome);
        }
    }
}
