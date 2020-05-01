public class final_q5 {    

    public static void main (String[] args) {

        boolean found = false;
        int n = 10;
        int[][] x = new int[10][10];

        for (int i = 1; i <= n; i++) { 

            int counter = 0;
            
            for (int j = 1; j <= n; j++) {
                if (x[i][j] == 0)
                    counter++; 
            }
            
            if (counter == n && found == false) { 
                System.out.println("First all-­zero row is: " + i); 
                found = true;
            } 

        }

    }

}