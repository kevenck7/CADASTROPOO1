/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author João Pedro
 */
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Repositório de Pessoas Físicas
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            PessoaFisica pessoa1 = new PessoaFisica(1, "Ana", "111.111.111-11", 25);
            PessoaFisica pessoa2 = new PessoaFisica(2, "Carlos", "222.222.222-22", 52);

            repo1.inserir(pessoa1);
            repo1.inserir(pessoa2);

            repo1.persistir("pessoas_fisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoas_fisicas.dat");

            List<PessoaFisica> pessoasFisicasRecuperadas = repo2.obterTodos();
            for (PessoaFisica pf : pessoasFisicasRecuperadas) {
                pf.exibir();
                System.out.println();
            }

            // Repositório de Pessoas Jurídicas
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            PessoaJuridica empresa1 = new PessoaJuridica(3, "XPTO SALES", "33333333333333");
            PessoaJuridica empresa2 = new PessoaJuridica(4, "XPTO Solutions", "44444444444444");

            repo3.inserir(empresa1);
            repo3.inserir(empresa2);

            repo3.persistir("pessoas_juridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoas_juridicas.dat");

            List<PessoaJuridica> pessoasJuridicasRecuperadas = repo4.obterTodos();
            for (PessoaJuridica pj : pessoasJuridicasRecuperadas) {
                pj.exibir();
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

