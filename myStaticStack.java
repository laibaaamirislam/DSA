public class myStaticStack {
        private int[] array;
        private int tos;

        myStaticStack(int size){
            array = new int[size];
            tos = -1;
        }

        public void push(int val){
            if(tos == array.length-1){
                System.out.println("stack is full");
            }
            else {
                array[++tos] = val;
            }
        }
        public int pop(){
            if(tos == -1){
                System.out.println("stack is empty");
               return -1;
            }
            else {
                return array[tos--];
            }
        }

        public void printStack(){

            for(int i:array){
                System.out.println(i);
            }
        }
    }

