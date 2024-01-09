import java.util.ArrayList;

public class AjusteLinear {
  public static void ajusteLinear(ArrayList<Double> x, ArrayList<Double> y, int tamanho){
          // Arrays com os valores;
          ArrayList<Double> xAoQuadrado = new ArrayList<>() ;
          ArrayList<Double> xVezesY = new ArrayList<>() ;
  
          // Variaveis
          double somatorioX = 0;
          double somatorioY = 0;
          double somatarioXAoQuadrado = 0;
          double somatarioXVezesY = 0;
          double a0 = 0;
          double a1 = 0;
          double funcaoLinear = 0;
  
  
          // Preenchendo a tabela x ao quadrado e x vezes y
          for(int i= 0 ; i < tamanho;i++){
              xAoQuadrado.add(Math.pow(x.get(i).doubleValue(), 2));
              xVezesY.add(x.get(i).doubleValue()*y.get(i).doubleValue());
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
  
          a0 = ((somatarioXAoQuadrado*somatorioY) - (somatorioX*somatarioXVezesY)) / ((tamanho*somatarioXAoQuadrado) - Math.pow(somatorioX, 2));
          a1 = ((tamanho*somatarioXVezesY) - (somatorioX*somatorioY)) / ((tamanho*somatarioXAoQuadrado) - Math.pow(somatorioX, 2));
  
          System.out.println("y = "+a0+" + "+a1+"x");
      }
}
