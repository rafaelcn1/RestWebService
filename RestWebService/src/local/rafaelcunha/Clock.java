package local.rafaelcunha;

public class Clock {
	
	//Graus por Hora
	public static int horaAngulo = 30;
	
	//Graus por Minutos
	public static int minutoAngulo = 6;

	public int hora, minutos;

	public Clock() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hora;
		result = prime * result + minutos;
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
		Clock other = (Clock) obj;
		if (hora != other.hora)
			return false;
		if (minutos != other.minutos)
			return false;
		return true;
	}

	public Clock(int hora, int minutos) {
		super();
		this.hora = hora;
		this.minutos = minutos;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		if (hora == 12) {
			this.hora = 0;
		}
		
		this.hora = hora;

	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	
	
	//Metodo para calcular angulo do ponteiro da hora
	public double getAnguloHora() {
		double anguloHora = (getHora() * horaAngulo) + ((horaAngulo * this.minutos) / 60);

		return anguloHora;
	}
	
	//Metodo para calcular angulo do ponteiro do minuto
	public double getAnguloMinuto() {
		double anguloMinuto = getMinutos() * minutoAngulo;
		return anguloMinuto;
	}

	//Metodo para calcular angulo  entre os 2 ponteiros do relógio
	public double getAngulo() {
		double angulo;

		if (getAnguloHora() < getAnguloMinuto()) {
			angulo = getAnguloMinuto() - getAnguloHora();
		} else {
			angulo = getAnguloHora() - getAnguloMinuto();
		}

		return angulo;
	}

}
