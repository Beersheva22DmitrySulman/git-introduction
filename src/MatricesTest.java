import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MatricesTest {
	
	@Test
	void transTest() {
		int[][] matrix = {
				{1, 2},
				{3, 4},
				{4, 5}
		};		
		int[][] expected = {
				{1, 3, 4},
				{2, 4, 5}
		};
		assertArrayEquals(expected, Matrices.transp(matrix));
		
		int[][] matrix1 = {
				{1, 20, 10, 31, -5, 18, 7},
				{0, 3, 33, 4, 5, 13, -15},
				{44, 5, 6, 12, 33, 74, 1}
		};		
		int[][] expected1 = {
				{1, 0, 44},
				{20, 3, 5},
				{10, 33, 6},
				{31, 4, 12},
				{-5, 5, 33},
				{18, 13, 74},
				{7, -15, 1}
		};
		assertArrayEquals(expected1, Matrices.transp(matrix1));
	}
}
