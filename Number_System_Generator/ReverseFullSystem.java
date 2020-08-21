        
        /**
         * Write a description of class ReverseFullSystem here.
         *
         * @author (your name)
         * @version (a version number or a date)
         */
        import java.util.Scanner;
        import java.lang.Math;
        public class ReverseFullSystem
        {
            // instance variables - replace the example below with your own
            public static void main(String[] args){
                Scanner input = new Scanner(System.in);
                
                char[] CHARCTERS={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
                int base=0;
                
                while(base>CHARCTERS.length||base<1){
                    System.out.println("What do you want your base to be?(1-"+CHARCTERS.length+")");
                    base = input.nextInt();
                }
                int converted = 0;
                boolean foundChar = false;
                int value = 0;
                boolean foundAll = true;
                String convertable;
                
                System.out.println("What integer do you want converted to base "+base+"?");
                converted = input.nextInt();
                convertable = "";
                
                while (converted > 0) {
                    int digit = converted % base;              // rightmost digit
                    convertable = CHARCTERS[digit] + convertable;  // string concatenation
                    converted = converted / base;
                }
                         
                System.out.print(convertable);
    }
}
