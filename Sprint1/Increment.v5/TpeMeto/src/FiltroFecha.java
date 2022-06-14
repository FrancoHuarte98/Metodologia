import java.time.LocalDate;

public class FiltroFecha implements Filtro{

	private LocalDate f1;
	private LocalDate f2;
	
	public FiltroFecha (LocalDate f1, LocalDate f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	
	public boolean cumple (Turno t) {
		return this.es_Menor(t.getFechaturno()) && this.es_Mayor(t.getFechaturno());
	}
	
	private boolean es_Menor (LocalDate f) {
		if (f.getYear() <= f2.getYear())
			if (f.getMonthValue() <= f2.getMonthValue())
				if (f.getDayOfMonth() <= f2.getDayOfMonth())
					return true;
		return false;
	}
	
	private boolean es_Mayor (LocalDate f) {
		if (f.getYear() >= f1.getYear())
			if (f.getMonthValue() >= f1.getMonthValue())
				if (f.getDayOfMonth() >= f1.getDayOfMonth())
					return true;
		return false;
	}
}
