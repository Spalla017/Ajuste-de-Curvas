import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void ajusteLinear(ArrayList<Double> x, ArrayList<Double> y, int tamanho){
        // Arrays com os valores;
        ArrayList<Double> xAoQuadrado = new ArrayList<>() ;
        ArrayList<Double> xVezesY = new ArrayList<>() ;
        ArrayList<Double> yAjustado = new ArrayList<>();
        ArrayList<Double> yMenosYAjustadoAoQuadrado = new ArrayList<>();
        ArrayList<Double> yAoQuadrado = new ArrayList<>();

        // Variaveis
        double somatorioX = 0;
        double somatorioY = 0;
        double somatarioXAoQuadrado = 0;
        double somatarioXVezesY = 0;
        double somatorioYAjustado = 0;
        double somatorioYMenosYAjustadoAoQuadrado = 0;
        double somatorioYAoQuadrado = 0;
        double a0 = 0;
        double a1 = 0;
        double rAoQuadrado = 0;


        // Preenchendo a tabela x ao quadrado e x vezes y
        for(int i= 0 ; i < tamanho;i++){
            xAoQuadrado.add(Math.pow(x.get(i).doubleValue(), 2));
            xVezesY.add(x.get(i).doubleValue()*y.get(i).doubleValue());
            yAoQuadrado.add(Math.pow(y.get(i).doubleValue(), 2));
        }

        //Realizando os Somatorios

        for(Double numeros: x){
            somatorioX += numeros.doubleValue();
        }

        for(Double numeros: y){
            somatorioY += numeros.doubleValue();
        }

        for(Double numeros: xAoQuadrado){
            somatarioXAoQuadrado += numeros.doubleValue();
        }
        for(Double numeros: xVezesY){
            somatarioXVezesY += numeros.doubleValue();
        }
        for(Double numeros: yAoQuadrado){
            somatorioYAoQuadrado += numeros.doubleValue();
        }

        //Calculando a0 e a1
        a0 = ((somatarioXAoQuadrado*somatorioY) - (somatorioX*somatarioXVezesY)) / ((tamanho*somatarioXAoQuadrado) - Math.pow(somatorioX, 2));
        a1 = ((tamanho*somatarioXVezesY) - (somatorioX*somatorioY)) / ((tamanho*somatarioXAoQuadrado) - Math.pow(somatorioX, 2));



        //Preenchendo a tabela do yAjustado e yMenosYAjustadoAoQuadrado
        for(int i = 0; i < tamanho; i++){
            yAjustado.add(a0+(a1*x.get(i).doubleValue()));
            yMenosYAjustadoAoQuadrado.add(Math.pow(y.get(i).doubleValue() - yAjustado.get(i).doubleValue(), 2));
        }

        //Somatorio de yAjustado e yMenosYAjustadoAoQuadrado
        for(Double numeros: yAjustado){
            somatorioYAjustado += numeros.doubleValue();
        }
        for(Double numeros: yMenosYAjustadoAoQuadrado){
            somatorioYMenosYAjustadoAoQuadrado += numeros.doubleValue();
        }

        rAoQuadrado = 1 - (tamanho*somatorioYMenosYAjustadoAoQuadrado) / (tamanho*somatorioYAoQuadrado - (Math.pow(somatorioYAjustado, 2)));

        //System.out.println("y = "+a0+" + "+a1+"x");
        System.out.println(rAoQuadrado);



    }
    public static void ajusteParabolico(ArrayList<Double> x, ArrayList<Double> y, int tamanho){

        // Arrays com os valores;
        ArrayList<Double> xAoQuadrado = new ArrayList<>();
        ArrayList<Double> xAoCubo = new ArrayList<>();
        ArrayList<Double> xElevadoAquatro = new ArrayList<>();
        ArrayList<Double> xVezesY = new ArrayList<>();
        ArrayList<Double> xAoQuadradoVezesY = new ArrayList<>();

        // Variaveis
        double somatorioX = 0;
        double somatorioY = 0;
        double somatarioXAoQuadrado = 0;
        double somatorioXAoCubo = 0;
        double somatorioXElevadoAQuatro = 0;
        double somatarioXVezesY = 0;
        double somatorioXAoQuadradoVezesY = 0;

        // Preenchendo as tableas
        for(int i= 0 ; i < tamanho;i++){
            xAoQuadrado.add(Math.pow(x.get(i).doubleValue(), 2));
            xAoCubo.add(Math.pow(x.get(i).doubleValue(), 3));
            xElevadoAquatro.add(Math.pow(x.get(i).doubleValue(), 4));
            xVezesY.add(x.get(i).doubleValue()*y.get(i).doubleValue());
            xAoQuadradoVezesY.add(Math.pow(x.get(i), 2) * y.get(i));
        }
        //Realizando os Somatorios
        for(Double numeros: x){
            somatorioX += numeros.doubleValue();
        }
        for(Double numeros: y){
            somatorioY += numeros.doubleValue();
        }
        for(Double numeros: xAoQuadrado){
            somatarioXAoQuadrado += numeros.doubleValue();
        }
        for(Double numeros: xAoCubo){
            somatorioXAoCubo += numeros.doubleValue();
        }
        for(Double numeros: xElevadoAquatro){
            somatorioXElevadoAQuatro += numeros.doubleValue();
        }
        for(Double numeros: xVezesY){
            somatarioXVezesY += numeros.doubleValue();
        }
        for(Double numeros: xAoQuadradoVezesY){
            somatorioXAoQuadradoVezesY += numeros.doubleValue();
        }
        //Matriz com os valores
        double[][] matrizA = new double[][]{{tamanho, somatorioX, somatarioXAoQuadrado},{somatorioX, somatarioXAoQuadrado, somatorioXAoCubo},
                {somatarioXAoQuadrado,somatorioXAoCubo,somatorioXElevadoAQuatro}};
        double[] matrizB = new double[]{somatorioY, somatarioXVezesY, somatorioXAoQuadradoVezesY};
        double[] resposta = new double[]{0,0,0};


        for(int i = 0; i < 3; i++){
            double somatorio = 0;
            int z = 0;
            for(int j = 0; j<3; j++){
                somatorio = somatorio + matrizA[i][j] * matrizB[z];
                System.out.println("valor somatorio: "+somatorio);
                z++;
            }
            System.out.println("valor somatorio final:"+ somatorio);
            resposta[i] = somatorio;
        }



    }
    public static void ajusteExponencial(ArrayList<Double> x, ArrayList<Double> y, int tamanho){

        ArrayList<Double> yLinha = new ArrayList<>();
        //Ajustando a variavel de acordo com o método
        for(int i = 0; i < y.size(); i++){
            yLinha.add(Math.log(y.get(i).doubleValue()));

        }

        ArrayList<Double> xAoQuadrado = new ArrayList<>() ;
        ArrayList<Double> xVezesY = new ArrayList<>() ;
        ArrayList<Double> yAjustado = new ArrayList<>();
        ArrayList<Double> yMenosYAjustadoAoQuadrado = new ArrayList<>();
        ArrayList<Double> yAoQuadrado = new ArrayList<>();

        // Variaveis
        double somatorioX = 0;
        double somatorioY = 0;
        double somatarioXAoQuadrado = 0;
        double somatarioXVezesY = 0;
        double somatorioYAjustado = 0;
        double somatorioYMenosYAjustadoAoQuadrado = 0;
        double somatorioYAoQuadrado = 0;
        double a = 0;
        double b = 0;
        double a0 = 0;
        double a1 = 0;
        double rAoQuadrado = 0;

        // Preenchendo a tabela x ao quadrado e x vezes y
        for(int i= 0 ; i < tamanho;i++){
            xAoQuadrado.add(Math.pow(x.get(i).doubleValue(), 2));
            xVezesY.add(x.get(i).doubleValue()*yLinha.get(i).doubleValue());
            yAoQuadrado.add(Math.pow(yLinha.get(i).doubleValue(), 2));
        }

        //Realizando os Somatorios

        for(Double numeros: x){
            somatorioX += numeros.doubleValue();
        }

        for(Double numeros: yLinha){
            somatorioY += numeros.doubleValue();
        }

        for(Double numeros: xAoQuadrado){
            somatarioXAoQuadrado += numeros.doubleValue();
        }
        for(Double numeros: xVezesY){
            somatarioXVezesY += numeros.doubleValue();
        }
        for(Double numeros: yAoQuadrado){
            somatorioYAoQuadrado += numeros.doubleValue();
        }
        //Calculando a0 e a1

        a0 = ((somatarioXAoQuadrado*somatorioY) - (somatorioX*somatarioXVezesY)) / ((tamanho*somatarioXAoQuadrado) - Math.pow(somatorioX, 2));
        a1 = ((tamanho*somatarioXVezesY) - (somatorioX*somatorioY)) / ((tamanho*somatarioXAoQuadrado) - Math.pow(somatorioX, 2));

        //System.out.println(a0);
        //System.out.println(a1);
        //Preenchendo a tabela do yAjustado e yMenosYAjustadoAoQuadrado
        for(int i = 0; i < tamanho; i++){
            yAjustado.add(a0+(a1*x.get(i).doubleValue()));
            yMenosYAjustadoAoQuadrado.add(Math.pow(yLinha.get(i).doubleValue() - yAjustado.get(i).doubleValue(), 2));
        }

        //Somatorio de yAjustado e yMenosYAjustadoAoQuadrado
        for(Double numeros: yAjustado){
            somatorioYAjustado += numeros.doubleValue();
        }
        for(Double numeros: yMenosYAjustadoAoQuadrado){
            somatorioYMenosYAjustadoAoQuadrado += numeros.doubleValue();
        }

        a = Math.pow(Math.E, a0);
        b = a1;

        //System.out.println("y = "+a+" . e^"+b+"x");
        rAoQuadrado = 1 - (tamanho*somatorioYMenosYAjustadoAoQuadrado) / (tamanho*somatorioYAoQuadrado - (Math.pow(somatorioYAjustado, 2)));
        System.out.println(rAoQuadrado);




    }
    public static void ajusteLogaritmico(ArrayList<Double> x, ArrayList<Double> y, int tamanho){

        ArrayList<Double> xLinha = new ArrayList<>();
        //Ajustando a variavel de acordo com o método
        for(int i = 0; i < x.size(); i++){
            xLinha.add(Math.log(x.get(i).doubleValue()));
        }

        ArrayList<Double> xAoQuadrado = new ArrayList<>() ;
        ArrayList<Double> xVezesY = new ArrayList<>() ;
        ArrayList<Double> yAjustado = new ArrayList<>();
        ArrayList<Double> yMenosYAjustadoAoQuadrado = new ArrayList<>();
        ArrayList<Double> yAoQuadrado = new ArrayList<>();

        // Variaveis
        double somatorioX = 0;
        double somatorioY = 0;
        double somatarioXAoQuadrado = 0;
        double somatarioXVezesY = 0;
        double somatorioYAjustado = 0;
        double somatorioYMenosYAjustadoAoQuadrado = 0;
        double somatorioYAoQuadrado = 0;
        double a = 0;
        double b = 0;
        double a0 = 0;
        double a1 = 0;
        double rAoQuadrado = 0;

        // Preenchendo a tabela x ao quadrado e x vezes y
        for(int i= 0 ; i < tamanho;i++){
            xAoQuadrado.add(Math.pow(xLinha.get(i).doubleValue(), 2));
            xVezesY.add(xLinha.get(i).doubleValue()*y.get(i).doubleValue());
            yAoQuadrado.add(Math.pow(y.get(i).doubleValue(), 2));
        }

        //Realizando os Somatorios

        for(Double numeros: xLinha){
            somatorioX += numeros.doubleValue();
        }

        for(Double numeros: y){
            somatorioY += numeros.doubleValue();
        }

        for(Double numeros: xAoQuadrado){
            somatarioXAoQuadrado += numeros.doubleValue();
        }
        for(Double numeros: xVezesY){
            somatarioXVezesY += numeros.doubleValue();
        }
        for(Double numeros: yAoQuadrado){
            somatorioYAoQuadrado += numeros.doubleValue();
        }
        //Calculando a0 e a1

        a0 = ((somatarioXAoQuadrado*somatorioY) - (somatorioX*somatarioXVezesY)) / ((tamanho*somatarioXAoQuadrado) - Math.pow(somatorioX, 2));
        a1 = ((tamanho*somatarioXVezesY) - (somatorioX*somatorioY)) / ((tamanho*somatarioXAoQuadrado) - Math.pow(somatorioX, 2));

        //System.out.println(a0);
        //System.out.println(a1);
        //Preenchendo a tabela do yAjustado e yMenosYAjustadoAoQuadrado
        for(int i = 0; i < tamanho; i++){
            yAjustado.add(a0+(a1*xLinha.get(i).doubleValue()));
            yMenosYAjustadoAoQuadrado.add(Math.pow(y.get(i).doubleValue() - yAjustado.get(i).doubleValue(), 2));
        }

        //Somatorio de yAjustado e yMenosYAjustadoAoQuadrado
        for(Double numeros: yAjustado){
            somatorioYAjustado += numeros.doubleValue();
        }
        for(Double numeros: yMenosYAjustadoAoQuadrado){
            somatorioYMenosYAjustadoAoQuadrado += numeros.doubleValue();
        }

        a = a0;
        b = a1;

        //System.out.println("y = "+a+"+"+b+".lnx");
        rAoQuadrado = 1 - (tamanho*somatorioYMenosYAjustadoAoQuadrado) / (tamanho*somatorioYAoQuadrado - (Math.pow(somatorioYAjustado, 2)));
        System.out.println(rAoQuadrado);
    }
    public static void ajustePotencial(ArrayList<Double> x, ArrayList<Double> y, int tamanho){
        ArrayList<Double> xLinha = new ArrayList<>();
        ArrayList<Double> yLinha = new ArrayList<>();
        //Ajustando a variavel de acordo com o método
        for(int i = 0; i < x.size(); i++){
            xLinha.add(Math.log(x.get(i).doubleValue()));
        }
        for(int i = 0; i < y.size(); i++){
            yLinha.add(Math.log(y.get(i).doubleValue()));
        }


        ArrayList<Double> xAoQuadrado = new ArrayList<>() ;
        ArrayList<Double> xVezesY = new ArrayList<>() ;
        ArrayList<Double> yAjustado = new ArrayList<>();
        ArrayList<Double> yMenosYAjustadoAoQuadrado = new ArrayList<>();
        ArrayList<Double> yAoQuadrado = new ArrayList<>();

        // Variaveis
        double somatorioX = 0;
        double somatorioY = 0;
        double somatarioXAoQuadrado = 0;
        double somatarioXVezesY = 0;
        double somatorioYAjustado = 0;
        double somatorioYMenosYAjustadoAoQuadrado = 0;
        double somatorioYAoQuadrado = 0;
        double a = 0;
        double b = 0;
        double a0 = 0;
        double a1 = 0;
        double rAoQuadrado = 0;

        // Preenchendo a tabela x ao quadrado e x vezes y
        for(int i= 0 ; i < tamanho;i++){
            xAoQuadrado.add(Math.pow(xLinha.get(i).doubleValue(), 2));
            xVezesY.add(xLinha.get(i).doubleValue()*yLinha.get(i).doubleValue());
            yAoQuadrado.add(Math.pow(yLinha.get(i).doubleValue(), 2));
        }

        //Realizando os Somatorios

        for(Double numeros: xLinha){
            somatorioX += numeros.doubleValue();
        }

        for(Double numeros: yLinha){
            somatorioY += numeros.doubleValue();
        }

        for(Double numeros: xAoQuadrado){
            somatarioXAoQuadrado += numeros.doubleValue();
        }
        for(Double numeros: xVezesY){
            somatarioXVezesY += numeros.doubleValue();
        }
        for(Double numeros: yAoQuadrado){
            somatorioYAoQuadrado += numeros.doubleValue();
        }
        //Calculando a0 e a1

        a0 = ((somatarioXAoQuadrado*somatorioY) - (somatorioX*somatarioXVezesY)) / ((tamanho*somatarioXAoQuadrado) - Math.pow(somatorioX, 2));
        a1 = ((tamanho*somatarioXVezesY) - (somatorioX*somatorioY)) / ((tamanho*somatarioXAoQuadrado) - Math.pow(somatorioX, 2));

        //System.out.println(a0);
        //System.out.println(a1);
        //Preenchendo a tabela do yAjustado e yMenosYAjustadoAoQuadrado
        for(int i = 0; i < tamanho; i++){
            yAjustado.add(a0*(Math.pow(xLinha.get(i).doubleValue(),a1)));
            yMenosYAjustadoAoQuadrado.add(Math.pow(y.get(i).doubleValue() - yAjustado.get(i).doubleValue(), 2));
        }

        //Somatorio de yAjustado e yMenosYAjustadoAoQuadrado
        for(Double numeros: yAjustado){
            somatorioYAjustado += numeros.doubleValue();
        }
        for(Double numeros: yMenosYAjustadoAoQuadrado){
            somatorioYMenosYAjustadoAoQuadrado += numeros.doubleValue();
        }

        a = Math.pow(Math.E, a0);
        b = a1;

        //System.out.println("y = "+a+".x^"+b);
        rAoQuadrado = 1 - (tamanho*somatorioYMenosYAjustadoAoQuadrado) / (tamanho*somatorioYAoQuadrado - (Math.pow(somatorioYAjustado, 2)));
        System.out.println(rAoQuadrado);
    }
    public static void ajusteHiperbolico(ArrayList<Double> x, ArrayList<Double> y, int tamanho){
        //Ajustando a variavel de acordo com o método
        for(int i = 0; i < x.size(); i++){
            double xNovo = 0;
            xNovo = 1/x.get(i).doubleValue();

            x.set(i, xNovo);
        }

        ArrayList<Double> xAoQuadrado = new ArrayList<>() ;
        ArrayList<Double> xVezesY = new ArrayList<>() ;
        ArrayList<Double> yAjustado = new ArrayList<>();
        ArrayList<Double> yMenosYAjustadoAoQuadrado = new ArrayList<>();
        ArrayList<Double> yAoQuadrado = new ArrayList<>();

        // Variaveis
        double somatorioX = 0;
        double somatorioY = 0;
        double somatarioXAoQuadrado = 0;
        double somatarioXVezesY = 0;
        double somatorioYAjustado = 0;
        double somatorioYMenosYAjustadoAoQuadrado = 0;
        double somatorioYAoQuadrado = 0;
        double a = 0;
        double b = 0;
        double a0 = 0;
        double a1 = 0;
        double rAoQuadrado = 0;

        // Preenchendo a tabela x ao quadrado e x vezes y
        for(int i= 0 ; i < tamanho;i++){
            xAoQuadrado.add(Math.pow(x.get(i).doubleValue(), 2));
            xVezesY.add(x.get(i).doubleValue()*y.get(i).doubleValue());
            yAoQuadrado.add(Math.pow(y.get(i).doubleValue(), 2));
        }

        //Realizando os Somatorios

        for(Double numeros: x){
            somatorioX += numeros.doubleValue();
        }
        for(Double numeros: y){
            somatorioY += numeros.doubleValue();
        }

        for(Double numeros: xAoQuadrado){
            somatarioXAoQuadrado += numeros.doubleValue();
        }
        for(Double numeros: xVezesY){
            somatarioXVezesY += numeros.doubleValue();
        }
        for(Double numeros: yAoQuadrado){
            somatorioYAoQuadrado += numeros.doubleValue();
        }
        //Calculando a0 e a1
        a0 = ((somatarioXAoQuadrado*somatorioY) - (somatorioX*somatarioXVezesY)) / ((tamanho*somatarioXAoQuadrado) - Math.pow(somatorioX, 2));
        a1 = ((tamanho*somatarioXVezesY) - (somatorioX*somatorioY)) / ((tamanho*somatarioXAoQuadrado) - Math.pow(somatorioX, 2));

        //System.out.println("a0 = "+ a0);
        //System.out.println("a1 = "+ a1);

        //Preenchendo a tabela do yAjustado e yMenosYAjustadoAoQuadrado
        for(int i = 0; i < tamanho; i++){
            yAjustado.add(a0+(a1*x.get(i).doubleValue()));
            yMenosYAjustadoAoQuadrado.add(Math.pow(y.get(i).doubleValue() - yAjustado.get(i).doubleValue(), 2));
        }

        //Somatorio de yAjustado e yMenosYAjustadoAoQuadrado
        for(Double numeros: yAjustado){
            somatorioYAjustado += numeros.doubleValue();
        }
        for(Double numeros: yMenosYAjustadoAoQuadrado){
            somatorioYMenosYAjustadoAoQuadrado += numeros.doubleValue();
        }

        a = a0;
        b = a1;

        if(a1 < 0 ){
            //System.out.println("y = "+a+b+"/x");
        }else{
            //System.out.println("y = "+a+"-"+b+"/x");
        }

        rAoQuadrado = 1 - (tamanho*somatorioYMenosYAjustadoAoQuadrado) / (tamanho*somatorioYAoQuadrado - (Math.pow(somatorioYAjustado, 2)));
        System.out.println(rAoQuadrado);
    }
    public static void main(String[] args) {
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        int tamanhoTabela = 0;

        //Leitura de arquivo
        try{
            String path = "C://Users//Vhugo//OneDrive//Desktop//data.txt";
            File myFile = new File(path);
            Scanner lerArquivo = new Scanner(myFile);
            LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(myFile));
            linhaLeitura.skip(myFile.length());
            int qtdLinha = linhaLeitura.getLineNumber();
            tamanhoTabela = (qtdLinha+1) / 2 ;
            for(int i = 0; i < qtdLinha+1; i++){
                if(lerArquivo.hasNextLine()){
                    if(i <= (qtdLinha/2)){
                        x.add(lerArquivo.nextDouble());
                    }else{
                        y.add(lerArquivo.nextDouble());
                    }
                }
            }
            lerArquivo.close();
        }catch (IOException e){
            System.out.println("Ocorreu um erro ao abrir o arquivo!");
            e.printStackTrace();
        }
        //ajusteLinear(x, y, tamanhoTabela);
        //ajusteExponencial(x, y, tamanhoTabela);
        //ajusteLogaritmico(x, y, tamanhoTabela);

        ajustePotencial(x, y, tamanhoTabela);
        //ajusteHiperbolico(x, y, tamanhoTabela);
        //System.out.println(x.get(0).doubleValue());
        //System.out.println(y.get(0).doubleValue());

    }
}
