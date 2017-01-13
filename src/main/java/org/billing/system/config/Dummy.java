package org.billing.system.config;

import java.util.*;

/**
 * Created by msahel on 10/12/2016.
 */
public class Dummy {

    public static void main (String[] args){
        HashMap map=new HashMap();
        map.put("Book1","Angle&Demons");
        map.put("Book2","Angle2");
        map.put("Book3","Angle3");

        Set entries=map.entrySet();
        Iterator itr=entries.iterator();

        while(itr.hasNext()){
            Map.Entry entry= (Map.Entry) itr.next();
            System.out.println("values:"+entry.getValue());
        }

        System.out.println("Book1 name:"+map.remove("Book1"));

         entries=map.entrySet();
         itr=entries.iterator();

        while(itr.hasNext()){
            Map.Entry entry= (Map.Entry) itr.next();
            System.out.println("values:"+entry.getValue());
        }
    }
}
