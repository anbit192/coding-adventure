package basics;
// Chuong trinh in ra khoang cach cua 2 diem

// Nhập vào 4 số thực x1, y1, x2, y2 từ đối dòng lệnh

// Tính  và in ra khoảng cách Euclid giữa hai điểm (x1, y1) và (x2, y2). 

//Kết quả được làm tròn đến 2 số phần thập phân, sử dụng công thức Math.round(a * 100.0) / 100.0 để làm tròn số a

public class Distance {
    
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double distance = (double) Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        return distance;

    }
    public static void main(String[] args) {

        double x1=Double.parseDouble(args[0]), y1=Double.parseDouble(args[1]), x2=Double.parseDouble(args[2]), y2=Double.parseDouble(args[3]);
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.println(Math.round(distance*100.0)/100.0);
    }


}