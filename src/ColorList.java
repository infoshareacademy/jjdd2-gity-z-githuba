public enum ColorList {
    RED("\u001B[31m"),
    YELLOW("\u001B[33m"),
    GREEN("\u001B[32m"),
    BLACK("\u001B[30m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),
    RESET("\u001B[0m");

    private final String color;

    ColorList(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    @Override
    public String toString() {
        return getColor();
    }
}