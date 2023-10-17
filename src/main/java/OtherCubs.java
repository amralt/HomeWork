class OtherCubs {
    public static void main(String []args) {
        double side = 3;
        Cube Cube1 = Cube.builder().cubSide(side).valueShape(Math.pow(side, 2)).build();
        System.out.println(Cube1.getValueShape());
    }
}