package classes;

import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private Funcionario funcionario;
    private ArrayList<Prato> pratos;
    private ArrayList<Bebida> bebidas;
    private Double precoFinal;
    
    public Pedido(Cliente cliente, Funcionario funcionario, ArrayList<Prato> pratos, ArrayList<Bebida> bebidas) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.pratos = pratos;
        this.bebidas = bebidas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    // Método para calcular o preço final do pedido
    public void calcularPrecoFinal() {
        double precoPratos = 0.0;
        double precoBebidas = 0.0;

        // Calcula o preço total dos pratos
        for (Prato prato : pratos) {
            precoPratos += prato.getPreco();
        }

        // Calcula o preço total das bebidas
        for (Bebida bebida : bebidas) {
            precoBebidas += bebida.getPreco();
        }

        // Soma os preços dos pratos e das bebidas para obter o preço final
        this.precoFinal = precoPratos + precoBebidas;
    }

    

    
    
}
