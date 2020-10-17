import javax.xml.transform.Result;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.toList;

public class MatrixModifier {
    private Matrix m;
    private ArrayList<Element> maximumsColumn=new ArrayList<Element>();

    public MatrixModifier(Matrix mx) {
        this.m=mx;
    }

    public Matrix getM() {
        return this.m;
    }

    /**
     * Iterate through each row of the matrix. Find the minimum in each row.
     * Create an array of obtained minimums.
     * Find the maximum value(s) in this array. This value
     * is the decision based on the minimax criterion.
     * **/
    public void getMiniMax() {

        for (int i=0; i<m.rows; i++) {
            maximumsColumn.add(getMaxInARow(i));
        }

        //Find the maximum among minimums
        Element min=maximumsColumn
                .stream()
                .min(Comparator.comparing(Element::getValue))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("The minimum value is: "+min.getValue());
        removeRow(min.getRow());
    }

    /** find the minimum in the given row **/
    public Element getMaxInARow(int k) {
        ArrayList<Element> aux=new ArrayList<Element>();

        for (int j=0; j<m.columns; j++) {
            aux.add(m.mtrx[k][j]);
        }

        Element max=aux
                .stream()
                .max(Comparator.comparing(Element::getValue))
                .orElseThrow(NoSuchElementException::new);

        return max;
    }


    private void removeRow(int k) {

        Element[][] newMatrix=new Element [m.rows-1][m.columns];

        for (int i=0; i<m.rows-1; i++){
            for (int j=0; j<m.columns; j++) {
                newMatrix[i][j]=new Element();
            }
        }

        int s=0;
        for (int i=0; i<m.rows; i++){
            if (i==k) continue;
            for (int j=0; j<m.columns; j++) {
                newMatrix[s][j]=m.mtrx[i][j];
            }
            s++;
        }

        System.out.println("Modified matrix");
        for (int i=0; i<newMatrix.length; i++) {
            for (int j=0; j<newMatrix[i].length; j++) {
                System.out.printf("%5d", newMatrix[i][j].getValue());
            }
            System.out.println();
        }
    }

}
