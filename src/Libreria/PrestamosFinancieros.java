/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

/**
 * La clase {@code PrestamosFinancieros} proporciona métodos estáticos para realizar cálculos financieros
 * comunes como interés simple, interés compuesto, montos finales, pagos mensuales de préstamos y
 * conversión de tasas de interés anuales a mensuales.
 *
 * <p>Incluye validaciones para evitar parámetros inválidos y garantizar resultados correctos.
 *
 * @author HP
 */
public class PrestamosFinancieros {

    /**
     * Calcula el interés simple de un capital invertido a una tasa determinada durante un tiempo.
     *
     * @param capital el capital inicial invertido (mayor a cero)
     * @param tasa la tasa de interés en decimal (por ejemplo, 0.05 para 5%)
     * @param tiempo el tiempo de la inversión en años (mayor a cero)
     * @return el interés simple calculado
     * @throws IllegalArgumentException si capital 
     */
    public static double calcularInteresSimple(double capital, double tasa, int tiempo) {
        validarCapitalTasaTiempo(capital, tasa, tiempo);
        double interes = capital * tasa * tiempo;
        return interes;
    }

    /**
     * Calcula el interés compuesto de un capital invertido a una tasa determinada durante un tiempo.
     *
     * @param capital el capital inicial invertido (mayor a cero)
     * @param tasa la tasa de interés en decimal (por ejemplo, 0.05 para 5%)
     * @param tiempo el tiempo de la inversión en años (mayor a cero)
     * @return el interés compuesto calculado
     * @throws IllegalArgumentException si capital 
     */
    public static double calcularInteresCompuesto(double capital, double tasa, int tiempo) {
        validarCapitalTasaTiempo(capital, tasa, tiempo);
        double interes = capital * (Math.pow(1 + tasa, tiempo) - 1);
        return interes;
    }

    /**
     * Calcula el monto final de un capital invertido con interés simple.
     *
     * @param capital el capital inicial invertido (mayor a cero)
     * @param tasa la tasa de interés en decimal (por ejemplo, 0.05 para 5%)
     * @param tiempo el tiempo de la inversión en años (mayor a cero)
     * @return el monto final acumulado con interés simple
     * @throws IllegalArgumentException si capital 
     */
    public static double calcularMontoFinalInteresSimple(double capital, double tasa, int tiempo) {
        validarCapitalTasaTiempo(capital, tasa, tiempo);
        double interes = calcularInteresSimple(capital, tasa, tiempo);
        double montoFinal = capital + interes;
        return montoFinal;
    }

    /**
     * Calcula el monto final de un capital invertido con interés compuesto.
     *
     * @param capital el capital inicial invertido (mayor a cero)
     * @param tasa la tasa de interés en decimal (por ejemplo, 0.05 para 5%)
     * @param tiempo el tiempo de la inversión en años (mayor a cero)
     * @return el monto final acumulado con interés compuesto
     * @throws IllegalArgumentException si capital 
     */
    public static double calcularMontoFinalInteresCompuesto(double capital, double tasa, int tiempo) {
        validarCapitalTasaTiempo(capital, tasa, tiempo);
        double montoFinal = capital * Math.pow(1 + tasa, tiempo);
        return montoFinal;
    }

    /**
     * Calcula el pago mensual necesario para amortizar un préstamo a una tasa de interés mensual durante un número de meses.
     *
     * @param capital el monto total del préstamo (mayor a cero)
     * @param tasaMensual la tasa de interés mensual en decimal (por ejemplo, 0.01 para 1%)
     * @param numeroMeses el número de meses del préstamo (mayor a cero)
     * @return el pago mensual requerido
     * @throws IllegalArgumentException si capital 
     */
    public static double calcularPagoMensual(double capital, double tasaMensual, int numeroMeses) {
        validarCapitalTasaMeses(capital, tasaMensual, numeroMeses);
        double pagoMensual = (capital * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -numeroMeses));
        return pagoMensual;
    }

    /**
     * Convierte una tasa de interés anual a su equivalente mensual.
     *
     * @param tasaAnual la tasa de interés anual en decimal (por ejemplo, 0.12 para 12%)
     * @return la tasa de interés mensual equivalente
     * @throws IllegalArgumentException si tasaAnual 
     */
    public static double convertirTasaAnualAMensual(double tasaAnual) {
        if (tasaAnual < 0) {
            throw new IllegalArgumentException("La tasa anual no puede ser negativa.");
        }
        double tasaMensual = Math.pow(1 + tasaAnual, 1.0 / 12) - 1;
        return tasaMensual;
    }

    // Métodos privados de validación

    private static void validarCapitalTasaTiempo(double capital, double tasa, int tiempo) {
        if (capital <= 0) {
            throw new IllegalArgumentException("El capital debe ser mayor a cero.");
        }
        if (tasa < 0) {
            throw new IllegalArgumentException("La tasa no puede ser negativa.");
        }
        if (tiempo <= 0) {
            throw new IllegalArgumentException("El tiempo debe ser mayor a cero.");
        }
    }

    private static void validarCapitalTasaMeses(double capital, double tasaMensual, int numeroMeses) {
        if (capital <= 0) {
            throw new IllegalArgumentException("El capital debe ser mayor a cero.");
        }
        if (tasaMensual < 0) {
            throw new IllegalArgumentException("La tasa mensual no puede ser negativa.");
        }
        if (numeroMeses <= 0) {
            throw new IllegalArgumentException("El número de meses debe ser mayor a cero.");
        }
    }
}
