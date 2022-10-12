public class GeometryCanvas {

    public static void main(String[] args) {

        int point1_x = 1;
        int point1_y = 2;

        // Dear other programmer: from now remeber that the first element is x and the second element is y
        int[] point1 = { 1, 2 };

        Point p1 = new Point(1, 2);
        //p1.x = 1;
        //p1.y = 2;

        int point2_x = 5;
        int point2_y = 10;

        int[] point2 = { 5, 10 };

        Point p2 = new Point(5, 10);
        //p2.x = 5;
        //p2.y = 10;

        int point3_x = 9;
        int point3_y = 10;

        //double distance = Math.sqrt(Math.pow(point2_x- point1_x, 2) + Math.pow(point2_y - point1_y, 2));
        //double distance = Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
        double distance = Math.sqrt(Math.pow(p2.x- p1.x, 2) + Math.pow(p2.y - p2.y, 2));



        System.out.println("The distance is: "+distance);

    }

}
