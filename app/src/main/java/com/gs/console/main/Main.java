package com.gs.console.main;


import com.gs.core.security.GsSecurityManager;
import java.util.List;

public class Main {
    public static void main(String[] args){
        test_gs_security_api();
    }


    public static void test_gs_security_api(){
        List<String> system_ca_list =  GsSecurityManager.instance().getSystemCaAliases();

        System.out.println("all system ca list size:" + system_ca_list.size());
        for(String alias:system_ca_list){
            System.out.println(alias);
        }
    }
}
