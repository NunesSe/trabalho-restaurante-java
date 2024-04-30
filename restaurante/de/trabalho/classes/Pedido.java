package classes;

import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private Funcionario funcionario;
    private ArrayList<Prato> prato;
    private ArrayList<Bebida> bebida;
    private Double precoFinal;


    public Pedido(Cliente cliente, Funcionario funcionario, ArrayList<Prato> prato) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.prato = prato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public ArrayList<Prato> getPratos() {
        return prato;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public ArrayList<Bebida> getBebida() {
        return bebida;
    }

    
    
}
