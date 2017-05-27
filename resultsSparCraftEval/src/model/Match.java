package model;

import java.math.BigDecimal;

public class Match {
	
	private BigDecimal result;
	private Player p1, p2;
	private Estado state;
	
	public Match() {
		result = BigDecimal.ZERO;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	public Estado getState() {
		return state;
	}

	public void setState(Estado state) {
		this.state = state;
	}
	
	public BigDecimal resultContra(){
		BigDecimal resultC = BigDecimal.ONE;
		resultC = resultC.subtract(result);
		return resultC;
	}
	
	public void print(){
		System.out.println("--------------------------------");
			p1.print();
			p2.print();
			state.print();
			System.out.println("Resultado P1 x P2 ="+ result.toString());
			System.out.println("Resultado P2 x P1 ="+ resultContra().toString());
		System.out.println("--------------------------------");
	}
	
	
	

}
