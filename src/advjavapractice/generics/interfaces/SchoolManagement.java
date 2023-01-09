package advjavapractice.generics.interfaces;

public class SchoolManagement {
    /*Task: Okul yönetimi için öğrenci ve öğretmen kayıtlarını
   -oluşturan
   -görüntüleyen
   -güncelleyen
   -silen
   bir program yazınız.

   Her iki sinif icin ayni methodlara ihtiyacimiz var (add,delete,update,get)
   Implement edip bu methodlari olusturabilmek ve her iki class in nesnelerini parametre olarak alabilmek
   icin generic tipte interface tanimladik
 */
    public static void main(String[] args) {
        Student student = new Student("Tolstoy");
        StudentRepo studentRepo = new StudentRepo();
        Teacher teacher=new Teacher("Dostoyevski");
        TeacherRepo teacherRepo = new TeacherRepo();

        studentRepo.add(student);
        studentRepo.update(student);
        studentRepo.get(student);
        studentRepo.delete(student);

        System.out.println();

        teacherRepo.add(teacher);
        teacherRepo.update(teacher);
        teacherRepo.get(teacher);
        teacherRepo.delete(teacher);
    }
}
