package model;

public class Player {

	private Integer numero;
	private Algoritmo algoritmo;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Algoritmo getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(Algoritmo algoritmo) {
		this.algoritmo = algoritmo;
	}
	
	public static Player criarPlayer(String linha){
		Player p = new Player();
		p.setNumero(Integer.valueOf(linha.substring(7, 8)));
		
		
		Algoritmo alg = Algoritmo.definirTipoAlgoritmo(linha.substring(9));
		alg.criarAlgoritmo(linha.substring(9));
		alg.completarInfoAlgoritmo();
		p.setAlgoritmo(alg);
		
		return p;
	}
	
	public void print(){
		System.out.println("Player "+numero);
		algoritmo.print();
	}

}
