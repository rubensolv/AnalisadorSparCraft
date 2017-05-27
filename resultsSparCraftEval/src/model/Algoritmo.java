package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class Algoritmo implements Comparable<Algoritmo> {
	private String nome, Sigla;
	private Integer ordem;

	public Algoritmo(){
		nome = "";
	}
	
	public Algoritmo(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return Sigla;
	}

	public void setSigla(String sigla) {
		Sigla = sigla;
	}

	
	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public abstract void criarAlgoritmo(String dados);
	
	public void print(){
		System.out.print(getNome()+" (");
		System.out.print(getSigla()+" ");
		System.out.print(getOrdem()+") ");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Algoritmo other = (Algoritmo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public static Algoritmo definirTipoAlgoritmo(String dados){
		Algoritmo retornar = null;
		
		if(dados.contains("Portfolio")){
			retornar = new Portfolio();
		}
		
		if(dados.contains("UCT")){
			retornar = new UCT();
		}
		
		if(dados.contains("AlphaBeta")){
			retornar = new AlphaBeta();
		}
		
		if(dados.contains("Stratified")){
			retornar = new Stratified();
		}
		
		return retornar;
	}
	
	public void completarInfoAlgoritmo(){
		String linha;
		try {
			File f = new File(getClass().getResource("configAlgoritmos.txt").getFile());
			FileReader arq = new FileReader(f.getAbsolutePath());
			BufferedReader learArq = new BufferedReader(arq);

			linha = learArq.readLine();

			while (linha != null) {
				String dados[] = linha.split(" ");
				if(dados[1].trim().equals(this.getNome())){
					this.setOrdem(Integer.valueOf(dados[0]));
					this.setSigla(dados[2]);
				}

				linha = learArq.readLine();
			}
			arq.close();

		} catch (Exception e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			System.out.println(e.toString());
		}
	}
	
	@Override
	public int compareTo(Algoritmo o) {
		if(this.ordem < o.getOrdem()){
			return -1;
		}
		if(this.ordem < o.getOrdem()){
			return 1;
		}
		return 0;
	}
	
}
