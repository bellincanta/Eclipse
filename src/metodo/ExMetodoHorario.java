package metodo;

public class ExMetodoHorario {
	
	public int hor, min, seg;
	
	public void setHorario(int h, int m, int s) {
		setHoras(h);
		setMinutos(m);
		setSegundos(s);
	}
	
	public void setHoras(int h) {
		if(h>=0 && h<24) hor = h;
	}
	public void setMinutos(int m) {
		if(m>=0 && m<60) min = m;
	}
	
	public void setSegundos(int s) {
		if(s>=0 && s<60) seg = s;
	}
	
	public String toString() {
		String mostrar = hor + ":" + min + ":"
				+ seg;
		return mostrar;
	}

}
