package model;

public class Stratified extends Algoritmo {

	private Integer TimeLimitMS;
	private String Script;
	private Integer Iterations, Responses, tipeSystem;
	
	
	public Stratified() {
	}

	public Stratified(String nome) {
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

	public Integer getTipeSystem() {
		return tipeSystem;
	}

	public void setTipeSystem(Integer tipeSystem) {
		this.tipeSystem = tipeSystem;
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
		Stratified other = (Stratified) obj;
		if (TimeLimitMS == null) {
			if (other.TimeLimitMS != null)
				return false;
		} else if (!TimeLimitMS.equals(other.TimeLimitMS))
			return false;
		return true;
	}

	@Override
	public void criarAlgoritmo(String dados) {
		String partes[] = dados.split(" ");
		setNome(partes[0]);
		setTimeLimitMS(Integer.valueOf(partes[1]));
		setScript(partes[2]);
		setIterations(Integer.valueOf(partes[3]));
		setResponses(Integer.valueOf(partes[4]));
		if(partes.length >= 6){
			setTipeSystem(Integer.valueOf(partes[5]));
		}
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.print(getTimeLimitMS()+" ");
		System.out.print(getScript()+" ");
		System.out.print(getIterations()+" ");
		System.out.print(getResponses()+" ");
		System.out.println(getTipeSystem());
		
	}

}
