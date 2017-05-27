package model;

public class Portfolio extends Algoritmo {
	
	private Integer TimeLimitMS;
	private String Script;
	private Integer Iterations, Responses;

	public Portfolio() {

	}

	public Portfolio(String nome) {
		super(nome);
	}

	public Integer getTimeLimitMS() {
		return TimeLimitMS;
	}

	public void setTimeLimitMS(Integer timeLimitMS) {
		TimeLimitMS = timeLimitMS;
	}

	public String getScript() {
		return Script;
	}

	public void setScript(String script) {
		Script = script;
	}

	public Integer getIterations() {
		return Iterations;
	}

	public void setIterations(Integer iterations) {
		Iterations = iterations;
	}

	public Integer getResponses() {
		return Responses;
	}

	public void setResponses(Integer responses) {
		Responses = responses;
	}

	
	@Override
	public void criarAlgoritmo(String dados) {
		
		String partes[] = dados.split(" ");
		
		setNome(partes[0]);
		setTimeLimitMS(Integer.valueOf(partes[1]));
		setScript(partes[2]);
		setIterations(Integer.valueOf(partes[3]));
		setResponses(Integer.valueOf(partes[4]));
		
	}
	
	@Override
	public void print() {
		super.print();
		System.out.print(getTimeLimitMS()+" ");
		System.out.print(getScript()+" ");
		System.out.print(getIterations()+" ");
		System.out.println(getResponses());
		
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
		Portfolio other = (Portfolio) obj;
		if (TimeLimitMS == null) {
			if (other.TimeLimitMS != null)
				return false;
		} else if (!TimeLimitMS.equals(other.TimeLimitMS))
			return false;
		return true;
	}
	
	
	
}
