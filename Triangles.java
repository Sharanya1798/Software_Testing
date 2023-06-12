import java.util.*;
import java.util.Scanner;

import java.awt.Point;
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static java.lang.Math.acos;
import java.util.Arrays;

public class Triangles {

    //SAS congruency
    static int sas(int[] s1, int[] s2, int[] a1, int[] a2)
    {
        sort(s1, 0, 2);
        sort(s2, 0, 2);
        sort(a1, 0, 2);
        sort(a2, 0, 2);

        if ((s1[0] == s2[0] && s1[1] == s2[1]) && a1[2] == a2[2])
        {
            return 1;
        }

        if ((s1[1] == s2[1] && s1[2] == s2[2]) && a1[0] == a2[0])
        {
            return 1;
        }

        if ((s1[2] == s2[2] && s1[0] == s2[0]) && a1[1] == a2[1])
        {
            return 1;
        }

        return 0;
    }

    //ASA congruency
    static int asa(int[] s1, int[] s2, int[] a1, int[] a2)
    {
        sort(s1, 0, 2);
        sort(s2, 0, 2);
        sort(a1, 0, 2);
        sort(a2, 0, 2);

        if ((a1[0] == a2[0] && a1[1] == a2[1]) && s1[2] == s2[2])
        {
            return 1;
        }

        if ((a1[1] == a2[1] && a1[2] == a2[2]) && s1[0] == s2[0])
        {
            return 1;
        }

        if ((a1[2] == a2[2] && a1[0] == a2[0]) && s1[1] == s2[1])
        {
            return 1;
        }

        return 0;
    }

    //AAS congruency
    static int aas(int[] s1, int[] s2, int[] a1, int[] a2)
    {
        sort(s1, 0, 2);
        sort(s2, 0, 2);
        sort(a1, 0, 2);
        sort(a2, 0, 2);

        if ((a1[0] == a2[0] && a1[1] == a2[1]) && (s1[0] == s2[0] || s1[1] == s2[1]))
        {
            return 1;
        }

        else if ((a1[1] == a2[1] && a1[2] == a2[2]) && (s1[1] == s2[1] || s1[2] == s2[2]))
        {
            return 1;
        }

        else if ((a1[0] == a2[0] && a1[2] == a2[2]) && (s1[0] == s2[0] || s1[2] == s2[2]))
        {
            return 1;
        }

        return 0;
    }

    //HL congruency
    static int hl(int[] s1 , int[] s2, int[]a1, int[] a2)
    {
        sort(s1,0,2);
        sort(s2,0,2);
        sort(a1,0,2);
        sort(a2,0,2);
        if(s1[2] == s2[2] && (s1[1] == s2[1] || s1[0] == s2[0]) && a1[2]==90 && a2[2]==90 )
        {

            return 1;
        }
        return 0;
    }

    //SSS congruency
    static int sss(int[] s1,int[] s2)
    {
        sort(s1,0,2);
        sort(s2,0,2);

        if(s1[0] == s2[0] && s1[1] == s2[1] && s1[2] == s2[2])
        {
            return 1;
        }

        return 0;
    }


    static int[] getSides1(int s1, int s2, int s3)
    {
        int[] s = {s1, s2, s3};
        sort(s,0,2);
        return s;
    }

    static int[] getSides2(int s1, int s2, int s3)
    {
        int[] s = {s1, s2, s3};

        return s;
    }

    static int[] getAngles1(int s1, int s2, int s3)
    {
        int[] s = {s1, s2, s3};
        sort(s,0,2);
        return s;
    }

    static int[] getAngles2(int s1, int s2, int s3)
    {
        int[] s = {s1, s2, s3};

        return s;
    }


    //AAA similarity
    static int simi_aaa(int a1[], int a2[])
    {
        Arrays.sort(a1);
        Arrays.sort(a2);

        // Check for AAA
        if (a1[0] == a2[0] &&  a1[1] == a2[1] && a1[2] == a2[2])
        {
            return 1;
        }
        else
        {
            return 0;
        }

    }

    // SAS similarity
    static int simi_sas(int s1[], int s2[],int a1[], int a2[])
    {
        Arrays.sort(a1);
        Arrays.sort(a2);
        Arrays.sort(s1);
        Arrays.sort(s2);
        if(s1[0] / s2[0] == s1[1] / s2[1])
        {
            // since we take angle
            // b / w the sides.
            if (a1[2] == a2[2])
            {
                return 1;
            }
        }
        if (s1[1] / s2[1] == s1[2] / s2[2])
        {
            if (a1[0] == a2[0])
            {
                return 1;
            }
        }
        if (s1[2] / s2[2] == s1[0] / s2[0])
        {
            if(a1[1] == a2[1])
            {
                return 1;
            }
        }

        return 0;
    }

    //SSS similarity
    static int simi_sss(int s1[],int s2[])
    {
        Arrays.sort(s1);
        Arrays.sort(s2);


        if(s1[0] / s2[0] == s1[1] / s2[1] && s1[1] / s2[1] == s1[2] / s2[2] && s1[2] / s2[2] == s1[0] / s2[0])
        {
            return 1;
        }
        return 0;
    }

    //CHECK WHETHER THE TRIANGLE IS VALID OR NOT
    public static int checkValidity(int a, int b, int c)
    {
        // check condition
        int arr[] = {a,b,c};
        sort(arr,0,2);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        if (a + b > c)
        {
            return 1;
        }
        return 0;
    }

    //AREA OF THE CIRCUMCIRCLE FORMED OF ANY TRIANGLE WITH THE SIDES GIVEN
    static public double circlearea(double a, double b, double c)
    {


        if (a <= 0 || b <= 0 || c <= 0)
        {
            return -1;
        }

        double p = (a + b + c) / 2;
        double At = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        double A = 3.14 * Math.pow(((a * b * c) / At), 2);

        return A;
    }


    //FIND THE RADIUS OF THE INCIRCLE THAT IS FORMED BY THE TRIANGLE
    static float findRadiusOfIncircle(float a, float b, float c)
    {

        if (a < 0 || b < 0 || c < 0)
        {
            return -1;
        }
        float p = (a + b + c) / 2;
        float area = (float)Math.sqrt(p * (p - a) * (p - b) * (p - c));
        float radius = area / p;
        return radius;
    }

    //Area of largest triangle in a semi circle
    static float trianglearea(float r)
    {

        if (r <= 0)
        {
            return -1;
        }
        return r * r;
    }


    //CLASSIFICATION OF TRIANGLES IF POINTS ARE GIVEN
    static int square(int x)
    {
        return x * x;
    }
    static int order(int a, int b, int c)
    {
        int[] copy = new int[3];
        copy[0] = a;
        copy[1] = b;
        copy[2] = c;
        sort(copy,0,2);
        a = copy[0];
        b = copy[1];
        c = copy[2];
        return a;
    }
    static int euclidDistSquare(Point p1, Point p2)
    {
        return square(p1.x - p2.x) + square(p1.y - p2.y);
    }
    //  Method to classify side
    static String getSideClassification(int a, int b, int c)
    {

        if(a == b && b == c)
        {
            return "Equilateral";
        }
        else if(a == b || b == c)
        {
            return "Isosceles";
        }
        else
        {
            return "Scalene";
        }
    }
    static int isIsosceles(int a, int b, int c) {

        if(a == b || b == c || a == c) {
            return 1;
        }

        return 0;



    }

    //  Method to classify angle
    static String getAngleClassification(int a, int b, int c)
    {
        if(a + b > c)
        {
            return "acute";
        }
        else if(a + b == c)
        {
            return "right";
        }
        else
        {
            return "obtuse";
        }
    }

    //  Method to classify triangle by sides and angles
    static String[] classifyTriangle(Point p1,Point p2,Point p3)
    {

        int a = euclidDistSquare(p1, p2);
        int b = euclidDistSquare(p2, p3);
        int c = euclidDistSquare(p1, p3);

        int array[] = {a,b,c};
        sort(array,0,2);

//       System.out.println("Triangle is " + getAngleClassification(a, b, c) + " and " + getSideClassification(a, b, c));
        String arr[] = {getAngleClassification(array[0], array[1], array[2]),getSideClassification(array[0], array[1], array[2])};
        return arr;
    }

    //FIND ANGLES OF THE TRIANGLE WHEN SIDES ARE GIVEN
    static int lengthSquare(Point p1, Point p2)
    {
        int xDiff = p1.x- p2.x;
        int yDiff = p1.y- p2.y;
        return xDiff*xDiff + yDiff*yDiff;
    }

    static double[] printAngle(Point A, Point B,Point C)
    {
        // Square of lengths be a2, b2, c2
        int a2 = lengthSquare(B,C);
        int b2 = lengthSquare(A,C);
        int c2 = lengthSquare(A,B);

        // lenght of sides be a, b, c
        float a = (float)sqrt(a2);
        float b = (float)sqrt(b2);
        float c = (float)sqrt(c2);

        // From Cosine law
        float alpha = (float) acos((b2 + c2 - a2)/(2*b*c));
        float betta = (float) acos((a2 + c2 - b2)/(2*a*c));
        float gamma = (float) acos((a2 + b2 - c2)/(2*a*b));

        // Converting to degree
        alpha = (float) (alpha * 180 / PI);
        betta = (float) (betta * 180 / PI);
        gamma = (float) (gamma * 180 / PI);

        double arr[] = {alpha,betta,gamma};
        // printing all the angles
        return arr;
    }

    //Method to find other sides of a right angled triangle when one side is given
    static int[] printOtherSides(int n)
    {
        int arr[] = {-1,-1};

        if (n%2 != 0)
        {

            if (n == 1)
            {
                return arr;
            }
            else
            {
                int b = (n * n -1) / 2;
                int c = (n * n +1) / 2;
                arr[0] = b;
                arr[1] = c;
//                System.out.println("b = "+ b + ", c = "+c);
                return arr;
            }
        }
        else
        {

            if(n == 2)
            {
//                System.out.println("-1");
                return arr;
            }
            else
            {
                int b = n * n / 4 - 1;
                int c = n * n / 4 + 1;
                arr[0] = b;
                arr[1] = c;
                return arr;
//                System.out.println("b = "+ b +", c = "+c);
            }
        }
    }


    //FINDING DIMENSIONS OF THE RIGHT ANGLED TRAINGLE WHITH GIVEN HYPOTENUSE AND AREA
    static double[] findDimen(int H, int A)
    {
        double arr[] = {-1,-1};
        if (H * H < 4 * A) {
            return arr;
        }

        // sqrt value of H^2 + 4A and H^2- 4A
        double apb = Math.sqrt(H * H + 4 * A);
        double asb = Math.sqrt(H * H - 4 * A);

//        System.out.println("P = " + Math.round(((apb - asb) / 2.0) * 100.0) / 100.0);
//        System.out.print("B = " + Math.round(((apb + asb) / 2.0) * 100.0) / 100.0);

        arr[0] = Math.round(((apb - asb) / 2.0) * 100.0) / 100.0;
        arr[1] = Math.round(((apb + asb) / 2.0) * 100.0) / 100.0;

        return arr;
    }


    //POSSIBLE NUMBER OF PAIRS OF HYPOTENUSE AND AREA TO FORM RIGHT ANGLED TRIANGLE
    static boolean check(int H, int S)
    {
        return H * H >= 4 * S;
    }

    static int findPairs(int H[], int n,
                         int S[], int m)
    {
        int count = 0;

        // Checkinag all possible pairs
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (check(H[i], S[j]))
                {
                    count++;
                }
            }
        }

        return count;
    }

    static int minimumIncrease(int a, int b,int c)
    {

        int arr[] = { a, b, c };
        Arrays.sort(arr);
        if(arr[0] + arr[1] >= arr[2])
        {
            return 0;
        }
        else
        {
            return arr[2] - (arr[0] + arr[1]);
        }
    }

    //FINDING THRID SIDE IF TWO SIDES OF THE TRIANGLE ARE GIVEN USING COSINES
    static float cal_cos(float n)
    {
        float accuracy = 0.0001f, x1;
        float denominator, cosx, cosval;
        n = n * (3.142f / 180.0f);

        x1 = 1;

        // Maps the sum along the series
        cosx = x1;

        // Holds the actual value of sin(n)
        cosval = (float)Math.cos(n);
        int i = 1;
        do {
            denominator = 2 * i * (2 * i - 1);
            x1 = -x1 * n * n / denominator;
            cosx = cosx + x1;
            i = i + 1;
        } while (accuracy <= Math.abs(cosval - cosx));

        return cosx;
    }

    // Function to find third side
    static float third_side(int a, int b, float c)
    {
        float angle = cal_cos(c);

        return (float)Math.sqrt((a * a) +
                (b * b) - 2 * a * b * angle);
    }

    //Perimeter of the triangle
    static float findPerimeter(float a, float b, float c)
    {
        return (a + b + c);
    }

    //Area of a triangle
    static float findArea(float a, float b, float c)
    {

        if (a <= 0 || b <= 0 || c <= 0 || (a+b <= c) || a+c <=b || b+c <=a)
        {
            return 0;
        }
        float s = (a+b+c)/2;
        return (float)Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    //Checking congruecy of a triangle
    static String vals(int[] s1, int[] s2, int[] a1, int[] a2)
    {
        // function call for SSS congruency
        int cong_sss = sss(s1, s2);

        // function call for HL congruency
        int cong_hl = hl(s1, s2, a1, a2);

        // function call for SAS congruency
        int cong_sas = sas(s1, s2, a1, a2);

        // function call for ASA congruency
        int cong_asa = asa(s1, s2, a1, a2);

        // function call for AAS congruency
        int cong_aas = aas(s1, s2, a1, a2);


        if(cong_sss == 1 || cong_sas == 1 || cong_asa == 1 || cong_aas == 1 || cong_hl == 1)
        {
            // System.out.println("Triangles are congruent") ;

            if( cong_sss == 1)
            {
                return "SSS";
                // System.out.println("SSS");
            }

            else if( cong_hl == 1)
            {
                return "HL";
                // System.out.println("HL");
            }

            else if( cong_sas == 1)
            {
                return "SAS";
                // System.out.println("SAS");
            }

            else if( cong_asa == 1)
            {
                return "ASA";
                // System.out.println("ASA");
            }

            else if( cong_aas == 1)
            {
                return "AAS";
                // System.out.println("AAS");
            }

        }
        return "NONE";

    }


    //Merge sort - merge method
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
        {
            L[i] = arr[l + i];
        }
        for (int j=0; j<n2; ++j)
        {
            R[j] = arr[m + 1+ j];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }

            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //Merge sort - sort method
    static void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    //Driver function
//    public static void main(String args[])
//    {
//        System.out.println("Select one amone these :");
//        System.out.println("4. Classification of Triangle: ");
//        System.out.println("5. Area of CircumCircle formed by the Triangle: ");
//        System.out.println("6. Area of the Incircle formed by the Triangle: ");
//        System.out.println("7. Area of the Largest Triangle Inside a semi circle: ");
//        System.out.println("8. Find the Angles of the Triangle: ");
//        System.out.println("9. Find Other sides of the Triangle in the Right Angled Triangle: ");
//        System.out.println("10. Find Dimensions of the Triangle From Hypotenuse and Area: ");
//        System.out.println("11. Find Possible Number pairs of Hypotenuse and Area can form a triangle: ");
//        System.out.println("12. Find Minimum Increment in the sides required to get non-negative area: ");
//        System.out.println("13. Find the Thrid Side of the Triangle: ");
//        System.out.println("14. Find Perimeter of the Triangle: ");
//        System.out.println("15. Find Area of the Triangle: ");
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        switch(num)
//        {
//                case 1:
//                        System.out.println("The sides and angles of the Triangle 1 are 2,2,2 and 60,60,60 respectively" );
//                        System.out.println("The sides and angles of the Triangle 2 are 2,2,2 and 60,60,60 respecitvely");
//                        int[] s1 = {2,2,2};
//                        int[] s2 = {2,2,2};
//                        int[] a1 = {60,60,60};
//                        int[] a2 = {60,60,60};
//                        vals(s1,s2,a1,a2);
//                        break;
//
//
//                case 2: System.out.println("The sides and angles of the Triangle 1 are 2,3,3 and 80,60,40 respectively" );
//                        System.out.println("The sides and angles of the Triangle 2 are 4,6,6 and 40,60,80 respecitvely" );
//                        int S1[] = {2, 3, 3};
//                        int S2[] = {4, 6, 6};
//                        int A1[] = {80, 60, 40};
//                        int A2[] = {40, 60, 80};
//                        int aaa = simi_aaa(A1, A2);
//                        int sss = simi_sss(S1, S2) ;
//                        int sas = simi_sas(S1, S2,A1, A2) ;
//                        if(aaa == 1 ||  sss == 1 || sas == 1)
//                        {
//                           System.out.println( "Triangles are similar by: ");
//                            if(aaa == 1)
//                            {
//                                    System.out.println( "AAA ");
//                            }
//                            if(sss == 1)
//                            {
//                                    System.out.println("SSS ");
//                            }
//                            if(sas == 1)
//                            {
//                                    System.out.println("SAS.");
//                            }
//                        }
//
//                        else
//                        {
//                            System.out.println("Triangles are not similar");
//                        }
//                        break;
//
//
//                case 3: System.out.println("Enter values of the three sides");
//                        int a = sc.nextInt();
//                        int b = sc.nextInt();
//                        int c = sc.nextInt();
//                        if(checkValidity(a,b,c) == 1)
//                        {
//                            System.out.println("Triangle is valid");
//                        }
//                        else
//                        {
//                            System.out.println("Triangle is not valid");
//                        }
//                        break;
//
//
//                case 4: System.out.println("The points of the triangle are (0,0),(6,0),(0,8)");
//                        Point p1 = new Point (0,0);
//                        Point p2 = new Point (6,0);
//                        Point p3 = new Point (0,8);
//                        classifyTriangle(p1,p2,p3);
//                        break;
//
//
//                case 5:  System.out.println("Enter Valid Sides of Triangle");
//                         double d1 = sc.nextDouble();
//                         double d2 = sc.nextDouble();
//                         double d3 = sc.nextDouble();
//                         if(circlearea(d1,d2,d3) == -1)
//                         {
//                             System.out.println("Side of a Triangle is negative");
//                         }
//                         else
//                         {
//                             System.out.println("The Area of Circumcircle is " + circlearea(d1,d2,d3));
//                         }
//                         break;
//
//
//                case 6: System.out.println("Enter Valid Sides of Triangle");
//                        float f1 = sc.nextFloat();
//                        float f2 = sc.nextFloat();
//                        float f3 = sc.nextFloat();
//                        if(findRadiusOfIncircle(f1,f2,f3) == -1)
//                        {
//                             System.out.println("Side of a Triangle is negative");
//                        }
//                        else
//                        {
//                            System.out.println("The Radius of InCircle is " + findRadiusOfIncircle(f1,f2,f3));
//                        }
//                        break;
//
//
//                case 7: System.out.println("Enter Radius of the semicircle");
//                        float r = sc.nextFloat();
//                        if(trianglearea(r) == -1)
//                        {
//                            System.out.println("Radius is Negative");
//                        }
//                        else
//                        {
//                            System.out.println("Area of largest triangle that can be inscribed in a semi circle is " + trianglearea(r));
//                        }
//                        break;
//
//
//                case 8: System.out.println("The co-ordinates of the vertices of the Triangle are (0,0),(6,0),(0,8)");
//                        Point p4 = new Point (0,0);
//                        Point p5 = new Point (6,0);
//                        Point p6 = new Point (0,8);
//                        System.out.println("Angles of the Triangle which are represented as Alpha,beta and gamma are ");
//                        printAngle(p4,p5,p6);
//                        break;
//
//                case 9: System.out.println("Enter Known Side of the Right Angled Trinagle");
//                        int x = sc.nextInt();
//                        System.out.println("The other two sides represented as b and c are");
//                        printOtherSides(x);
//                        break;
//
//
//                case 10: System.out.println("Enter Hypotenuse and Area of the Right Angled Triangle");
//                         int h = sc.nextInt();
//                         int A = sc.nextInt();
//                         System.out.println("The other Two Sides of the Triangle are represented as P,B");
//                         findDimen(h,A);
//                         break;
//
//
//                case 11:    System.out.println("The Heights Given are 1,6,4");
//                            System.out.println("The Areas Given are 23,3,42,14");
//                            int H[] = { 1, 6, 4 };
//                                int n = H.length;
//                                int S[] = { 23, 3, 42, 14 };
//                                int m = S.length;
//                                System.out.println("Number of Pairs That can form Triangle are " + findPairs(H, n, S, m));
//                                break;
//
//                case 12: System.out.println("Enter sides of the Triangle");
//                         int s4 = sc.nextInt();
//                         int s5 = sc.nextInt();
//                         int s6 = sc.nextInt();
//                         if(minimumIncrease(s4,s5,s6) == 0)
//                         {
//                             System.out.println(" No Increment Needed");
//                         }
//                         else
//                         {
//                             System.out.println("The Increment Needed is: "+minimumIncrease(s4,s5,s6));
//                         }
//                         break;
//
//
//                case 13: System.out.println("Enter Known Sides of the Triangle and Third Angle");
//                        int s7 = sc.nextInt();
//                        int s8 = sc.nextInt();
//                        float f4 =sc.nextFloat();
//                        System.out.println("The unknown side of the Triangle is: "+third_side(s7,s8,f4));
//                        break;
//
//                case 14:  System.out.println("Enter Valid Sides of Triangle");
//                    	float f5 = sc.nextFloat();
//                    	float f6 = sc.nextFloat();
//                    	float f7 = sc.nextFloat();
//                    	System.out.println("Perimeter of the given triangle is" + findPerimeter(f5,f6,f7));
//                    	break;
//
//                case 15:  System.out.println("Enter Valid Sides of Triangle");
//                        float f8 = sc.nextFloat();
//                        float f9 = sc.nextFloat();
//                        float f10 = sc.nextFloat();
//                        System.out.println("Area of the given triangle is" + findArea(f8,f9,f10));
//                        break;
//        }
//        return ;
//
//    }
}