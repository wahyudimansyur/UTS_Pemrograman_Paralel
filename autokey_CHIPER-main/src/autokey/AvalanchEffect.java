/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokey;
import java.*;
/**
 *
 * @author arya
 */
public class AvalanchEffect {
     public double hitAvalnche(String hasilenkrip, String hasildekrip) { 
        StringBuilder hasil1 = ambilBit(hasilenkrip);
        StringBuilder hasil2 = ambilBit(hasildekrip);
        
        int jmlhbit = hasil1.length();
        int jmlhbitberbeda = 0;

        if (hasil1.length() == hasil2.length()) {
            for (int i = 0; i < jmlhbit; i++) {
                if (hasil1.charAt(i) != hasil2.charAt(i)) {
                    jmlhbitberbeda = jmlhbitberbeda + 1;
                }
            }
        }else {
            return 0;
        }
        
        return (jmlhbitberbeda * 100) / jmlhbit;
    }

    private StringBuilder ambilBit(String kalimat) {
        byte[] bytes = kalimat.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            binary.append("");
        }
        return binary;
    }
}
