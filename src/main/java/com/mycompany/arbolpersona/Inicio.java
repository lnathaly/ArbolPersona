/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arbolpersona;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author Laura
 */
public class Inicio {

    private Map<Integer, Persona> mapaAbuelos;
    
    public String ingresarPersona(){
    
      mapaAbuelos = new HashMap<>();
       Persona pJuan = new Persona(1, "Juan");
       
       mapaAbuelos.put(1, pJuan);
       mapaAbuelos.put(2, new Persona (2, "Jose"));
       
       Persona pAndres = new Persona(3, "Andres");
       Persona pMaria = new Persona(4, "Maria");
       Persona pCarlos = new Persona(5, "Carlos");
       pJuan.getMapaPersona().put(3, pAndres);
       pJuan.getMapaPersona().put(4, pMaria);
       pJuan.getMapaPersona().put(5, pCarlos);
       
       
       Persona pJuana = new Persona(9, "Juana");
       Persona pPaola = new Persona(10, "Paola");
       Persona pSofia = new Persona(11, "Sofia");
       Persona pJaime = new Persona(12, "Jaime");
       
       pAndres.getMapaPersona().put(9, pJuana);
       pAndres.getMapaPersona().put(10, pPaola);
       pMaria.getMapaPersona().put(11, pSofia);
       pCarlos.getMapaPersona().put(12, pJaime);
       
       //____________________________________________________________________________
       
       
      mapaAbuelos.get(2).getMapaPersona().put(6, new Persona (6, "Alberto"));
      mapaAbuelos.get(2).getMapaPersona().put(7, new Persona (7, "Jimmy"));
      mapaAbuelos.get(2).getMapaPersona().put(8, new Persona (8, "Jhon"));
      mapaAbuelos.get(2).getMapaPersona().get(6).getMapaPersona().put(13, new Persona (13, "Tatiana"));
      mapaAbuelos.get(2).getMapaPersona().get(6).getMapaPersona().put(14, new Persona (14, "Fernando"));
      mapaAbuelos.get(2).getMapaPersona().get(7).getMapaPersona().put(15, new Persona (15, "Viviana"));
      mapaAbuelos.get(2).getMapaPersona().get(8).getMapaPersona().put(16, new Persona (16, "Diana"));
       
      int identificacion =2;
      String respuesta= null;


       for (Integer key : mapaAbuelos.keySet()){
           Persona pAbuelo = mapaAbuelos.get(key);
           if(key == identificacion){
           
             respuesta = pAbuelo.getNombre();
             System.out.println("         "+respuesta);
           }else{
               for(Integer key2 : pAbuelo.getMapaPersona().keySet()){
                   
                   Persona pPadre = pAbuelo.getMapaPersona().get(key2);
                   if(key2 == identificacion){
                       respuesta =(pAbuelo.getNombre()+pPadre.getNombre());
                       System.out.println("     "+ pAbuelo.getNombre());
                       System.out.println("         "+pPadre.getNombre());
                   }else {
                       for(Integer key3 : pPadre.getMapaPersona().keySet()){
                                                   
                           Persona pHijo = pPadre.getMapaPersona().get(key3);
                       if(key3 == identificacion){
                           System.out.println("     "+ pAbuelo.getNombre());
                           System.out.println("         "+pPadre.getNombre());
                           System.out.println("             "+ pHijo.getNombre());
                           respuesta=(pAbuelo.getNombre()+pPadre.getNombre()+pHijo.getNombre());
                        }
                    }
                }
            }           
        }      
        }
       return respuesta;
    }
}
