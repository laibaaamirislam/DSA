import java.util.ArrayList;

public class dynamicStackArrayList {
        private ArrayList array;
        private int tos;

        dynamicStackArrayList(int size){
            array = new ArrayList(size);
            tos = -1;
        }

        public void push(int val){
            tos++;
            array.add(val);
        }
        public void pop(){
            if(tos == -1){
                System.out.println("stack is empty");
            }
            else {
                array.remove(tos--);
            }
        }

        public void printStack(){

            for(int i = 0; i <= tos; i++){
                System.out.println(array.get(i));
            }
        }
    }


