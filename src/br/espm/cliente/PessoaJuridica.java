package br.espm.cliente;

import java.util.Random;

import br.espm.desconto.Desconto;

public class PessoaJuridica extends Cliente implements Desconto {
    private Long cnpj;

    public PessoaJuridica(String nome, String contato, Long cnpj) {
        super(nome, contato);
        this.cnpj = cnpj;
    }

    @Override
    public Long getIdentificador() {
        return this.cnpj;
    }

    @Override
    public double aplicarDesconto(double valor) {
        Random random = new Random();
        double porcentagem = random.nextInt(1, 11);
        double desconto = valor * porcentagem / 100;
        return valor - desconto;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }
}
