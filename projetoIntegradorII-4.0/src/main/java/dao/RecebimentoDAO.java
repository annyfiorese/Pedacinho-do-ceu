package dao;

import java.util.ArrayList;
import java.util.List;
import model.CadastroFuncionario;
import model.Recebimento;
import util.ArquivoTexto;

public class RecebimentoDAO {

    private ArquivoTexto arquivo;

    private static final String NOME_ARQUIVO = "recebimento.csv";

    public RecebimentoDAO() {
        this.arquivo = new ArquivoTexto(NOME_ARQUIVO);
    }

    public void inserir(Recebimento recebimento) {
        recebimento.setId(0);
        this.arquivo.inserir(recebimento.toCsv());
    }

    public List<Recebimento> listar() {
        List<String> registros = this.arquivo.ler();
        List<Recebimento> recebimentos = new ArrayList();
        for (String registro : registros) {
            String[] reg = registro.split(";");
            Recebimento recebimento = new Recebimento(Integer.parseInt(reg[0]), reg[1], reg[2], reg[3], reg[4]);
            recebimentos.add(recebimento);
        }
        return recebimentos;
    }

    public void remover(Recebimento recebimento) {
        List<Recebimento> recebimentos = listar();
        for (Recebimento m : recebimentos) {
            if (m.getId() == recebimento.getId()) {
                recebimentos.remove(m);
                break;
            }
        }
        arquivo.apagar();
        for (Recebimento mc : recebimentos) {
            this.inserir(mc);
        }
    }
}
