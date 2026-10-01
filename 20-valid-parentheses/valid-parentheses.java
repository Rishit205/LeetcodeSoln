class Solution { 
    public boolean isValid(String s) { 
        Stack<Character> sp = new Stack<>(); 
 
        for(char ch : s.toCharArray()) { 
            
            if(ch == '(' || ch == '{' || ch == '[') { 
                sp.push(ch); 
            } 
            else { 
                
                if(sp.isEmpty()) {
                    return false;
                }

                if(ch == ')') { 
                    if(sp.peek() == '(') { 
                        sp.pop(); 
                    } 
                    else { 
                        return false; 
                    } 
                } 
 
                if(ch == '}') { 
                    if(sp.peek() == '{') { 
                        sp.pop(); 
                    } 
                    else { 
                        return false; 
                    } 
                } 
 
                if(ch == ']') { 
                    if(sp.peek() == '[') { 
                        sp.pop(); 
                    } 
                    else { 
                        return false; 
                    } 
                } 
            } 
        } 
 
        return sp.isEmpty(); 
    } 
}