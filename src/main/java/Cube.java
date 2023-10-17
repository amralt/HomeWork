import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
@AllArgsConstructor
class Cube{
    private  double cubSide;
    private double valueShape;


    public static void main(String []args){
        Cube cube = new Cube(10, 1000);
        System.out.println(cube.getValueShape());
    }
}