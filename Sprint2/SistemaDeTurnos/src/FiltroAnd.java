public class FiltroAnd implements Filtro {
    private String os;
    private String e;

    public FiltroAnd(String obraSocial, String especialidad) {
        this.os = obraSocial;
        this.e = especialidad;
    }

    @Override
    public boolean cumple (Medico m) {
        return m.getObraSocial().equals(os) && m.getEspecialidad().equals(e);
    }

}