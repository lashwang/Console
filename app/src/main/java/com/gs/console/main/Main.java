package com.gs.console.main;


import com.gs.core.security.GsSecurityManager;
import java.util.List;
import java.util.ArrayList;





public class Main {

    private static final String PreinstalledCAAlias = "user:1cc67baa.0";



    public static void main(String[] args){
        if(args.length >= 1){
            if("install_ca".equals(args[0])){
                delete_all_user_ca();
                install_ca();
            }
        }else {
            test_gs_security_api();
        }
    }


    public static void install_ca(){
        GsSecurityManager.instance().installCaCert("system/etc/console_assets/cacrt.crt");
    }

    public static void delete_all_user_ca(){
        List<String> all_CAs = GsSecurityManager.instance().getAllCaAliases();
        for(String alias:all_CAs){
            if(alias.contains("user")){
                GsSecurityManager.instance().decodeCaAlias(alias);
            }
        }
    }


    public static void test_gs_security_api(){
        List<String> system_ca_list =  GsSecurityManager.instance().getSystemCaAliases();

        System.out.println("all system ca list size:" + system_ca_list.size());
        for(String alias:system_ca_list){
            System.out.println(alias);
        }

        String path = GsSecurityManager.instance().fileForCaAlias(PreinstalledCAAlias);
        System.out.println(path);


        List<String> ca_list = new ArrayList<>();
        ca_list.add("system:5046c355.0");
        ca_list.add(PreinstalledCAAlias);
        ca_list.add("system:10531352.0");

        GsSecurityManager.instance().combineCaAliasToFile(ca_list,"/data/misc/wifi/ca.pem");
    }
}
