package functional.bienadam.airhacks_live;

public class NamedMethodParameters {

    public void hello(String message){}
    public static void main(String[] args) throws NoSuchMethodException {

        /*
        // code before java 10
        Method method = NamedMethodParameters.class.getMethod("hello", String.class);
        Parameter[] parameters = method.getParameters();
        System.out.println(method);
        for (Parameter parameter:parameters){
            System.out.println(parameter.getName());
        }
         */
        var method = NamedMethodParameters.class.getMethod("hello", String.class);
        var parameters = method.getParameters();
        System.out.println(method);
        for (var parameter:parameters){
            System.out.println(parameter.getName());
        }
        /*
        javac NamedMethodParameters.java
        java NamedMethodParameters
        output:
        public void NamedMethodParameters.hello(java.lang.String)
        arg0

        javac -parameters NamedMethodParameters.java
        java NamedMethodParameters
        output:
        public void NamedMethodParameters.hello(java.lang.String)
        message
         */
    }
}
