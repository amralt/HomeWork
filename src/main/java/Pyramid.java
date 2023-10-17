import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
class Pyramid {
    private static final double baseLength = 5;
    private static final double height = 10;
    private final double valueShape = (1.0 / 3) * Math.pow(baseLength, 2) * height;

    public static void main(String []args) {
        Pyramid pyramid = new Pyramid();
        System.out.println(pyramid.getValueShape());
    }
}