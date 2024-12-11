class student{
    String name;
    int[] grades;
}
public Student(String name,int[]grades){
    this.name;
    this.grades=grades;
}
public Main{
    public static void main(String[]args){
        Student student1=new Student("Ali",new int[]{85,90,86});
        Student student2=new student(student1);
        Student2.grades[0]=100;
    }
}