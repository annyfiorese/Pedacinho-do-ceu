package dao;

import java.util.ArrayList;
import java.util.List;
import model.Dispesas;
import util.ArquivoTexto;

public class DispesasDAO {

    private ArquivoTexto arquivo;

    private static final String NOME_ARQUIVO = "dispesas.csv";

    public DispesasDAO() {
        this.arquivo = new ArquivoTexto(NOME_ARQUIVO);
    }

    public void inserir(Dispesas dispesa) {
        dispesa.setId(0);
        this.arquivo.inserir(dispesa.toCsv());
    }

    public List<Dispesas> listar() {
        List<String> registros = this.arquivo.ler();
        List<Dispesas> dispesas = new ArrayList();
        for (String registro : registros) {
            String[] reg = registro.split(";");
            Dispesas dispesa = new Dispesas(Integer.parseInt(reg[0]), reg[3], reg[2], reg[1], reg[4]);
            dispesas.add(dispesa);
        }
        return dispesas;
    }

    public void remover(Dispesas dispesa) {
        List<Dispesas> dispesas = listar();
        for (Dispesas m : dispesas) {
            if (m.getId() == dispesa.getId()) {
                dispesas.remove(m);
                break;
            }
        }
        arquivo.apagar();
        for (Dispesas mc : dispesas) {
            this.inserir(mc);
        }
    }
}
