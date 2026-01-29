class StringArray{
    public static void main(String[] args) {
        char[] alphas = new char[(int)('Z' - 'A')+1];
        for(int i =0; i <alphas.length; i++){
            alphas[i] = (char)('A' + i);
        }

        for(char c:alphas){
            System.out.println(c);
        }
    }
}