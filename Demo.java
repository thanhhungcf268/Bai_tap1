import java.util.Scanner;

public class Demo {
    static String[][] array, array1;
    static int size;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("nhập chuỗi số :");
        size = scanner.nextInt();
        array = new String[size][4];
        System.out.println("nhập Thông tin :");
        for (int k = 0; k < size; k++) {
            System.out.println("Nhập Thông tin ID : ");
            array[k][0] = scanner.next();
            System.out.println("Nhập Name :");
            array[k][1] = scanner.next();
            System.out.println("Nhập Ngày Tháng Năm  : ");
            array[k][2] = scanner.next();
            System.out.println("Nhập Điểm thi : ");
            array[k][3] = scanner.next();
        }
        Khoi_Tao();
        int s;
        do {
            System.out.println("1. Thêm student !");
            System.out.println("2. Xóa 1 sinh viên student !");
            System.out.println("3. Hiển thị danh sách student !");
            System.out.println("4. Tìm sinh viên có điểm cao nhất !");
            System.out.println("5. Chỉnh sửa 1 sinh viên khi viết mã sinh viên !");
            System.out.println("6. Sắp xếp danh sách sinh viên theo điểm từ cao xuống thấp !");
            System.out.println("0. Exit !");
            System.out.println("chọn mục chạy :");
            s = scanner.nextInt();
            switch (s) {
                case 1 -> {
                    Them();
                    Khoi_Tao();
                }
                case 2 -> {
                    xoa();
                    Khoi_Tao();
                }
                case 3 -> Khoi_Tao();
                case 4 -> Seach();
                case 5 -> {
                    Chinh_Sua();
                    Khoi_Tao();
                }
                case 6 -> {
                    Sap_Xep();
                    Khoi_Tao();
                }
            }
        } while (s != 0);
    }
    static void Khoi_Tao() {
        for (String[] l : array) {
            for (String k : l) {
                System.out.print(k + " ");
            }
            System.out.println("");
        }
    }
    static void Them() {
        boolean check = true;
        size++;
        array1 = new String[size][4];
        System.arraycopy(array, 0, array1, 0, array.length);
        int i = size - 1;
        System.out.println("Nhập Id : ");
        String a = scanner.next();
        for (String[] k : array) {
            for (String j : k) {
                if (a.equals(j)) {
                    check = false;
                    size--;
                    break;
                }
            }
        }
        if (check) {
            array[i][0] = a;
            System.out.println("Nhập Name :");
            array[i][1] = scanner.next();
            System.out.println("Nhập Ngày Tháng Năm  : ");
            array[i][2] = scanner.next();
            System.out.println("Nhập Điểm thi : ");
            array[i][3] = scanner.next();
            array = array1;
        } else {
            System.out.println("Id bị trùng đề nghị nhập lại Id ");
        }
    }
    static void xoa() {
        System.out.println("nhập từ muốn xóa");
        String xoa = scanner.next();
        boolean check = true;
        for (int k = 0; k < array.length; k++) {
            if (xoa.equals(array[k][0])) {
                size--;
                array1 = new String[size][4];
                for (int u = 0; u < k; u++) {
                    System.arraycopy(array[u], 0, array1[u], 0, array[u].length);
                }
                for (int u1 = k + 1; u1 < array.length; u1++) {
                    System.arraycopy(array[u1], 0, array1[u1 - 1], 0, array[u1].length);
                }
                check = false;
            }
        }
        if (check) {
            System.out.println(" id không tồn tại");
        }
        array = array1;
    }
    static void Seach() {
        int max;
        max = Integer.parseInt(array[0][3]);
        for (int i = 1; i < array.length; i++) {
            int a = Integer.parseInt(array[i][3]);
            if (max < a) {
                max = a;
            }
            if (i == array.length - 1) {
                String string = Integer.toString(max);
                for (String[] strings : array) {
                    if (string.equals(strings[3])) {
                        System.out.println(" Học sinh có điểm cao nhất là : ");
                        System.out.printf("%2s%5s%5s%5s", strings[0], strings[1], strings[2], strings[3]);
                    }
                }
                System.out.println();
            }
        }
    }
    static void Chinh_Sua() {
        System.out.println("Nhập mã sinh viên muốn chỉnh sửa ");
        String sua = scanner.next();
        for (int i = 0; i < array.length; i++) {
            if (sua.equals(array[i][0])) {
                System.out.println("Nhập thông tin muốn sủa");
                for (int j = 1; j < 4; j++) {
                    array[i][j] = scanner.next();
                }
            }
        }
    }
    static void Sap_Xep() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (Double.parseDouble(array[i][3]) < Double.parseDouble(array[j][3])) {
                    String[] temp = {array[i][0], array[i][1], array[i][2], array[i][3]};
                    System.arraycopy(array[j], 0, array[i], 0, 4);
                    System.arraycopy(temp, 0, array[j], 0, 4);
                }
            }
        }
    }
}
