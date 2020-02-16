package com.gs.console.main;


import com.gs.core.security.GsSecurityManager;
import java.util.List;
import java.util.ArrayList;


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

        String path = GsSecurityManager.instance().fileForCaAlias("user:a6a23a50.0");
        System.out.println(path);


        List<String> ca_list = new ArrayList<>();
        ca_list.add("system:5046c355.0");
        ca_list.add("user:a6a23a50.0");
        ca_list.add("system:10531352.0");

        GsSecurityManager.instance().combineCaAliasToFile(ca_list,"/data/misc/wifi/ca.pem");
    }
}
