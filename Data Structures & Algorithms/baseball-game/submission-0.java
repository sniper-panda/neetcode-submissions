class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for(String op:operations){
            if(op.equals("+")){
                int prev = s.pop();
                int prevPrev = s.peek();
                int x = prev + prevPrev;
                s.push(prev);
                s.push(x);
            }else if(op.equals("C")){
                s.pop();
            }else if(op.equals("D")){
                s.push(2*s.peek());
            }else{
                s.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for(int x:s){
            sum+=x;
        }

        return sum;
    }
}