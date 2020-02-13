package com.gs.console.main;


import com.android.org.conscrypt.TrustedCertificateStore;

import java.util.Set;

public class Main {
    public static void main(String[] args){
        TrustedCertificateStore mStore = new TrustedCertificateStore();
        Set<String> userList = mStore.userAliases();
        System.out.println("User cert number:" + userList.size());
        for(String alias:userList){
            System.out.println("User alias:" + alias);
        }
    }
}
