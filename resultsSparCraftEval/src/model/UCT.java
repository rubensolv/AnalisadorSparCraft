package model;

public class UCT extends Algoritmo {

	private Integer TimeLimitMS;
	private Double  CValue;
	private Integer MaxTraversals;
	private Integer MaxChildren ;
	private String MoveOrdering;
	private String EvalMethod;
	private String P0Script;
	private String P1Script;
	private String PlayerToMoveMethod;
	private String OpponentModelScript;
	
	
	public UCT() {
	}

	public UCT(String nome) {
		super(nome);
	}

	public Integer getTimeLimitMS() {
		return TimeLimitMS;
	}

	public void setTimeLimitMS(Integer timeLimitMS) {
		TimeLimitMS = timeLimitMS;
	}

	public Double getCValue() {
		return CValue;
	}

	public void setCValue(Double cValue) {
		CValue = cValue;
	}

	public Integer getMaxTraversals() {
		return MaxTraversals;
	}

	public void setMaxTraversals(Integer maxTraversals) {
		MaxTraversals = maxTraversals;
	}

	public Integer getMaxChildren() {
		return MaxChildren;
	}

	public void setMaxChildren(Integer maxChildren) {
		MaxChildren = maxChildren;
	}

	public String getMoveOrdering() {
		return MoveOrdering;
	}

	public void setMoveOrdering(String moveOrdering) {
		MoveOrdering = moveOrdering;
	}

	public String getEvalMethod() {
		return EvalMethod;
	}

	public void setEvalMethod(String evalMethod) {
		EvalMethod = evalMethod;
	}

	public String getP0Script() {
		return P0Script;
	}

	public void setP0Script(String p0Script) {
		P0Script = p0Script;
	}

	public String getP1Script() {
		return P1Script;
	}

	public void setP1Script(String p1Script) {
		P1Script = p1Script;
	}

	public String getPlayerToMoveMethod() {
		return PlayerToMoveMethod;
	}

	public void setPlayerToMoveMethod(String playerToMoveMethod) {
		PlayerToMoveMethod = playerToMoveMethod;
	}

	public String getOpponentModelScript() {
		return OpponentModelScript;
	}

	public void setOpponentModelScript(String opponentModelScript) {
		OpponentModelScript = opponentModelScript;
	}
	
	@Override
	public void criarAlgoritmo(String dados) {
		String partes[] = dados.split(" ");
		setNome(partes[0]);
		setTimeLimitMS(Integer.valueOf(partes[1]));
		setCValue(Double.valueOf(partes[2]));
		setMaxTraversals(Integer.valueOf(partes[3]));
		setMaxChildren(Integer.valueOf(partes[4]));
		setMoveOrdering(partes[5]);
		setEvalMethod(partes[6]);
		setP0Script(partes[7]);
		setP1Script(partes[8]);
		setPlayerToMoveMethod(partes[9]);
		setOpponentModelScript(partes[10]);
		
	}
	
	@Override
	public void print() {
		super.print();
		System.out.print(getTimeLimitMS()+" ");
		System.out.print(getCValue()+" ");
		System.out.print(getMaxTraversals()+" ");
		System.out.print(getMaxChildren()+" ");
		System.out.print(getMoveOrdering()+" ");
		System.out.print(getEvalMethod()+" ");
		System.out.print(getP0Script()+" ");
		System.out.print(getP1Script()+" ");
		System.out.print(getPlayerToMoveMethod()+" ");
		System.out.println(getOpponentModelScript());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((TimeLimitMS == null) ? 0 : TimeLimitMS.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UCT other = (UCT) obj;
		if (TimeLimitMS == null) {
			if (other.TimeLimitMS != null)
				return false;
		} else if (!TimeLimitMS.equals(other.TimeLimitMS))
			return false;
		return true;
	}
	
	

}
