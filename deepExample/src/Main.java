class DeepStudent{
    String name;
    int[]grades;
}
public DeepStudent(String name,int[]grades){
    this.name=name;
    this.grades=grades;
}
public DeepStudent(DeepStudent original){
    this.name=original.name;
    this.grades=new int[original.grades.lenngth];
    System.arraycopy(original.grades,0,this.grades);
}
public class Main{
    public static void main(String[]args){
        DeepStudent student1=new DeepStudent(m"Minara",grades);
        DeepStudent student2=new DeepStudent(student1);

    }
}