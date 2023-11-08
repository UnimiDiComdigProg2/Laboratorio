public class Demo {
    int x;
    Demo (int x) {
        this.x = x;
    }

    boolean equals(Demo obj) {
        if (this.x == obj.x) return (true);
        return false;
    }

    public static void main(String[] args) {
        Demo obj1 = new Demo(5);
        Demo obj2 = obj1;
        System.out.println("Obj1: " + obj1);

        System.out.println("Obj2: " + obj2);

        System.out.println("Confornto tra Obj1 e Obj2: " + obj1.equals(obj2));

        obj2 = new Demo(5);
        
        System.out.println("Obj2: " + obj2);

        System.out.println("Confornto tra Obj1 e Obj2: " + obj1.equals(obj2));
    }
 }
