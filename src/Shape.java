public interface Shape {
    public void getVolume();
}

class Pyramid implements Shape {
    private double baseLength;
    private double height;

    public Pyramid() {
        baseLength = 25;
        height = 8;
    }

    public void getVolume() {
        //System.out.println("dddd");
        //String pyramidDescripion = "Объем пирамиды с " + baseLength + height + " основанием и высотой соответственно";
        System.out.println("объем пирамиды" + (1.0 / 3) * Math.pow(baseLength, 2) * height);
    }
    public static void main(String []args) {
        Pyramid pyramid = new Pyramid();
        pyramid.getVolume();
    }
}
class Cube implements Shape {
    private final double cub_side;

    public Cube() {
        cub_side = 10;
    }
    public void getVolume() {
        System.out.println("объем куба: " + Math.pow(cub_side,3));
    }
    public static void main(String []args){
        Cube cube = new Cube();
        cube.getVolume();
    }
}
