package modelos;

public class Passagem {
	
	private int id;
	private String destino;
	private float preco;
	
	public Passagem() {
	}

	public Passagem(String destino, float preco) {
		this.destino = destino;
		this.preco = preco;
	}

	public Passagem(int id, String destino, float preco) {
		this.id = id;
		this.destino = destino;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Passagem [id=" + id + ", destino=" + destino + ", preco=" + preco + "]";
	}
	
	
}
