package br.espm.controle;
import br.espm.assento.Assento;
import br.espm.cliente.Cliente;
import br.espm.cliente.PessoaFisica;
import br.espm.cliente.PessoaJuridica;
import br.espm.reserva.Reserva;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;

public class Controle {

    private static List<Cliente> listaCliente = new LinkedList<>();
    private static List<Assento> listaAssento = new LinkedList<>();
    private TreeSet<Reserva> listaReserva = new TreeSet<>();

    static {
        // lista de clientes
        listaCliente.add(new PessoaJuridica("ClienteA", "contatoa@gmail", 741L));
        listaCliente.add(new PessoaJuridica("ClienteB", "contatob@gmail", 852L));
        listaCliente.add(new PessoaFisica("ClienteC", "contatoc@gmail", 123L));
        listaCliente.add(new PessoaFisica("ClienteD", "contatod@gmail", 456L));

        // lista de assentos
        for(int i = 1; i <= 10; i++) {
            listaAssento.add(new Assento(i));
        }
    }

    public void menu() {
        int opcao;

        while(true) {
            try {
                opcao = parseInt(showInputDialog(gerarMenu()));
                switch(opcao) {
                    case 1:
                        reservar();
                        break;
                    case 2:
                        pesquisar();
                        break;
                    case 3:
                        cancelar();
                        break;
                    case 4:
                        return;
                    default:
                        showMessageDialog(null, "Opção inválida");
                }
            }
            catch(NumberFormatException e) {
                showMessageDialog(null, "você deve digitar um número");
            }
        }
    }

    private void cancelar() {
    }

    private void pesquisar() {
        Long identificador = Long.valueOf(showInputDialog("CPF/CNPJ"));
        Reserva reserva = new Reserva(identificador);
        showMessageDialog(null, listaReserva.contains(reserva));

        Iterator<Reserva> it = listaReserva.iterator();
        while(it.hasNext()) {
            
        }

    }

    private void reservar() {
        Long identificador = Long.valueOf(showInputDialog("CPF/CNPJ"));
        Cliente cliente = pesquisarCliente(identificador);
        if(cliente != null) {
            int assento = parseInt(showInputDialog(listarAssento()));
            listaReserva.add(new Reserva(cliente, listaAssento.get(assento), 5000));
            listaAssento.get(assento).setDisponivel(false);
        }
    }

    private Cliente pesquisarCliente(Long identificador) {
        for(Cliente cliente : listaCliente) {
            if(cliente.getIdentificador().equals(identificador)) {
                return cliente;
            }
        }
        return null;
    }
    
    private String listarAssento() {
        String aux = "";
        for(int i = 0; i < listaAssento.size(); i++) {
            aux += "Assento: " + (i + 1) + " ---> ";
            aux += listaAssento.get(i).isDisponivel() ? "DISPONÍVEL" : "INDISPONÍVEL";
            aux += "\n";
        }
        return aux;
    }

    private String gerarMenu() {
        String aux = "SISTEMA DE RESERVA DE PASSAGEM AÉREA\n";
        aux += "1. Reservar\n";
        aux += "2. Pesquisar reserva\n";
        aux += "3. Cancelar reserva\n";
        aux += "4. Finalizar";
        return aux;
    }
}
