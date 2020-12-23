package com.avantica.compartamos.domain.tmp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.avantica.compartamos.domain.Banco;

public class BancosDB {

	private static Map<Integer, Banco> bancoDB = new ConcurrentHashMap<Integer, Banco>();
    private static AtomicInteger idCounter = new AtomicInteger();
    
    public static Integer createBanco(String nombre, String direccion){
        Banco b = new Banco();
        b.setId(idCounter.incrementAndGet());
        b.setNombre(nombre);
        b.setDireccion(direccion);
        b.setFechaRegistro(new Date());
        bancoDB.put(b.getId(), b);         
        return b.getId();
    }
    
    public static Banco getBanco(Integer id){
        return bancoDB.get(id);
    }
    
    public static List<Banco> getAll(){
        return new ArrayList<Banco>(bancoDB.values());
    }
    
    public static Banco removeBanco(Integer id){
        return bancoDB.remove(id);
    }
    
    public static Banco updateConfiguration(Integer id, Banco b){
        return bancoDB.put(id, b);
    }
}
