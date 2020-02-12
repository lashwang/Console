package com.gs.console;


import com.android.org.conscrypt.TrustedCertificateStore;

import java.util.Set;

public class Main {
    public static void main(String[] args){
        TrustedCertificateStore mStore = new TrustedCertificateStore();
        Set<String> user = mStore.userAliases();
        System.out.println("User cert number:" + user.size());
    }
}
