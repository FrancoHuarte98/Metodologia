
import java.time.LocalTime;

public class FiltroTurnoManana implements Filtro {
	
	private LocalTime hora;
	
	public FiltroTurnoManana () {
		this.hora.of(12, 0);
	}
	
	public boolean cumple (Turno t) {
		return this.es_Menor(t.getHoraTurno());
	}
	
	private boolean es_Menor(LocalTime h) {
		if (h.getHour()<=this.hora.getHour())
			if (h.getMinute() <= this.hora.getMinute())
				return true;
		return false;
	}
}
