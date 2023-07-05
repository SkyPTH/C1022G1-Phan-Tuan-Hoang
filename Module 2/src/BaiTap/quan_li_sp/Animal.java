package BaiTap.quan_li_sp;

class Animal {
    public void makeSound() {
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal {
    @Override //đa hình tại runtime, định nghĩa lại phương thức của lớp cha
    public void makeSound() { //cùng tên, tham số, kiểu trả về, access modified lớp con = hoặc hơn lớp cha
        System.out.println("Dog barks"); //Hành vi(phương thức) chung của cha và con nhưng có nội dung/cách thể hiện khác nhau
    }
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal animal2 = new Dog();
        //Khi gọi phương thức, quyết định về phương thức được gọi xảy ra tại thời điểm chạy dựa trên kiểu đối tượng thực tế được tạo
        animal1.makeSound();
        animal2.makeSound();
    }
}



