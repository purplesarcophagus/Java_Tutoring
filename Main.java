/*

 */
public class Main {
    public static char[][] make_forward(){
        /*
        builds new char[][] and fills with car
         */
        char[][] pixel = new char[4][13];
        pixel[0][0]=' '; pixel[0][1]=' '; pixel[0][2]='_'; pixel[0][3]='_'; pixel[0][4]='_'; pixel[0][5]='_'; pixel[0][6]='_'; pixel[0][7]='_'; pixel[0][8]=' '; pixel[0][9]=' '; pixel[0][10]=' '; pixel[0][11]=' '; pixel[0][12]=' '; pixel[1][0]=' '; pixel[1][1]='/'; pixel[1][2]='|'; pixel[1][3]='_'; pixel[1][4]='|'; pixel[1][5]='|'; pixel[1][6]='_'; pixel[1][7]='\\'; pixel[1][8]='\''; pixel[1][9]='.'; pixel[1][10]='_'; pixel[1][11]='_'; pixel[1][12]=' '; pixel[2][0]='('; pixel[2][1]=' '; pixel[2][2]=' '; pixel[2][3]=' '; pixel[2][4]='_'; pixel[2][5]=' '; pixel[2][6]=' '; pixel[2][7]=' '; pixel[2][8]=' '; pixel[2][9]='_'; pixel[2][10]=' '; pixel[2][11]='_'; pixel[2][12]='\\'; pixel[3][0]='='; pixel[3][1]='\''; pixel[3][2]='-'; pixel[3][3]='('; pixel[3][4]='_'; pixel[3][5]=')'; pixel[3][6]='-'; pixel[3][7]='-'; pixel[3][8]='('; pixel[3][9]='_'; pixel[3][10]=')'; pixel[3][11]='-'; pixel[3][12]='\''; return pixel;
    }
    public static char[][] make_mirror(char[][] array){
        /*
        builds new mirrorArray[][] and fills with inverse chars of inputted array
         */
        char[][] mirrorArray=new char[4][13];

        for(int rows=0;rows<array.length;rows++) {
            for (int cols = 0; cols < array[rows].length; cols++) {
                if (array[rows][cols]=='\\') {
                    array[rows][cols]='/';
                } else if (array[rows][cols]=='(') {
                    array[rows][cols]=')';
                } else if (array[rows][cols]==')') {
                    array[rows][cols]='(';
                } else if (array[rows][cols]=='/') {
                    array[rows][cols]='\\';
                }
                mirrorArray[rows][(array[rows].length - 1) - cols] = array[rows][cols];
            }
        }
        return mirrorArray;
        }
    public static void main(String[] args) {
        char[][] myArray=make_forward();

        for(int rows=0;rows<myArray.length;rows++){
            for(int cols=0;cols<myArray[rows].length;cols++){
                System.out.print(myArray[rows][cols]);
            }
            System.out.println();
        }

        char[][] mirror=make_mirror(myArray);

        for(int rows=0;rows<myArray.length;rows++){
            for(int cols=0;cols<myArray[rows].length;cols++){
                System.out.print(mirror[rows][cols]);
            }
            System.out.println();
        }

        myArray=make_forward();

        for(int rows=0;rows<myArray.length;rows++){
            int crashArraySize=myArray[rows].length*2;
            for(int cols=0;cols<crashArraySize;cols++){
                if (cols<=myArray[rows].length-1){
                    System.out.print(myArray[rows][cols]);
                }
                if (cols>=myArray[rows].length) {
                    System.out.print(mirror[rows][cols-myArray[rows].length]);
                }
            }
            System.out.println();
        }
    }
}
