import static org.junit.Assert.*;

import org.junit.Test;
import java.awt.Point;

public class TestTriangles {

    //RACC - Restricted Active Clause Coverage 

    //PREDICATE - (s1[0] == s2[0] && s1[1] == s2[1] && s1[2] == s2[2])

    @Test
	public void testRACC1() {
		
		// Test Case:- T T T  and predicate is true
		
		int[] s1 = {7,8,9};
		int[] s2 = {7,8,9};
		
		assertEquals(1, Triangles.sss(s1, s2));
		
	}
	
	@Test
	public void testRACC2() {
		
		//Test Case:- F T T and  predicate is false

		int[] s1 = {7,8,9};
		int[] s2 = {6,8,9};
		
		assertEquals(0, Triangles.sss(s1, s2));
		
	}

	
	
	@Test
	public void testRACC3() {
		
		//Test Case:- T F T and  predicate is false 
		
		int[] s1 = {7,8,9};
		int[] s2 = {7,10,9};
		
		assertEquals(0, Triangles.sss(s1, s2));
		
	}
	
	@Test
	public void testRACC4() {
		
		//Test Case:- T T F and  predicate is false 

		int[] s1 = {7,8,9};
		int[] s2 = {7,8,10};
		
		assertEquals(0, Triangles.sss(s1, s2));
		
	}

    //CACC - Correlated Active Clause Coverage 

    //PREDICATE : -  (s1[2] == s2[2] && (s1[1] == s2[1] || s1[0] == s2[0]))
    // all  test inputs are right angle triangles


    @Test
	public void testCACC1() {
		
		//Test Case:- T T T and  predicate is true

		int[] s1 = {7,6,2};
		int[] s2 = {3,7,6};
		int[] a1 = {30,90,60};
		int[] a2 = {90,35,55};
		assertEquals(1,Triangles.hl(s1, s2, a1, a2));
		
	}
	
	@Test
	public void testCACC2() {
		
		//Test Case:- T F F and  predicate is false

		int[] s1 = {6,2,7};
		int[] s2 = {3,8,6};
		int[] a1 = {30,90,60};
		int[] a2 = {65,35,80};
		assertEquals(0,Triangles.hl(s1, s2, a1, a2));
		
	}


    //CACC - Correlated Active Clause Coverage 

    //PREDICATE : - (a + b >= c && a + c >= b && b  + c >= a)
    @Test
	public void testCACC4() {
		
		// Test Case:- T T T  and predicate is true
	
		assertEquals(1, Triangles.checkValidity(7,8,9));
		
	}
	
	@Test
	public void testCACC5() {
		
		//Test Case:- F T T and  predicate is false
	
		assertEquals(0, Triangles.checkValidity(4,3,9));
		
	}

	
	
	@Test
	public void testCACC6() {

		//Test Case:- T F T and  predicate is false
	
		assertEquals(0, Triangles.checkValidity(7,19,8));
		
	}
	
	@Test
	public void testCACC7() {
		
		//Test Case:- T T F and  predicate is false

		assertEquals(0, Triangles.checkValidity(17,7,8));
		
	}

    //GACC - Correlated Active Clause Coverage 

    //PREDICATE : - (a == b || b == c || c == a)
	
    @Test
	public void testGACC1() {
		
		// Test Case:- T F F  and predicate is true
	
		assertEquals(1, Triangles.isIsosceles(7,7,8));
		
	}
	
	@Test
	public void testGACC2() {
		
		// Test Case:- F T F  and predicate is true
	
		assertEquals(1, Triangles.isIsosceles(7,8,8));
		
	}

	
	
	@Test
	public void testGACC3() {

		// Test Case:- F F T and predicate is true
		
		assertEquals(1, Triangles.isIsosceles(7,8,7));
		
	}
	
	@Test
	public void testGACC4() {
		
		//	// Test Case:- F F F  and predicate is false
		assertEquals(0, Triangles.isIsosceles(7,8,9));
		
	}

	@Test
	public void testGetAngleClassification1() {
		int[] angles = {60,60,60};
		assertEquals("acute",Triangles.getAngleClassification(angles[0], angles[1], angles[2]));
	}

	@Test
	public void testGetAngleClassification2() {
		int[] angles = {60,30,90};
		assertEquals("right",Triangles.getAngleClassification(angles[0], angles[1], angles[2]));
	}

	@Test
	public void testGetAngleClassification3() {
		int[] angles = {60,20,100};
		assertEquals("obtuse",Triangles.getAngleClassification(angles[0], angles[1], angles[2]));
	}

	@Test
	public void testVals1() {
		int[] sides1 = {1,1,1};
		int[] sides2 = {1,1,1};
		int[] angles1 = {60,60,60};
		int[] angles2 = {60,60,60};
		assertEquals("SSS",Triangles.vals(sides1, sides2, angles1, angles2));
	}

	@Test
	public void testVals2() {
		int[] sides1 = {4,3,6};
		int[] sides2 = {3,5,6};
		int[] angles1 = {60,30,90};
		int[] angles2 = {90,70,20};
		assertEquals("HL",Triangles.vals(sides1, sides2, angles1, angles2));
	}

	@Test
	public void testVals3() {
		int[] sides1 = {6,3,5};
		int[] sides2 = {5,3,7};
		int[] angles1 = {60,40,80};
		int[] angles2 = {80,70,10};
		assertEquals("SAS",Triangles.vals(sides1, sides2, angles1, angles2));
	}

	@Test
	public void testVals4() {
		int[] sides1 = {5,7,3};
		int[] sides2 = {4,3,6};
		int[] angles1 = {60,50,80};
		int[] angles2 = {80,60,40};
		assertEquals("ASA",Triangles.vals(sides1, sides2, angles1, angles2));
	}

	@Test
	public void testVals5() {
		int[] sides1 = {5,7,3};
		int[] sides2 = {5, 4, 6};
		int[] angles1 = {60, 50, 80};
		int[] angles2 = {80,60,40};
		assertEquals("AAS",Triangles.vals(sides1, sides2, angles1, angles2));
	}

	@Test
	public void testVals6() {
		int[] sides1 = {5,7,3};
		int[] sides2 = {6,4,5};
		int[] angles1 = {40,50,90};
		int[] angles2 = {80,60,40};
		assertEquals("NONE",Triangles.vals(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testMinimumIncrease1() {
		int[] sides1 = {3,2,1};
		assertEquals(0,Triangles.minimumIncrease(sides1[0], sides1[1], sides1[2]));
	}

	@Test
	public void testMinimumIncrease2() {
		int[] sides1 = {5,2,1};
		assertEquals(2,Triangles.minimumIncrease(sides1[0], sides1[1], sides1[2]));
	}
	@Test
	public void testMinimumIncrease3() {
		int[] sides = {5,4,3};
		assertEquals(0,Triangles.minimumIncrease(sides[0], sides[1], sides[2]));
	}

	@Test
	public void testClassifyTriangle() {
		Point point1 = new Point (3,0);
		Point point2 = new Point (0,4);
		Point point3 = new Point (0,0);
		String[] arr = {"right","Scalene"};
		assertArrayEquals(arr,Triangles.classifyTriangle(point1,point2,point3));
	}

	@Test
	public void testLengthSquare() {
		Point point1 = new Point (2,2);
		Point point2 = new Point (1,1);
		assertEquals(2,Triangles.lengthSquare(point1, point2));
	}

	@Test
	public void testPrintOtherSides1() {
		int length = 5;
		int[] val = {12,13};
		assertArrayEquals(val,Triangles.printOtherSides(length));
	}

	@Test
	public void testPrintOtherSides2() {
		int val = 4;
		int[] values = {3,5};
		assertArrayEquals(values,Triangles.printOtherSides(val));
	}

	@Test
	public void testPrintOtherSides3() {
		int length = 1;
		int[] values = {-1,-1};
		assertArrayEquals(values,Triangles.printOtherSides(length));
	}

	@Test
	public void testPrintOtherSides4() {
		int length = 2;
		int[] values = {-1,-1};
		assertArrayEquals(values,Triangles.printOtherSides(length));
	}


	@Test
	public void testFindPairs() {
		int val1 = 2, val2 = 2;
		int[] n1 = {4,6};
		int[] n2 = {3,9};
		assertEquals(3,Triangles.findPairs(n1, val1, n2, val2));
	}


	@Test
	public void testGetSideClassification1() {
		int[] sides = {2,2,2};
		assertEquals("Equilateral",Triangles.getSideClassification(sides[0], sides[1], sides[2]));
	}

	@Test
	public void testGetSideClassification2() {
		int[] sides = {2,3,1};
		assertEquals("Scalene",Triangles.getSideClassification(sides[0], sides[1], sides[2]));
	}

	@Test
	public void testGetSideClassification3() {
		int[] sides = {2,2,1};
		assertEquals("Isosceles",Triangles.getSideClassification(sides[0], sides[1], sides[2]));
	}

	@Test
	public void testSquare() {
		assertEquals(9,Triangles.square(3));
	}

	@Test
	public void testOrder() {
		assertEquals(7,Triangles.order(9, 8, 7));
	}

	@Test
	public void testEuclidDistSquare() {
		Point point1 = new Point(6,5);
		Point point2 = new Point(2,1);
		assertEquals(32,Triangles.euclidDistSquare(point1, point2));
	}

	@Test
	public void testSimi_sss() {
		int[] sides1 = {16,6,4};
		int[] sides2 = {8,3,2};
		assertEquals(1,Triangles.simi_sss(sides1, sides2));
	}
	@Test
	public void testSimi_sss1() {
		int[] sides1 = {16,8,4};
		int[] sides2 = {8,3,2};
		assertEquals(1,Triangles.simi_sss(sides1, sides2));
	}
	@Test
	public void testSimi_sas() {
		int[] sides1 = {4,6,10};
		int[] sides2 = {3,6,2};
		int[] angles1 = {60,90,30};
		int[] angles2 = {80,90,35};
		assertEquals(1,Triangles.simi_sas(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testSimi_sas1() {
		int[] sides1 = {4,8,1};
		int[] sides2 = {4,2,1};
		int[] angles1 = {120,30,30};
		int[] angles2 = {90,30,60};
		assertEquals(1,Triangles.simi_sas(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testSimi_sas2() {
		int[] sides1 = {11, 9, 4};
		int[] sides2 = {11, 8, 8};
		int[] angles1 = {30, 60, 90};
		int[] angles2 = {100, 60, 20};
		assertEquals(1, Triangles.simi_sas(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testSimi_aaa() {
		int[] angles1 = {90,30,60};
		int[] angles2 = {60,90,30};
		assertEquals(1,Triangles.simi_aaa(angles1,angles2));
	}
	@Test
	public void testSimi_aaa1() {
		int[] angles1 = {60,90,30};
		int[] angles2 = {30,70,80};
		assertEquals(0,Triangles.simi_aaa(angles1,angles2));
	}

	@Test
	public void testGetSides1() {
		int[] sides = {2,4,5};
		assertArrayEquals(sides,Triangles.getSides1(4,2,5));
	}

	@Test
	public void testGetSides2() {
		int[] sides = {2,4,5};
		assertArrayEquals(sides,Triangles.getSides2(sides[0], sides[1],sides[2]));
	}

	@Test
	public void testGetAngles1() {
		int[] angles = {30,60,90};
		assertArrayEquals(angles,Triangles.getAngles1(60,30,90));
	}

	@Test
	public void testGetAngles2() {
		int[] angles = {30,60,90};
		assertArrayEquals(angles,Triangles.getAngles2(angles[0], angles[1],angles[2]));
	}
	@Test
	public void testAas() {
		int[] sides1 = {4,3,2};
		int[] sides2 = {5,2,4};
		int[] angles1 = {30,80,70};
		int[] angles2 = {70,30,80};
		assertEquals(1,Triangles.aas(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testAas1() {
		int[] sides1 = {2,7,6};
		int[] sides2 = {6,7,3};
		int[] angles1 = {30,70,80};
		int[] angles2 = {30,80,70};
		assertEquals(1,Triangles.aas(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testAas2() {
		int[] sides1 = {2,7,6};
		int[] sides2 = {5,3,7};
		int[] angles1 = {50,70,60};
		int[] angles2 = {50,70,50};
		assertEquals(1,Triangles.aas(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testAas3() {
		int[] sides1 = {2,7,6};
		int[] sides2 = {7,5,3};
		int[] angles1 = {30,0,60};
		int[] angles2 = {55,45,100};
		assertEquals(0,Triangles.aas(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testAsa() {
		int[] sides1 = {4,3,2};
		int[] sides2 = {4,4,1};
		int[] angles1 = {30,80,70};
		int[] angles2 = {70,80,30};
		assertEquals(1,Triangles.asa(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testAsa1() {
		int[] sides1 = {2,4,3};
		int[] sides2 = {2,6,5};
		int[] angles1 = {30,70,80};
		int[] angles2 = {70,80,30};
		assertEquals(1,Triangles.asa(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testAsa2() {
		int[] sides1 = {2,5,4};
		int[] sides2 = {4,1,4};
		int[] angles1 = {30,70,80};
		int[] angles2 = {70,80,30};
		assertEquals(1,Triangles.asa(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testAsa3() {
		int[] sides1 = {4,3,2};
		int[] sides2 = {2,1,2};
		int[] angles1 = {70,80,30};
		int[] angles2 = {30,70,80};
		assertEquals(0,Triangles.asa(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testSas() {
		int[] sides1 = {4,4,2};
		int[] sides2 = {2,5,4};
		int[] angles1 = {120,20,70};
		int[] angles2 = {120,30,30};
		assertEquals(1,Triangles.sas(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testSas2() {
		int[] sides1 = {7,5,6};
		int[] sides2 = {7,4,6};
		int[] angles1 = {60,90,30};
		int[] angles2 = {60,30,60};
		assertEquals(1,Triangles.sas(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testSas3() {
		int[] sides1 = {6,5,3};
		int[] sides2 = {3,6,4};
		int[] angles1 = {30,90,60};
		int[] angles2 = {20,60,100};
		assertEquals(1,Triangles.sas(sides1, sides2, angles1, angles2));
	}
	@Test
	public void testSas4() {
		int[] sides1 = {6,5,3};
		int[] sides2 = {12,14,13};
		int[] angles1 = {60,90,30};
		int[] angles2 = {50,80,50};
		assertEquals(0,Triangles.sas(sides1, sides2, angles1, angles2));
	}

	}