package Assignment_8;
class ExceptionOne extends Exception{
    public ExceptionOne(String message) {
        super(message);
    }
}
class ExceptionTwo extends Exception{
    public ExceptionTwo(String message) {
        super(message);
    }
}
class ExceptionThree extends Exception{
    public ExceptionThree(String message) {
        super(message);
    }
}

public class ExceptionMain {
    public static void main(String[] args) {
        int option = 1;
        try {
            switch (option) {
                case 1:
                    throw new ExceptionOne("Exception of type ExceptionOne");
                case 2:
                    throw new ExceptionTwo("Exception of type ExceptionTwo");
                case 3:
                    throw new ExceptionOne("Exception of type ExceptionThree");
                case 4:
                    throw new NullPointerException("NUll pointer Exception");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("im in finally block");
        }
    }
}
