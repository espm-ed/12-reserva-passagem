package br.espm.assento;

public class Assento {
    private int assento;
    private boolean disponivel;
    
    public Assento(int assento) {
        this.assento = assento;
        this.disponivel = true;
    }

    public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    } 
    
    @Override
    public String toString() {
        String aux = "";
        aux += "Assento: " + assento + "\n";
        aux += "Status: ";
        aux += this.disponivel ? "Livre" : "Ocupado";
        return aux;
    }
    

}
