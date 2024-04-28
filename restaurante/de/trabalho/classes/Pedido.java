package classes;

import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private Funcionario funcionario;
    private ArrayList<Prato> pratos;
    private Double precoFinal;

    public Pedido(Cliente cliente, Funcionario funcionario, ArrayList<Prato> pratos, Double precoFinal) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.pratos = pratos;
        this.precoFinal = precoFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    
}
