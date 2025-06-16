package demo3;

import entity.Student;
import java.util.Scanner;

public class StudentView {
    private StudentController controller = new StudentController();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Sửa thông tin sinh viên");
            System.out.println("2. Xoá sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> updateStudent();
                case 2 -> deleteStudent();
                case 0 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void updateStudent() {
        System.out.print("Nhập ID sinh viên cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = controller.findStudent(id);
        if (student == null) {
            System.out.println("❌ Không tìm thấy sinh viên.");
            return;
        }

        System.out.println("🔎 Thông tin hiện tại: " + student);
        System.out.print("Nhập tên mới: ");
        student.setName(scanner.nextLine());
        System.out.print("Nhập tuổi mới: ");
        student.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập SĐT mới: ");
        student.setTelephone(scanner.nextLine());

        if (controller.updateStudent(student)) {
            System.out.println("✅ Cập nhật thành công!");
        } else {
            System.out.println("❌ Cập nhật thất bại!");
        }
    }

    private void deleteStudent() {
        System.out.print("Nhập ID sinh viên cần xoá: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = controller.findStudent(id);
        if (student == null) {
            System.out.println("❌ Không tìm thấy sinh viên.");
            return;
        }

        System.out.println("🔎 Thông tin sinh viên: " + student);
        System.out.print("Nhập OK để xác nhận xoá: ");
        if ("OK".equalsIgnoreCase(scanner.nextLine())) {
            if (controller.deleteStudent(id)) {
                System.out.println("✅ Đã xoá thành công.");
            } else {
                System.out.println("❌ Xoá thất bại.");
            }
        } else {
            System.out.println("❌ Hủy xoá.");
        }
    }
}
