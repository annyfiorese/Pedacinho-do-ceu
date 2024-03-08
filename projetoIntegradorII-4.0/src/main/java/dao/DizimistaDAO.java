package dao;

import java.util.ArrayList;
import java.util.List;
import model.CadastroDizimista;
import util.ArquivoTexto;

public class DizimistaDAO {

    private ArquivoTexto arquivo;

    private static final String NOME_ARQUIVO = "dizimista.csv";

    public DizimistaDAO() {
        this.arquivo = new ArquivoTexto(NOME_ARQUIVO);
    }

    public void inserir(CadastroDizimista dizimista) {
        dizimista.setCodigo(0);
        this.arquivo.inserir(dizimista.toCsv());
    }

    public List<CadastroDizimista> listar() {
        List<String> registros = this.arquivo.ler();
        List<CadastroDizimista> dizimistas = new ArrayList();
        for (String registro : registros) {
            String[] reg = registro.split(";");
            CadastroDizimista dizimista = new CadastroDizimista(Integer.parseInt(reg[0]), reg[1], reg[2], reg[3], reg[4], Long.parseLong(reg[5]), reg[6], reg[7], reg[8]);
            dizimistas.add(dizimista);
        }
        return dizimistas;
    }

    public void remover(CadastroDizimista dizimista) {
        List<CadastroDizimista> dizimistas = listar();
        for (CadastroDizimista m : dizimistas) {
            if (m.getCodigo() == dizimista.getCodigo()) {
                dizimistas.remove(m);
                break;
            }
        }
        arquivo.apagar();
        for (CadastroDizimista mc : dizimistas) {
            this.inserir(mc);
        }
    }
}
