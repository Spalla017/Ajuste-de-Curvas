import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void ajusteLinear(ArrayList<Double> x, ArrayList<Double> y, int tamanho) {
        ArrayList<Double> xAoQuadrado = new ArrayList();
        ArrayList<Double> xVezesY = new ArrayList();
        ArrayList<Double> yAjustado = new ArrayList();
        ArrayList<Double> yMenosYAjustadoAoQuadrado = new ArrayList();
        ArrayList<Double> yAoQuadrado = new ArrayList();
        double somatorioX = 0.0;
        double somatorioY = 0.0;
        double somatarioXAoQuadrado = 0.0;
        double somatarioXVezesY = 0.0;
        double somatorioYAjustado = 0.0;
        double somatorioYMenosYAjustadoAoQuadrado = 0.0;
        double somatorioYAoQuadrado = 0.0;
        double a0 = 0.0;
        double a1 = 0.0;
        double rAoQuadrado = 0.0;

        int i;
        for(i = 0; i < tamanho; ++i) {
            xAoQuadrado.add(Math.pow((Double)x.get(i), 2.0));
            xVezesY.add((Double)x.get(i) * (Double)y.get(i));
            yAoQuadrado.add(Math.pow((Double)y.get(i), 2.0));
        }

        Double numeros;
        Iterator var30;
        for(var30 = x.iterator(); var30.hasNext(); somatorioX += numeros) {
            numeros = (Double)var30.next();
        }

        for(var30 = y.iterator(); var30.hasNext(); somatorioY += numeros) {
            numeros = (Double)var30.next();
        }

        for(var30 = xAoQuadrado.iterator(); var30.hasNext(); somatarioXAoQuadrado += numeros) {
            numeros = (Double)var30.next();
        }

        for(var30 = xVezesY.iterator(); var30.hasNext(); somatarioXVezesY += numeros) {
            numeros = (Double)var30.next();
        }

        for(var30 = yAoQuadrado.iterator(); var30.hasNext(); somatorioYAoQuadrado += numeros) {
            numeros = (Double)var30.next();
        }

        a0 = (somatarioXAoQuadrado * somatorioY - somatorioX * somatarioXVezesY) / ((double)tamanho * somatarioXAoQuadrado - Math.pow(somatorioX, 2.0));
        a1 = ((double)tamanho * somatarioXVezesY - somatorioX * somatorioY) / ((double)tamanho * somatarioXAoQuadrado - Math.pow(somatorioX, 2.0));

        for(i = 0; i < tamanho; ++i) {
            yAjustado.add(a0 + a1 * (Double)x.get(i));
            yMenosYAjustadoAoQuadrado.add(Math.pow((Double)y.get(i) - (Double)yAjustado.get(i), 2.0));
        }

        for(var30 = yAjustado.iterator(); var30.hasNext(); somatorioYAjustado += numeros) {
            numeros = (Double)var30.next();
        }

        for(var30 = yMenosYAjustadoAoQuadrado.iterator(); var30.hasNext(); somatorioYMenosYAjustadoAoQuadrado += numeros) {
            numeros = (Double)var30.next();
        }

        rAoQuadrado = 1.0 - (double)tamanho * somatorioYMenosYAjustadoAoQuadrado / ((double)tamanho * somatorioYAoQuadrado - Math.pow(somatorioYAjustado, 2.0));
        System.out.println(rAoQuadrado);
    }

    public static void ajusteParabolico(ArrayList<Double> x, ArrayList<Double> y, int tamanho) {
        ArrayList<Double> xAoQuadrado = new ArrayList();
        ArrayList<Double> xAoCubo = new ArrayList();
        ArrayList<Double> xElevadoAquatro = new ArrayList();
        ArrayList<Double> xVezesY = new ArrayList();
        ArrayList<Double> xAoQuadradoVezesY = new ArrayList();
        double somatorioX = 0.0;
        double somatorioY = 0.0;
        double somatarioXAoQuadrado = 0.0;
        double somatorioXAoCubo = 0.0;
        double somatorioXElevadoAQuatro = 0.0;
        double somatarioXVezesY = 0.0;
        double somatorioXAoQuadradoVezesY = 0.0;

        for(int i = 0; i < tamanho; ++i) {
            xAoQuadrado.add(Math.pow((Double)x.get(i), 2.0));
            xAoCubo.add(Math.pow((Double)x.get(i), 3.0));
            xElevadoAquatro.add(Math.pow((Double)x.get(i), 4.0));
            xVezesY.add((Double)x.get(i) * (Double)y.get(i));
            xAoQuadradoVezesY.add(Math.pow((Double)x.get(i), 2.0) * (Double)y.get(i));
        }

        Double numeros;
        Iterator var30;
        for(var30 = x.iterator(); var30.hasNext(); somatorioX += numeros) {
            numeros = (Double)var30.next();
        }

        for(var30 = y.iterator(); var30.hasNext(); somatorioY += numeros) {
            numeros = (Double)var30.next();
        }

        for(var30 = xAoQuadrado.iterator(); var30.hasNext(); somatarioXAoQuadrado += numeros) {
            numeros = (Double)var30.next();
        }

        for(var30 = xAoCubo.iterator(); var30.hasNext(); somatorioXAoCubo += numeros) {
            numeros = (Double)var30.next();
        }

        for(var30 = xElevadoAquatro.iterator(); var30.hasNext(); somatorioXElevadoAQuatro += numeros) {
            numeros = (Double)var30.next();
        }

        for(var30 = xVezesY.iterator(); var30.hasNext(); somatarioXVezesY += numeros) {
            numeros = (Double)var30.next();
        }

        for(var30 = xAoQuadradoVezesY.iterator(); var30.hasNext(); somatorioXAoQuadradoVezesY += numeros) {
            numeros = (Double)var30.next();
        }

        double[][] matrizA = new double[][]{{(double)tamanho, somatorioX, somatarioXAoQuadrado}, {somatorioX, somatarioXAoQuadrado, somatorioXAoCubo}, {somatarioXAoQuadrado, somatorioXAoCubo, somatorioXElevadoAQuatro}};
        double[] matrizB = new double[]{somatorioY, somatarioXVezesY, somatorioXAoQuadradoVezesY};
        double[] resposta = new double[]{0.0, 0.0, 0.0};

        for(int i = 0; i < 3; ++i) {
            double somatorio = 0.0;
            int z = 0;

            for(int j = 0; j < 3; ++j) {
                somatorio += matrizA[i][j] * matrizB[z];
                System.out.println("valor somatorio: " + somatorio);
                ++z;
            }

            System.out.println("valor somatorio final:" + somatorio);
            resposta[i] = somatorio;
        }

    }

    public static void ajusteExponencial(ArrayList<Double> x, ArrayList<Double> y, int tamanho) {
        ArrayList<Double> yLinha = new ArrayList();

        for(int i = 0; i < y.size(); ++i) {
            yLinha.add(Math.log((Double)y.get(i)));
        }

        ArrayList<Double> xAoQuadrado = new ArrayList();
        ArrayList<Double> xVezesY = new ArrayList();
        ArrayList<Double> yAjustado = new ArrayList();
        ArrayList<Double> yMenosYAjustadoAoQuadrado = new ArrayList();
        ArrayList<Double> yAoQuadrado = new ArrayList();
        double somatorioX = 0.0;
        double somatorioY = 0.0;
        double somatarioXAoQuadrado = 0.0;
        double somatarioXVezesY = 0.0;
        double somatorioYAjustado = 0.0;
        double somatorioYMenosYAjustadoAoQuadrado = 0.0;
        double somatorioYAoQuadrado = 0.0;
        double a = 0.0;
        double b = 0.0;
        double a0 = 0.0;
        double a1 = 0.0;
        double rAoQuadrado = 0.0;

        int i;
        for(i = 0; i < tamanho; ++i) {
            xAoQuadrado.add(Math.pow((Double)x.get(i), 2.0));
            xVezesY.add((Double)x.get(i) * (Double)yLinha.get(i));
            yAoQuadrado.add(Math.pow((Double)yLinha.get(i), 2.0));
        }

        Double numeros;
        Iterator var36;
        for(var36 = x.iterator(); var36.hasNext(); somatorioX += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = yLinha.iterator(); var36.hasNext(); somatorioY += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = xAoQuadrado.iterator(); var36.hasNext(); somatarioXAoQuadrado += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = xVezesY.iterator(); var36.hasNext(); somatarioXVezesY += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = yAoQuadrado.iterator(); var36.hasNext(); somatorioYAoQuadrado += numeros) {
            numeros = (Double)var36.next();
        }

        a0 = (somatarioXAoQuadrado * somatorioY - somatorioX * somatarioXVezesY) / ((double)tamanho * somatarioXAoQuadrado - Math.pow(somatorioX, 2.0));
        a1 = ((double)tamanho * somatarioXVezesY - somatorioX * somatorioY) / ((double)tamanho * somatarioXAoQuadrado - Math.pow(somatorioX, 2.0));

        for(i = 0; i < tamanho; ++i) {
            yAjustado.add(a0 + a1 * (Double)x.get(i));
            yMenosYAjustadoAoQuadrado.add(Math.pow((Double)yLinha.get(i) - (Double)yAjustado.get(i), 2.0));
        }

        for(var36 = yAjustado.iterator(); var36.hasNext(); somatorioYAjustado += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = yMenosYAjustadoAoQuadrado.iterator(); var36.hasNext(); somatorioYMenosYAjustadoAoQuadrado += numeros) {
            numeros = (Double)var36.next();
        }

        a = Math.pow(Math.E, a0);
        rAoQuadrado = 1.0 - (double)tamanho * somatorioYMenosYAjustadoAoQuadrado / ((double)tamanho * somatorioYAoQuadrado - Math.pow(somatorioYAjustado, 2.0));
        System.out.println(rAoQuadrado);
    }

    public static void ajusteLogaritmico(ArrayList<Double> x, ArrayList<Double> y, int tamanho) {
        ArrayList<Double> xLinha = new ArrayList();

        for(int i = 0; i < x.size(); ++i) {
            xLinha.add(Math.log((Double)x.get(i)));
        }

        ArrayList<Double> xAoQuadrado = new ArrayList();
        ArrayList<Double> xVezesY = new ArrayList();
        ArrayList<Double> yAjustado = new ArrayList();
        ArrayList<Double> yMenosYAjustadoAoQuadrado = new ArrayList();
        ArrayList<Double> yAoQuadrado = new ArrayList();
        double somatorioX = 0.0;
        double somatorioY = 0.0;
        double somatarioXAoQuadrado = 0.0;
        double somatarioXVezesY = 0.0;
        double somatorioYAjustado = 0.0;
        double somatorioYMenosYAjustadoAoQuadrado = 0.0;
        double somatorioYAoQuadrado = 0.0;
        double a = 0.0;
        double b = 0.0;
        double a0 = 0.0;
        double a1 = 0.0;
        double rAoQuadrado = 0.0;

        int i;
        for(i = 0; i < tamanho; ++i) {
            xAoQuadrado.add(Math.pow((Double)xLinha.get(i), 2.0));
            xVezesY.add((Double)xLinha.get(i) * (Double)y.get(i));
            yAoQuadrado.add(Math.pow((Double)y.get(i), 2.0));
        }

        Double numeros;
        Iterator var36;
        for(var36 = xLinha.iterator(); var36.hasNext(); somatorioX += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = y.iterator(); var36.hasNext(); somatorioY += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = xAoQuadrado.iterator(); var36.hasNext(); somatarioXAoQuadrado += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = xVezesY.iterator(); var36.hasNext(); somatarioXVezesY += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = yAoQuadrado.iterator(); var36.hasNext(); somatorioYAoQuadrado += numeros) {
            numeros = (Double)var36.next();
        }

        a0 = (somatarioXAoQuadrado * somatorioY - somatorioX * somatarioXVezesY) / ((double)tamanho * somatarioXAoQuadrado - Math.pow(somatorioX, 2.0));
        a1 = ((double)tamanho * somatarioXVezesY - somatorioX * somatorioY) / ((double)tamanho * somatarioXAoQuadrado - Math.pow(somatorioX, 2.0));

        for(i = 0; i < tamanho; ++i) {
            yAjustado.add(a0 + a1 * (Double)xLinha.get(i));
            yMenosYAjustadoAoQuadrado.add(Math.pow((Double)y.get(i) - (Double)yAjustado.get(i), 2.0));
        }

        for(var36 = yAjustado.iterator(); var36.hasNext(); somatorioYAjustado += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = yMenosYAjustadoAoQuadrado.iterator(); var36.hasNext(); somatorioYMenosYAjustadoAoQuadrado += numeros) {
            numeros = (Double)var36.next();
        }

        rAoQuadrado = 1.0 - (double)tamanho * somatorioYMenosYAjustadoAoQuadrado / ((double)tamanho * somatorioYAoQuadrado - Math.pow(somatorioYAjustado, 2.0));
        System.out.println(rAoQuadrado);
    }

    public static void ajustePotencial(ArrayList<Double> x, ArrayList<Double> y, int tamanho) {
        ArrayList<Double> xLinha = new ArrayList();
        ArrayList<Double> yLinha = new ArrayList();

        int i;
        for(i = 0; i < x.size(); ++i) {
            xLinha.add(Math.log((Double)x.get(i)));
        }

        for(i = 0; i < y.size(); ++i) {
            yLinha.add(Math.log((Double)y.get(i)));
        }

        ArrayList<Double> xAoQuadrado = new ArrayList();
        ArrayList<Double> xVezesY = new ArrayList();
        ArrayList<Double> yAjustado = new ArrayList();
        ArrayList<Double> yMenosYAjustadoAoQuadrado = new ArrayList();
        ArrayList<Double> yAoQuadrado = new ArrayList();
        double somatorioX = 0.0;
        double somatorioY = 0.0;
        double somatarioXAoQuadrado = 0.0;
        double somatarioXVezesY = 0.0;
        double somatorioYAjustado = 0.0;
        double somatorioYMenosYAjustadoAoQuadrado = 0.0;
        double somatorioYAoQuadrado = 0.0;
        double a = 0.0;
        double b = 0.0;
        double a0 = 0.0;
        double a1 = 0.0;
        double rAoQuadrado = 0.0;

        int i;
        for(i = 0; i < tamanho; ++i) {
            xAoQuadrado.add(Math.pow((Double)xLinha.get(i), 2.0));
            xVezesY.add((Double)xLinha.get(i) * (Double)yLinha.get(i));
            yAoQuadrado.add(Math.pow((Double)yLinha.get(i), 2.0));
        }

        Double numeros;
        Iterator var37;
        for(var37 = xLinha.iterator(); var37.hasNext(); somatorioX += numeros) {
            numeros = (Double)var37.next();
        }

        for(var37 = yLinha.iterator(); var37.hasNext(); somatorioY += numeros) {
            numeros = (Double)var37.next();
        }

        for(var37 = xAoQuadrado.iterator(); var37.hasNext(); somatarioXAoQuadrado += numeros) {
            numeros = (Double)var37.next();
        }

        for(var37 = xVezesY.iterator(); var37.hasNext(); somatarioXVezesY += numeros) {
            numeros = (Double)var37.next();
        }

        for(var37 = yAoQuadrado.iterator(); var37.hasNext(); somatorioYAoQuadrado += numeros) {
            numeros = (Double)var37.next();
        }

        a0 = (somatarioXAoQuadrado * somatorioY - somatorioX * somatarioXVezesY) / ((double)tamanho * somatarioXAoQuadrado - Math.pow(somatorioX, 2.0));
        a1 = ((double)tamanho * somatarioXVezesY - somatorioX * somatorioY) / ((double)tamanho * somatarioXAoQuadrado - Math.pow(somatorioX, 2.0));
        a = Math.pow(Math.E, a0);
        b = a1;

        for(i = 0; i < tamanho; ++i) {
            yAjustado.add(a * Math.pow((Double)xLinha.get(i), b));
            PrintStream var10000 = System.out;
            Object var10001 = yAjustado.get(i);
            var10000.println("yaj = " + (Double)var10001);
            yMenosYAjustadoAoQuadrado.add(Math.pow((Double)y.get(i) - (Double)yAjustado.get(i), 2.0));
        }

        for(var37 = yAjustado.iterator(); var37.hasNext(); somatorioYAjustado += numeros) {
            numeros = (Double)var37.next();
        }

        for(var37 = yMenosYAjustadoAoQuadrado.iterator(); var37.hasNext(); somatorioYMenosYAjustadoAoQuadrado += numeros) {
            numeros = (Double)var37.next();
        }

        rAoQuadrado = 1.0 - (double)tamanho * somatorioYMenosYAjustadoAoQuadrado / ((double)tamanho * somatorioYAoQuadrado - Math.pow(somatorioYAjustado, 2.0));
        System.out.println(rAoQuadrado);
    }

    public static void ajusteHiperbolico(ArrayList<Double> x, ArrayList<Double> y, int tamanho) {
        for(int i = 0; i < x.size(); ++i) {
            double xNovo = 0.0;
            xNovo = 1.0 / (Double)x.get(i);
            x.set(i, xNovo);
        }

        ArrayList<Double> xAoQuadrado = new ArrayList();
        ArrayList<Double> xVezesY = new ArrayList();
        ArrayList<Double> yAjustado = new ArrayList();
        ArrayList<Double> yMenosYAjustadoAoQuadrado = new ArrayList();
        ArrayList<Double> yAoQuadrado = new ArrayList();
        double somatorioX = 0.0;
        double somatorioY = 0.0;
        double somatarioXAoQuadrado = 0.0;
        double somatarioXVezesY = 0.0;
        double somatorioYAjustado = 0.0;
        double somatorioYMenosYAjustadoAoQuadrado = 0.0;
        double somatorioYAoQuadrado = 0.0;
        double a = 0.0;
        double b = 0.0;
        double a0 = 0.0;
        double a1 = 0.0;
        double rAoQuadrado = 0.0;

        int i;
        for(i = 0; i < tamanho; ++i) {
            xAoQuadrado.add(Math.pow((Double)x.get(i), 2.0));
            xVezesY.add((Double)x.get(i) * (Double)y.get(i));
            yAoQuadrado.add(Math.pow((Double)y.get(i), 2.0));
        }

        Double numeros;
        Iterator var36;
        for(var36 = x.iterator(); var36.hasNext(); somatorioX += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = y.iterator(); var36.hasNext(); somatorioY += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = xAoQuadrado.iterator(); var36.hasNext(); somatarioXAoQuadrado += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = xVezesY.iterator(); var36.hasNext(); somatarioXVezesY += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = yAoQuadrado.iterator(); var36.hasNext(); somatorioYAoQuadrado += numeros) {
            numeros = (Double)var36.next();
        }

        a0 = (somatarioXAoQuadrado * somatorioY - somatorioX * somatarioXVezesY) / ((double)tamanho * somatarioXAoQuadrado - Math.pow(somatorioX, 2.0));
        a1 = ((double)tamanho * somatarioXVezesY - somatorioX * somatorioY) / ((double)tamanho * somatarioXAoQuadrado - Math.pow(somatorioX, 2.0));

        for(i = 0; i < tamanho; ++i) {
            yAjustado.add(a0 + a1 * (Double)x.get(i));
            yMenosYAjustadoAoQuadrado.add(Math.pow((Double)y.get(i) - (Double)yAjustado.get(i), 2.0));
        }

        for(var36 = yAjustado.iterator(); var36.hasNext(); somatorioYAjustado += numeros) {
            numeros = (Double)var36.next();
        }

        for(var36 = yMenosYAjustadoAoQuadrado.iterator(); var36.hasNext(); somatorioYMenosYAjustadoAoQuadrado += numeros) {
            numeros = (Double)var36.next();
        }

        if (a1 < 0.0) {
        }

        rAoQuadrado = 1.0 - (double)tamanho * somatorioYMenosYAjustadoAoQuadrado / ((double)tamanho * somatorioYAoQuadrado - Math.pow(somatorioYAjustado, 2.0));
        System.out.println(rAoQuadrado);
    }

    public static void main(String[] args) {
        ArrayList<Double> x = new ArrayList();
        ArrayList<Double> y = new ArrayList();
        int tamanhoTabela = 0;

        try {
            String path = "C://Users//Vhugo//OneDrive//Desktop//data.txt";
            File myFile = new File(path);
            Scanner lerArquivo = new Scanner(myFile);
            LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(myFile));
            linhaLeitura.skip(myFile.length());
            int qtdLinha = linhaLeitura.getLineNumber();
            tamanhoTabela = (qtdLinha + 1) / 2;

            for(int i = 0; i < qtdLinha + 1; ++i) {
                if (lerArquivo.hasNextLine()) {
                    if (i <= qtdLinha / 2) {
                        x.add(lerArquivo.nextDouble());
                    } else {
                        y.add(lerArquivo.nextDouble());
                    }
                }
            }

            lerArquivo.close();
        } catch (IOException var10) {
            System.out.println("Ocorreu um erro ao abrir o arquivo!");
            var10.printStackTrace();
        }

        ajustePotencial(x, y, tamanhoTabela);
    }
}
