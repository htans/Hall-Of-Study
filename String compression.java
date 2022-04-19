public class MyClass {
    public static void main(String args[]) throws ScriptException {
      
        String compressed = "3(hi)";
        //String compressed = "2(2(bye)2(co))x2(bo)";
        //String compressed = "2(byebye2(co))x2(bo)";
        
        String depressed = compressed;
        
        while(true) {
            
            if(depressed.indexOf("(") == -1) {
                break;
            }
            
            depressed = setDepress(depressed);
            
        }
        
        System.out.println("depressed String = " + depressed);

    }
    
    public static String setDepress(String compressed) {
        
        String returnStr = "";
        
        int startIdx = 0;
        int endIdx = 0;
        for(int i=0; i<compressed.length(); i++) {
            
            if("(".equals(compressed.substring(i, i+1))) {
                startIdx = i;
            }
            
            if(")".equals(compressed.substring(i, i+1))) {
                endIdx = i;
                break;
            }
            
        }
        
        String tempStr = compressed.substring(0, startIdx);
        tempStr = tempStr.substring(tempStr.lastIndexOf("(")+1);
        
        String strLoopCount = tempStr.replaceAll("[^0-9]", "");
        int loopCount = Integer.parseInt(strLoopCount);
        
        String loopStr = "";
        for(int i=0; i<loopCount; i++) {
            loopStr += compressed.substring(startIdx+1, endIdx);
        }
        
        returnStr = compressed.substring(0, compressed.substring(0, startIdx).length()-strLoopCount.length()) + loopStr + compressed.substring(endIdx+1);
        
        return returnStr;
        
    }
}