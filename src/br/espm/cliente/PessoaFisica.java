package br.espm.cliente;

public class PessoaFisica extends Cliente {
    private Long cpf;

    public PessoaFisica(String nome, String contato, Long cpf) {
        super(nome, contato);
        this.cpf = cpf;
    }

    public PessoaFisica(Long identificador) {
        this(null, null, identificador);
    }

    @Override
    public Long getIdentificador() {
        return this.cpf;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
}
