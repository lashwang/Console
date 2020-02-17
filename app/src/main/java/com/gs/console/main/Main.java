package com.gs.console.main;


import com.gs.core.security.GsSecurityManager;
import java.util.List;
import java.util.ArrayList;
import android.app.admin.IDevicePolicyManager;
import android.content.Context;
import android.os.ServiceManager;
import android.os.UserHandle;






public class Main {

    private static final String PreinstalledCAAlias = "user:1cc67baa.0";



    public static void main(String[] args){
        if(args.length >= 1){
            if("install_ca".equals(args[0])){
                delete_all_user_ca();
                install_ca();
            }else if("check_ca".equals(args[0])){
                check_ca_valid();
            }else if("delete_ca".equals(args[0])){
                delete_all_user_ca();
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
                GsSecurityManager.instance().deleteCaAlias(alias);
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


    public static void check_ca_valid(){
        try {
            IDevicePolicyManager dpm = IDevicePolicyManager.Stub.asInterface(ServiceManager.getService(Context.DEVICE_POLICY_SERVICE));

            boolean approved = dpm.isCaCertApproved(PreinstalledCAAlias, UserHandle.myUserId());

            System.out.println("Ca approved:" + approved);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
