public class EmptyStringException extends Throwable {

    @Override
    public String getMessage() {
        return "Não é possivel fazer um tuite com texto vazio.";
    }
}
