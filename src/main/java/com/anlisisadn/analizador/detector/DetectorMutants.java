package com.anlisisadn.analizador.detector;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectorMutants {
    //Pattern secuenciaADN = Pattern.compile(".*CCCC.*|.*AAAA.*|.*GGGG.*|.*TTTT.*");
    Pattern secuenciaADN = Pattern.compile("CCCC|AAAA|GGGG|TTTT");
    Pattern cadenaValida = Pattern.compile("[^aA|Cc|gG|tT]");
    Matcher matcher;
    int cadenaADN = 0;

    public DetectorMutants() {
    }

    public boolean isMuntant(String[] dna) {
        try {
            for (String adn : dna) {
                if (cadenaValida.matcher(adn).find()) {
                    return false;
                }
            }
            if (searchRowsColumnsMainDiagonales(dna) > 1) {
                return true;
            }
            if (diagonalesMatriz(dna) > 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public int searchRowsColumnsMainDiagonales(String[] dna) {
        String diagonalPrincipal1 = "", diagonalPrincipal2 = "", columna = "";
        int desde;
        for (int i = 0; i < dna.length; i++) {
            if (cadenaADN > 1) break;
            columna = "";
            desde = 0;
            matcher = secuenciaADN.matcher(dna[i].toUpperCase());
            while (matcher.find(desde)) {
                cadenaADN++;
                desde = matcher.start() + 1;
            }
            int longitudColumna = dna[i].length();
            for (int j = 0; j < longitudColumna; j++) {
                if (i == j) {
                    diagonalPrincipal1 += dna[i].charAt(j);
                }
                if ((i + j) == (longitudColumna - 1)) {
                    diagonalPrincipal2 += dna[i].charAt(j);
                }
                columna += dna[j].charAt(i);
            }
            desde = 0;
            matcher = secuenciaADN.matcher(columna.toUpperCase());
            while (matcher.find(desde)) {
                cadenaADN++;
                desde = matcher.start() + 1;
            }
        }
        desde = 0;
        matcher = secuenciaADN.matcher(diagonalPrincipal1.toUpperCase());
        while (matcher.find(desde)) {
            cadenaADN++;
            desde = matcher.start() + 1;
        }
        desde = 0;
        matcher = secuenciaADN.matcher(diagonalPrincipal2.toUpperCase());
        while (matcher.find(desde)) {
            cadenaADN++;
            desde = matcher.start() + 1;
        }
        return cadenaADN;
    }

    public int diagonalesMatriz(String[] adn) {
        //obtenemos ancho y alto de la matriz
        int altura = adn.length, anchura = adn[0].length();
        //declaramos variables para llevar diagonales
        String diagonalPrincipal, diagonalSecundaria;
        //entero que me controla el eje y para las diagonales segundarias
        int yeDiagonalSegundaria;
        int desde;
        for (int diagonal = 1 - anchura; diagonal <= altura - 1; diagonal += 1) {
            diagonalPrincipal = "";
            diagonalSecundaria = "";
            desde = 0;
            for (int vertical = Math.max(0, diagonal), horizontal = -Math.min(0, diagonal);
                 vertical < altura && horizontal < anchura; vertical += 1, horizontal += 1) {
                yeDiagonalSegundaria = altura - 1 - vertical;
                if (vertical != horizontal) {
                    diagonalPrincipal = diagonalPrincipal + adn[vertical].charAt(horizontal);
                }
                if (horizontal != yeDiagonalSegundaria) {
                    diagonalSecundaria = diagonalSecundaria + adn[horizontal].charAt(yeDiagonalSegundaria);
                }
            }
            matcher = secuenciaADN.matcher(diagonalPrincipal.toUpperCase());
            while (matcher.find(desde)) {
                cadenaADN++;
                desde = matcher.start() + 1;
            }
            desde = 0;
            matcher = secuenciaADN.matcher(diagonalSecundaria.toUpperCase());
            while (matcher.find(desde)) {
                cadenaADN++;
                desde = matcher.start() + 1;
            }
        }
        return cadenaADN;
    }
}
