public class final_q8_c {
    
    public static void main(String[] args) {
    
        int j = -3;

        for (int i = 0; i < 3; i++) {

            int temp = j + 2;

            if (temp == 3 || temp == 2) j--;
            else if (temp == 0) j += 2;
            else j = 0;

            if (j > 0) break;
            else j = 3 - i;

        }

    }

}