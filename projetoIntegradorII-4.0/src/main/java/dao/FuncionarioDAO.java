package dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.CadastroFuncionario;
import util.ArquivoTexto;

public class FuncionarioDAO {

    private ArquivoTexto arquivo;

    private static final String NOME_ARQUIVO = "funcionario.csv";

    public FuncionarioDAO() {
        this.arquivo = new ArquivoTexto(NOME_ARQUIVO);
    }

    public void inserir(CadastroFuncionario funcionario) {
        this.arquivo.inserir(funcionario.toCsv());
    }

    public CadastroFuncionario pesquisarFuncionario(String usuario) {
        List<CadastroFuncionario> funcionarios = listar();
        for (CadastroFuncionario funcionario : funcionarios) {
            if (usuario.equals(funcionario.getUsuario())) {
                return funcionario;
            }
        }
        return null;
    }

    public List<CadastroFuncionario> listar() {
        List<String> registros = this.arquivo.ler();
        List<CadastroFuncionario> funcionarios = new ArrayList<>();
        for (String registro : registros) {
            String[] reg = registro.split(";");
            CadastroFuncionario funcionario = new CadastroFuncionario(reg[0], reg[1], reg[2], reg[3], reg[4], reg[5], Integer.parseInt(reg[6]), reg[7], reg[8], reg[9], Integer.parseInt(reg[10]));
            funcionarios.add(funcionario);
        }
        return funcionarios;
    }

    public void remover(CadastroFuncionario funcionario) {
        List<CadastroFuncionario> funcionarios = listar();
        for (CadastroFuncionario m : funcionarios) {
            if (m.getId() == funcionario.getId()) {
                funcionarios.remove(m);
                break;
            }
        }
        arquivo.apagar();
        for (CadastroFuncionario mc : funcionarios) {
            this.inserir(mc);
        }
    }
}
