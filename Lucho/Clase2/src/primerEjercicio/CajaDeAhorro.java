package primerEjercicio;

import java.util.UUID;

public class CajaDeAhorro {
	
//	Implemente una clase llamada CajaDeAhorro, cuyo estado interno esté
//	representado por un número de caja de ahorro y un saldo monetario. Se debeen
//	proveer operaciones para averiguar el saldo y para realizar depósitos y
//	extracciones.
	

    private String idCaja;
    private int saldo;
    
    //--------------Constructores--------------
    public CajaDeAhorro() {
    	this.idCaja = UUID.randomUUID().toString();
    	
    	
    }
    
    public CajaDeAhorro(int saldo) {
    	this.idCaja = UUID.randomUUID().toString();
    	this.saldo = saldo;
    }
	
	//--------------Getter--------------
    
    public int getSaldo() {
    	return saldo;
    }
    
    public String getNumCaja() {
    	return idCaja;
    }
    
    //--------------Setter--------------
    
    public void setDeposito(int saldo) {
    	this.saldo += saldo;
    }
    
    public void setExtraccion(int saldo) {
    	if (saldo > this.saldo){
    		System.out.println("No se cuenta con esa cantidad de dinero para extraer");
    	}else {
    		
    		this.saldo -= saldo;
    	}
    }
    


}
