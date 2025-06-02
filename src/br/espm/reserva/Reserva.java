package br.espm.reserva;

import br.espm.assento.Assento;
import br.espm.cliente.Cliente;
import br.espm.cliente.PessoaFisica;
import br.espm.desconto.Desconto;

public class Reserva implements Comparable<Reserva> {
    private Cliente cliente;
    private Assento assento;
    private double valorFinal;
    private double valorOriginal;

    public Reserva(Cliente cliente, Assento assento, double valorOriginal) {
        this.cliente = cliente;
        this.assento = assento;
        this.valorOriginal = valorOriginal;
        calcularValorFinal();
    }

    public Reserva(Long identificador) {
        this.cliente = new PessoaFisica(identificador);
    }

    private void calcularValorFinal() {
        if(cliente instanceof Desconto) {
            valorFinal = ((Desconto)cliente).aplicarDesconto(valorOriginal);
        }
        else {
            valorFinal = valorOriginal;
        }
    }

    @Override
    public int compareTo(Reserva reserva) {
        return cliente.getIdentificador().compareTo(reserva.cliente.getIdentificador());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Reserva) {
            Reserva reserva = (Reserva) obj;
            return cliente.getIdentificador().equals(reserva.cliente.getIdentificador());
        }
        return false;
    }

    

    
}
