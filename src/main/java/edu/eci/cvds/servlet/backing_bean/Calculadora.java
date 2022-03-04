package edu.eci.cvds.servlet.backing_bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.criteria.CriteriaBuilder;

import java.util.*;
import java.util.stream.Collectors;

@ManagedBean(name = "calculadoraBean")
@ApplicationScoped

public class Calculadora {

    private double media;
    private int cantidadNumeros;
    private double moda;
    private double desviacionEstandar;
    private double varianza;
    private List<Double> listaValores;
    public String numeros;

    public Calculadora(){
        numeros = "";
    }

    public double getMedia() {
        return media;
    }

    public double getModa() {
        return moda;
    }

    public double getDesviacionEstandar() {
        return desviacionEstandar;
    }

    public double getVarianza() {
        return varianza;
    }

    public int getCantidadNumeros() {
        return cantidadNumeros;
    }

    public void setCantidadNumeros(int cantidadNumeros) {
        this.cantidadNumeros = cantidadNumeros;
    }

    public void setDesviacionEstandar(double desviacionEstandar) {
        this.desviacionEstandar = desviacionEstandar;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void setModa(double moda) {
        this.moda = moda;
    }

    public void setVarianza(double varianza) {
        this.varianza = varianza;
    }


    ///////////////////////////

    /**
     * Retorna el promedio de una lista de valores
     * @param valores lista de valores a calcular promedio
     * @return
     */
    public double calculateMean(String valores){
        List<Double> values =  convertValues(valores);
        Double promedio = 0.0;
        for(Double val : values){
            promedio += val;
        }
        promedio = promedio / cantidadNumeros;
        return promedio;
    }

    public double calculateStandardDesviation(String valores){
        Double resultMedia = calculateMean(valores);
        List<Double> values = convertValues(valores);
        Double suma = 0.0;
        for (Double dato: values) {
            double distancia = Math.pow(resultMedia-dato,2.0);
            suma += distancia;
        }
        suma = suma/cantidadNumeros;
        suma = Math.pow(suma,0.5);
        desviacionEstandar = suma;
        return suma;
    }

    /**
     * Calcula la moda dada una lista de valores
     * @param valores lista de valores
     * @return moda
     */
    public double calculateMode(String valores){
        List<Double> values = convertValues(valores);
        Map<Double,Integer> mapa = new HashMap<>();
        for (Double d:values) {
            if (mapa.containsKey(d)) {
                mapa.put(d, mapa.get(d) + 1);
            } else {
                mapa.put(d, 1);
            }
        }
            int mayor =0 ;
            Double resultModa=0.0;
            for (Map.Entry<Double, Integer> entry: mapa.entrySet()) {
                if (entry.getValue() > mayor){
                    mayor = entry.getValue();
                    resultModa = entry.getKey();
                }
            }
            this.moda = resultModa;
        return resultModa;
    }

    /**
     * Calcula la varianza de una lista de valores dada
      * @param valores Lista de valores
     * @return varianza
     */
    public double calculateVariance(String valores){
        List<Double> values = convertValues(valores);
        double promedioV = calculateMean(valores);
        for (double d: values) {
            varianza += Math.pow((d-promedioV),2)/cantidadNumeros;
        }
        return varianza;
    }

    /**
     * Reinicia la calculadora a los valores por defecto
     */
    public void restart() {
        cantidadNumeros = 0;
        media = 0;
        desviacionEstandar = 0;
        varianza = 0;
        moda  = 0;
        listaValores = new ArrayList<Double>();
    }

    /**
     * Convierte un string a una lista de valores decimales
     * @param valores
     * @return
     */
    public List<Double> convertValues(String valores){
        numeros = valores;
        this.listaValores = new ArrayList<>();
        for (String val: valores.split(";")) {
            listaValores.add(Double.parseDouble(val));
        }
        cantidadNumeros = listaValores.size();

        return listaValores;
    }



}
