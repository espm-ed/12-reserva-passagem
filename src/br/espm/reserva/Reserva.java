package br.espm.reserva;

import java.text.DecimalFormat;

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
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String aux = "";
        aux += "Cliente: " + cliente.getNome() + "\n";
        aux += "Assento: " + assento.getAssento() + "\n";
        aux += "Tarifa: R$ " + df.format(valorOriginal) + "\n";
        aux += "Tarifa com desconto: R$ " + df.format(valorFinal) + "\n";
        return aux;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }
    
}
