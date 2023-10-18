package sistema;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Habitat {

    private String nombreHabitat;
    private Map<String, Integer> especiesMapDist = new HashMap<>();
    private Vector<Especie> especiesVector = new Vector<>();

    public Habitat(String nombreHabitat, Vector<Especie> especiesVector) {
        this.nombreHabitat = nombreHabitat;
        this.especiesVector = especiesVector;
    }

    public String getName() {
        return nombreHabitat;
    }

    public void setEspecies(Map<String, Integer> diccionarioEspecie) {
        especiesMapDist.putAll(diccionarioEspecie);

        // Limpiar el vector de especies antes de agregar las nuevas
        especiesVector.clear();

        for (Map.Entry<String, Integer> entry : especiesMapDist.entrySet()) {
            especiesVector.add(new Especie(entry.getKey(), entry.getValue()));
        }
    }

    public Map<String, Integer> getEspecies() {
        return especiesMapDist;
    }

    public Vector<Especie> getVectorEspecies() {
        return especiesVector;
    }

    public void addEspecie(Especie especieNueva) {
        especiesVector.add(especieNueva);
    }

    public boolean deleteEspecie(String nombreEspecie) {
        for (Especie tmp : especiesVector) {
            if (tmp.getName().equals(nombreEspecie)) {
                especiesVector.remove(tmp);
                return true;
            }
        }

        return false;
    }

    public boolean porcentajeDisponible(Especie especie) {
        int sumaPorcentajes = 0;
        for (Especie tmp : especiesVector) {
            sumaPorcentajes += tmp.getPorcent();
        }
        return (sumaPorcentajes + especie.getPorcent()) <= 100;
    }
}
