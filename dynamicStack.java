public class dynamicStack {
        private int[] array;
        private int tos;

        dynamicStack(int size){
            array = new int[size];
            tos = -1;
        }

        public void push(int val){
            if(tos == array.length-1){
                int [] temp = new int[(array.length*2)];
                for(int i = 0; i < array.length; i++){
                    temp[i] = array[i];
                }
                array=temp;
            }
                array[++tos] = val;
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

            if (tos == -1) {
                System.out.println("empty stack");
            }
           for(int i = 0; i <= tos; i++){
               System.out.println(array[i]);
           }
        }
    }

