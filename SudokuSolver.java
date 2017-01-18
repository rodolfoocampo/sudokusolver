

package sudoku;

import java.util.Arrays;

/**
 *
 * @author JOCAMPOB
 */
public class SudokuSolver {
    
    private int mat[][] = new int [9][9];
    //matriz donde se guardarán los conjuntos de valores para cada posición de la matriz mat
    public Conjunto2 aux[][] = new Conjunto2 [9][9];
     
    
    
    public SudokuSolver(int[][] matr){
        mat = matr;
        aux=this.matrizPosibles(matr); 
        
    }
    
    public int[][] getMat(){
        return mat;
    }
    
    
    
    //Crea un conjunto de posibles valores para cada columna
    public Conjunto2 creaConjFila(int fila, int[][] matr){
        Conjunto2 c1 = new Conjunto2();
        
        for(int i=0;i<9;i++){
            if(matr[fila][i]!=0)
               c1.agrega(matr[fila][i]);
                
        }
        return c1;
        
    }
    
    //Crea un conjunto de posibles valores para cada columna
    public Conjunto2 creaConjCol(int col, int[][] matr){
        Conjunto2 c1 = new Conjunto2();
        
        for(int i=0;i<9;i++){
            if(matr[i][col]!=0)
               c1.agrega(matr[i][col]);
                
        }
        return c1;
         
    }
    
    //Crea un conjunto de posibles valores para cada submatriz
    public Conjunto2 creaConjmat(int fila, int columna, int[][] matr){
        Conjunto2 c1 = new Conjunto2();
        // te regresa a la columna anterior
        columna= columna -columna%3;
        fila= fila -fila%3;
        
        for(int i=columna;i<columna+3;i++){
            for(int j=fila;j<fila+3;j++)
                if(matr[j][i]!= 0)
                    c1.agrega(matr[j][i]);
                
        }
        
        return c1;
    }
    
    //Este metodo une a los conjuntos anteriores para crear un conjunto de posibles valores
    //para la posición determinada por el argumento fila y col en la matriz matr
    public Conjunto2 creaUnionCuadrito(int fila, int col, int[][] matr){
         Conjunto2 c1 = creaConjFila(fila, matr);
         Conjunto2 c2 = creaConjCol(col, matr);
         Conjunto2 c3 = creaConjmat(fila,col, matr);
         Conjunto2 c4 = c1.union(c2).union(c3);
         
         return c4;
         
    }
    
    public Conjunto2 valoresPosibles(int f, int col, int[][] matr){
         
        Conjunto2 base=new Conjunto2(); 
       
        for(int i=1; i<10; i++){
            base.agrega(i);
        }

        return base.diferenciaAB(creaUnionCuadrito(f, col, matr));
    }
    
    public Conjunto2[][] matrizPosibles(int[][] matr){
        Conjunto2[][] auxiliar=new Conjunto2[9][9];
        for(int f=0;f<9;f++){
            for(int col=0;col<9;col++){
                auxiliar[f][col]=valoresPosibles(f,col, matr);
            }
        }
        return auxiliar;
    }
    
    public boolean esValido(int x, int fila, int col, int[][] matr){
        boolean res=false;
        Conjunto2[][] auxiliar=new Conjunto2[9][9];
        auxiliar=matrizPosibles(matr);
        if(auxiliar[fila][col].contiene(x)){
            res=true;
        }
        return res;  
    }
    
    
    public boolean resuelve2(int[][] matriz) {
    mat=matriz;
    
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (mat[i][j]!=0) {
                continue;
            }
            for (int num = 1; num <= 9; num++) {
                if (esValido(num,i,j,mat)) {
                    mat[i][j] = num;
                    
                    if (resuelve2(mat)) {
                        return true;
                    } else {
                        aux[i][j].remove(mat[i][j]);
                        mat[i][j] = 0;
                    }
                }
            }
            return false;
        }
    }
    return true;
}
        
        
        
}
    
    
    
