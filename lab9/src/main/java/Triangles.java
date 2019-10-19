import java.util.stream.IntStream;

/**
 * Tim Malko
 * Lab 9: Triangles.
 * javaProgram prints four triangles, one below the other
 * i think there are a couple mistakes which cancels each other
 */
public class Triangles {
    // draw four triangles
    public static void main(String[] args) {
        int numLines = 10;

        // to draw trigs we need call next function with this params. it is loop do it
        // f(-1, -numLines);
        // f(-1, numLines);
        // f(1, -numLines);
        // f(1, numLines);
        for (int i = 0; i < 4; i++) {
            //because all 4 statement can be code into 2 bit
            f((i < 2) ?-1:1, numLines * ((i % 2==0) ? -1:1));
        }
    }

    //We need next call there are two functions because f(k, y0, x0, x1) is a firstborn(means i wrote formula for
    // f first and do not want to delete it), and f(k, y0) is a private case
    //f(-1, -numLines, -numLines, 0);
    //f(-1, numLines, 0, numLines);
    //f(1, -numLines, 0, numLines);
    //f(1, numLines, -numLines, 0);
    private static void f(int k, int y0) {
        // because x1-x0=nunLines in our case and depend on xor state of signs od k and y0
        int x0 = (k<0)^(y0>0)?-Math.abs(y0):0;
        int x1 = Math.abs(y0) + x0;
        f(k, y0, x0, x1);
    }

    //we assume (who we?) triangles through a function which divides plane by two parts
    private static void f(int k, int y0, int x0, int x1) {
        //go by x
        for(int x=x0; x<=x1; x++){
            //calc y
            int y = k*x+y0;
            // at y=0 no astrics to print skipe it
            if(y==0) continue;
            //to reduce amount of work print spaces only if we need that
            for (int i = 0; i < Math.abs(x) && k>0; i++){
                System.out.print(" ");
            }
            //drawing astrics y times
            for (int i = 0; i < Math.abs(y); i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
}