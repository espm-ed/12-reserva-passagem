package br.espm.reserva;

import br.espm.assento.Assento;
import br.espm.cliente.Cliente;
import br.espm.desconto.Desconto;

public class Reserva {
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

    private void calcularValorFinal() {
        if(cliente instanceof Desconto) {
            valorFinal = ((Desconto)cliente).aplicarDesconto(valorOriginal);
        }
        else {
            valorFinal = valorOriginal;
        }
    }

    

    
}
