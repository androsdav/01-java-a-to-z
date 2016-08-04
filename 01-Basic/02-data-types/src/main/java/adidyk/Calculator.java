package adidyk;

public class Calculator {
       double result;

       // Method adding
       public void add(double first, double second) {
              this.result = first + second;
       }
       // Method substruct
       public void sub(double first, double second) {
              this.result = first - second;
       }
       // Method division
       public void div(double first, double second) {
              this.result = first / second;
       }
       // Method multiple
       public void mult(double first, double second) {
              this.result = first * second;
       }
       // Method get result
       public double getResult() {
              return this.result;
       }

}