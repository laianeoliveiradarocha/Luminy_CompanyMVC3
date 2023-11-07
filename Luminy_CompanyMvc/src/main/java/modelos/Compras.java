package modelos;

public class Compras {

	private int id;
	private String data_compra;
	private Double total_compra;
	
	private Clientes cliente;
	private Passagem passagem;
	
	public Compras() {
	}
	public Compras(int id, String data_compra, Double total_compra, Clientes cliente, Passagem passagem) {
		this.id = id;
		this.data_compra = data_compra;
		this.total_compra = total_compra;
		this.cliente = cliente;
		this.passagem = passagem;
	}
	public Compras(String data_compra, Double total_compra, Clientes cliente, Passagem passagem) {
		this.data_compra = data_compra;
		this.total_compra = total_compra;
		this.cliente = cliente;
		this.passagem = passagem;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData_compra() {
		return data_compra;
	}
	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}
	public Double getTotal_compra() {
		return total_compra;
	}
	public void setTotal_compra(Double total_compra) {
		this.total_compra = total_compra;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Passagem getPassagem() {
		return passagem;
	}
	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}
	
	@Override
	public String toString() {
		return "Compras [id=" + id + ", data_compra=" + data_compra + ", total_compra=" + total_compra + ", cliente="
				+ cliente + ", passagem=" + passagem + "]";
	}
	
	
}
