package br.com.programacaoempar;

public class Nasa {
    //private String v[] = new String[];
    private int x = 0;

    private int y = 0;
    private String coordenada = "N";
    //private String coordenadaLimitada = coordenada.length() <= 5 ? coordenada : coordenada.substring(0, 5);
    private String erro = "400 Bad Request";

    public String getPosicaoAtual() {
        return "(" + x + "," + y + "," + coordenada + ")";
    }

    public String getDimensao() {
        if (y >= 6) {
            return "400 Bad Request";
        }
        if (x >= 6) {
            return "400 Bad Request";
        }
        if (y <= -6) {
            return "400 Bad Request";
        }
        if (x <= -6) {
            return "400 Bad Request";
        } else
            return getPosicaoAtual();
    }

    public String getMovimentar(String comandos) {
        for (String comando : comandos.split("")) {
            if ("M".equals(comando)) {
                if ("N".equals(coordenada))
                    y = y + 1;
                if ("W".equals(coordenada))
                    x = x - 1;
                if ("S".equals(coordenada))
                    y = y - 1;
                if ("E".equals(coordenada))
                    x = x + 1;
            } else if ("L".equals(comando)) {
                if ("N".equals(coordenada)) {
                    coordenada = "W";
                } else if ("W".equals(coordenada)) {
                    coordenada = "S";
                } else if ("S".equals(coordenada)) {
                    coordenada = "E";
                } else if ("E".equals(coordenada)) {
                    coordenada = "N";
                }

            } else if ("R".equals(comando)) {
                if ("N".equals(coordenada)) {
                    coordenada = "E";
                } else if ("E".equals(coordenada)) {
                    coordenada = "S";
                } else if ("S".equals(coordenada)) {
                    coordenada = "W";
                } else if ("W".equals(coordenada)) {
                    coordenada = "N";
                }
            } else return "400 Bad Request";
        }

        return getDimensao();
    }

}


