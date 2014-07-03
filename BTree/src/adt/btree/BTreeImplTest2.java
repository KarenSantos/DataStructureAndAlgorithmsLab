package adt.btree;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BTreeImplTest2 {
	
	BTreeImpl<Integer> treeOrd2, treeOrd4;
	
	
	@Before
	public void setShitUp(){
		treeOrd2 = new BTreeImpl<>(3);
		treeOrd4 = new BTreeImpl<>(5);
	}

	@Test
	public void testEveryShit() {
		for(int i = 0; i < 300 ; i++){
			//assertEquals(new BNodePosition<Integer>(), treeOrd2.search(i));		
			assertEquals(-1, treeOrd2.height());
			
		}
		
		assertEquals(treeOrd2.getRoot(), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot(), treeOrd2.minimum(treeOrd2.getRoot()));
		
		treeOrd2.insert(100);
		
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(1, treeOrd2.size());
		assertEquals(0, treeOrd2.height());
		assertEquals(treeOrd2.getRoot(), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot(), treeOrd2.minimum(treeOrd2.getRoot()));
		
		treeOrd2.insert(200);
		
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(1, treeOrd2.search(200).position);
		assertEquals(2, treeOrd2.size());
		assertEquals(0, treeOrd2.height());
		assertEquals(treeOrd2.getRoot(), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot(), treeOrd2.minimum(treeOrd2.getRoot()));
		
		/***
		 * 
		 *            200
		 *         100   300 
		 * 
		 * 
		 */

		treeOrd2.insert(300);
		assertEquals(new Integer(200), treeOrd2.getRoot().getElements().get(0));
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(300).position);
		
		assertEquals(3, treeOrd2.size());
		assertEquals(1, treeOrd2.height());
		assertTrue(new Integer(200).equals(treeOrd2.getRoot().getElementAt(0)));

		assertEquals(treeOrd2.getRoot().getChildren().get(1), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().get(0), treeOrd2.minimum(treeOrd2.getRoot()));
	
		
		treeOrd2.insert(50);
		
		/***
		 * 
		 *                 200
		 *       50  100         300 
		 * 
		 * 
		 */

		assertEquals(0, treeOrd2.search(50).position);
		assertEquals(1, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(300).position);
		
		assertEquals(4, treeOrd2.size());
		assertEquals(1, treeOrd2.height());
		
		assertEquals(treeOrd2.getRoot().getChildren().get(1), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().get(0), treeOrd2.minimum(treeOrd2.getRoot()));
	

		treeOrd2.insert(150);
		
		/***
		 * 
		 *            100       200
		 *       50        150        300 
		 * 
		 * 
		 */

		assertEquals(0, treeOrd2.search(50).position);
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(150).position);
		assertEquals(1, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(300).position);
		
		assertEquals(5, treeOrd2.size());
		assertEquals(1, treeOrd2.height());
		
		assertEquals(treeOrd2.getRoot().getChildren().get(2), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().get(0), treeOrd2.minimum(treeOrd2.getRoot()));
	

		treeOrd2.insert(250);

		assertEquals(0, treeOrd2.search(50).position);
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(150).position);
		assertEquals(1, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(250).position);
		assertEquals(1, treeOrd2.search(300).position);
		
		assertEquals(6, treeOrd2.size());
		assertEquals(1, treeOrd2.height());
		
		assertEquals(treeOrd2.getRoot().getChildren().get(2), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().get(0), treeOrd2.minimum(treeOrd2.getRoot()));
	


		treeOrd2.insert(350);

		assertEquals(0, treeOrd2.search(50).position);
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(150).position);
		assertEquals(0, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(250).position);
		assertEquals(0, treeOrd2.search(300).position);
		assertEquals(0, treeOrd2.search(350).position);
		
		assertEquals(7, treeOrd2.size());
		assertEquals(2, treeOrd2.height());
		
		assertEquals(treeOrd2.getRoot().getChildren().get(1).getChildren().get(1), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().get(0).getChildren().get(0), treeOrd2.minimum(treeOrd2.getRoot()));
	


		treeOrd2.insert(25);

		assertEquals(0, treeOrd2.search(25).position);
		assertEquals(1, treeOrd2.search(50).position);
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(150).position);
		assertEquals(0, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(250).position);
		assertEquals(0, treeOrd2.search(300).position);
		assertEquals(0, treeOrd2.search(350).position);
		
		assertEquals(8, treeOrd2.size());
		assertEquals(2, treeOrd2.height());
		
		assertEquals(treeOrd2.getRoot().getChildren().get(1).getChildren().get(1), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().get(0).getChildren().get(0), treeOrd2.minimum(treeOrd2.getRoot()));
	


		treeOrd2.insert(125);

		assertEquals(0, treeOrd2.search(25).position);
		assertEquals(1, treeOrd2.search(50).position);
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(125).position);
		assertEquals(1, treeOrd2.search(150).position);
		assertEquals(0, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(250).position);
		assertEquals(0, treeOrd2.search(300).position);
		assertEquals(0, treeOrd2.search(350).position);
		
		assertEquals(9, treeOrd2.size());
		assertEquals(2, treeOrd2.height());
		
		assertEquals(treeOrd2.getRoot().getChildren().get(1).getChildren().get(1), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().get(0).getChildren().get(0), treeOrd2.minimum(treeOrd2.getRoot()));
	
		
		treeOrd2.insert(225);

		assertEquals(0, treeOrd2.search(25).position);
		assertEquals(1, treeOrd2.search(50).position);
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(125).position);
		assertEquals(1, treeOrd2.search(150).position);
		assertEquals(0, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(225).position);
		assertEquals(1, treeOrd2.search(250).position);
		assertEquals(0, treeOrd2.search(300).position);
		assertEquals(0, treeOrd2.search(350).position);
		
		assertEquals(10, treeOrd2.size());
		assertEquals(2, treeOrd2.height());
		
		assertEquals(treeOrd2.getRoot().getChildren().get(1).getChildren().get(1), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().get(0).getChildren().get(0), treeOrd2.minimum(treeOrd2.getRoot()));
	
		
		treeOrd2.insert(325);

		assertEquals(0, treeOrd2.search(25).position);
		assertEquals(1, treeOrd2.search(50).position);
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(125).position);
		assertEquals(1, treeOrd2.search(150).position);
		assertEquals(0, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(225).position);
		assertEquals(1, treeOrd2.search(250).position);
		assertEquals(0, treeOrd2.search(300).position);
		assertEquals(0, treeOrd2.search(325).position);
		assertEquals(1, treeOrd2.search(350).position);
		
		assertEquals(11, treeOrd2.size());
		assertEquals(2, treeOrd2.height());
		
		assertEquals(treeOrd2.getRoot().getChildren().get(1).getChildren().get(1), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().get(0).getChildren().get(0), treeOrd2.minimum(treeOrd2.getRoot()));
	
		
		treeOrd2.insert(75);

		assertEquals(0, treeOrd2.search(25).position);
		assertEquals(0, treeOrd2.search(50).position);
		assertEquals(0, treeOrd2.search(75).position);
		assertEquals(1, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(125).position);
		assertEquals(1, treeOrd2.search(150).position);
		assertEquals(0, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(225).position);
		assertEquals(1, treeOrd2.search(250).position);
		assertEquals(0, treeOrd2.search(300).position);
		assertEquals(0, treeOrd2.search(325).position);
		assertEquals(1, treeOrd2.search(350).position);
		
		assertEquals(12, treeOrd2.size());
		assertEquals(2, treeOrd2.height());
		
		assertEquals(treeOrd2.getRoot().getChildren().get(1).getChildren().get(1), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().get(0).getChildren().get(0), treeOrd2.minimum(treeOrd2.getRoot()));
	
		
		treeOrd2.insert(175);

		assertEquals(0, treeOrd2.search(25).position);
		assertEquals(0, treeOrd2.search(50).position);
		assertEquals(0, treeOrd2.search(75).position);
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(125).position);
		assertEquals(0, treeOrd2.search(150).position);
		assertEquals(0, treeOrd2.search(175).position);
		assertEquals(1, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(225).position);
		assertEquals(1, treeOrd2.search(250).position);
		assertEquals(0, treeOrd2.search(300).position);
		assertEquals(0, treeOrd2.search(325).position);
		assertEquals(1, treeOrd2.search(350).position);
		
		assertEquals(13, treeOrd2.size());
		assertEquals(2, treeOrd2.height());
		
		assertEquals(treeOrd2.getRoot().getChildren().getLast().getChildren().get(1), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().get(0).getChildren().get(0), treeOrd2.minimum(treeOrd2.getRoot()));
	
		
		treeOrd2.insert(275);

		assertEquals(0, treeOrd2.search(25).position);
		assertEquals(0, treeOrd2.search(50).position);
		assertEquals(0, treeOrd2.search(75).position);
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(125).position);
		assertEquals(0, treeOrd2.search(150).position);
		assertEquals(0, treeOrd2.search(175).position);
		assertEquals(1, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(225).position);
		assertEquals(0, treeOrd2.search(250).position);
		assertEquals(0, treeOrd2.search(275).position);
		assertEquals(1, treeOrd2.search(300).position);
		assertEquals(0, treeOrd2.search(325).position);
		assertEquals(1, treeOrd2.search(350).position);
		
		assertEquals(14, treeOrd2.size());
		assertEquals(2, treeOrd2.height());
		
		assertEquals(treeOrd2.getRoot().getChildren().getLast().getChildren().getLast(), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().get(0).getChildren().get(0), treeOrd2.minimum(treeOrd2.getRoot()));
	
		
		treeOrd2.insert(375);

		assertEquals(0, treeOrd2.search(25).position);
		assertEquals(0, treeOrd2.search(50).position);
		assertEquals(0, treeOrd2.search(75).position);
		assertEquals(0, treeOrd2.search(100).position);
		assertEquals(0, treeOrd2.search(125).position);
		assertEquals(0, treeOrd2.search(150).position);
		assertEquals(0, treeOrd2.search(175).position);
		assertEquals(0, treeOrd2.search(200).position);
		assertEquals(0, treeOrd2.search(225).position);
		assertEquals(0, treeOrd2.search(250).position);
		assertEquals(0, treeOrd2.search(275).position);
		assertEquals(0, treeOrd2.search(300).position);
		assertEquals(0, treeOrd2.search(325).position);
		assertEquals(0, treeOrd2.search(350).position);
		assertEquals(0, treeOrd2.search(375).position);
		
		assertEquals(15, treeOrd2.size());
		assertEquals(3, treeOrd2.height());
		
		assertEquals(treeOrd2.getRoot().getChildren().getLast().getChildren().getLast().getChildren().getLast(), treeOrd2.maximum(treeOrd2.getRoot()));
		assertEquals(treeOrd2.getRoot().getChildren().getFirst().getChildren().getFirst().getChildren().getFirst(), treeOrd2.minimum(treeOrd2.getRoot()));
	
		
		
		
		// ------------------------------------------ ORDER 4 ------------------------------------------------------------------
		
		
		
		for(int i = 0; i < 300 ; i++){
			//assertEquals(new BNodePosition<Integer>(), treeOrd4.search(i));
		//	assertTrue(Arrays.equals(new BNode[0],treeOrd4.depthLeftOrder()));
			assertEquals(-1, treeOrd4.height());
		}
		
		assertEquals(treeOrd4.getRoot(), treeOrd4.maximum(treeOrd4.getRoot()));
		assertEquals(treeOrd4.getRoot(), treeOrd4.minimum(treeOrd4.getRoot()));
		
		treeOrd4.insert(100);
		
		assertEquals(0, treeOrd4.search(100).position);
		assertEquals(1, treeOrd4.size());
		assertEquals(0, treeOrd4.height());
		
		treeOrd4.insert(200);
		
		assertEquals(0, treeOrd4.search(100).position);
		assertEquals(1, treeOrd4.search(200).position);
		
		assertEquals(2, treeOrd4.size());
		assertEquals(0, treeOrd4.height());

		treeOrd4.insert(300);

		assertEquals(0, treeOrd4.search(100).position);
		assertEquals(1, treeOrd4.search(200).position);
		assertEquals(2, treeOrd4.search(300).position);
		
		assertEquals(3, treeOrd4.size());
		assertEquals(0, treeOrd4.height());

		treeOrd4.insert(50);

		assertEquals(0, treeOrd4.search(50).position);
		assertEquals(1, treeOrd4.search(100).position);
		assertEquals(2, treeOrd4.search(200).position);
		assertEquals(3, treeOrd4.search(300).position);
		
		assertEquals(4, treeOrd4.size());
		assertEquals(0, treeOrd4.height());

		treeOrd4.insert(150);

		assertEquals(0, treeOrd4.search(50).position);
		assertEquals(1, treeOrd4.search(100).position);
		assertEquals(0, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(200).position);
		assertEquals(1, treeOrd4.search(300).position);
		
		assertEquals(5, treeOrd4.size());
		assertEquals(1, treeOrd4.height());

		treeOrd4.insert(250);

		assertEquals(0, treeOrd4.search(50).position);
		assertEquals(1, treeOrd4.search(100).position);
		assertEquals(0, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(200).position);
		assertEquals(1, treeOrd4.search(250).position);
		assertEquals(2, treeOrd4.search(300).position);
		
		assertEquals(6, treeOrd4.size());
		assertEquals(1, treeOrd4.height());


		treeOrd4.insert(350);

		assertEquals(0, treeOrd4.search(50).position);
		assertEquals(1, treeOrd4.search(100).position);
		assertEquals(0, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(200).position);
		assertEquals(1, treeOrd4.search(250).position);
		assertEquals(2, treeOrd4.search(300).position);
		assertEquals(3, treeOrd4.search(350).position);
		
		assertEquals(7, treeOrd4.size());
		assertEquals(1, treeOrd4.height());


		treeOrd4.insert(25);

		assertEquals(0, treeOrd4.search(25).position);
		assertEquals(1, treeOrd4.search(50).position);
		assertEquals(2, treeOrd4.search(100).position);
		assertEquals(0, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(200).position);
		assertEquals(1, treeOrd4.search(250).position);
		assertEquals(2, treeOrd4.search(300).position);
		assertEquals(3, treeOrd4.search(350).position);
		
		assertEquals(8, treeOrd4.size());
		assertEquals(1, treeOrd4.height());


		treeOrd4.insert(125);

		assertEquals(0, treeOrd4.search(25).position);
		assertEquals(1, treeOrd4.search(50).position);
		assertEquals(2, treeOrd4.search(100).position);
		assertEquals(3, treeOrd4.search(125).position);
		assertEquals(0, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(200).position);
		assertEquals(1, treeOrd4.search(250).position);
		assertEquals(2, treeOrd4.search(300).position);
		assertEquals(3, treeOrd4.search(350).position);
		
		assertEquals(9, treeOrd4.size());
		assertEquals(1, treeOrd4.height());
		
		treeOrd4.insert(225);

		assertEquals(0, treeOrd4.search(25).position);
		assertEquals(1, treeOrd4.search(50).position);
		assertEquals(2, treeOrd4.search(100).position);
		assertEquals(3, treeOrd4.search(125).position);
		assertEquals(0, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(200).position);
		assertEquals(1, treeOrd4.search(225).position);
		assertEquals(1, treeOrd4.search(250).position);
		assertEquals(0, treeOrd4.search(300).position);
		assertEquals(1, treeOrd4.search(350).position);
		
		assertEquals(10, treeOrd4.size());
		assertEquals(1, treeOrd4.height());
		
		treeOrd4.insert(325);

		assertEquals(0, treeOrd4.search(25).position);
		assertEquals(1, treeOrd4.search(50).position);
		assertEquals(2, treeOrd4.search(100).position);
		assertEquals(3, treeOrd4.search(125).position);
		assertEquals(0, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(200).position);
		assertEquals(1, treeOrd4.search(225).position);
		assertEquals(1, treeOrd4.search(250).position);
		assertEquals(0, treeOrd4.search(300).position);
		assertEquals(1, treeOrd4.search(325).position);
		assertEquals(2, treeOrd4.search(350).position);
	
		
		assertEquals(11, treeOrd4.size());
		assertEquals(1, treeOrd4.height());
		
		treeOrd4.insert(75);

		assertEquals(0, treeOrd4.search(25).position);
		assertEquals(1, treeOrd4.search(50).position);
		assertEquals(0, treeOrd4.search(75).position);
		assertEquals(0, treeOrd4.search(100).position);
		assertEquals(1, treeOrd4.search(125).position);
		assertEquals(1, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(200).position);
		assertEquals(1, treeOrd4.search(225).position);
		assertEquals(2, treeOrd4.search(250).position);
		assertEquals(0, treeOrd4.search(300).position);
		assertEquals(1, treeOrd4.search(325).position);
		assertEquals(2, treeOrd4.search(350).position);
		
		assertEquals(12, treeOrd4.size());
		assertEquals(1, treeOrd4.height());
		
		treeOrd4.insert(175);

		assertEquals(0, treeOrd4.search(25).position);
		assertEquals(1, treeOrd4.search(50).position);
		assertEquals(0, treeOrd4.search(75).position);
		assertEquals(0, treeOrd4.search(100).position);
		assertEquals(1, treeOrd4.search(125).position);
		assertEquals(1, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(175).position);
		assertEquals(1, treeOrd4.search(200).position);
		assertEquals(2, treeOrd4.search(225).position);
		assertEquals(2, treeOrd4.search(250).position);
		assertEquals(0, treeOrd4.search(300).position);
		assertEquals(1, treeOrd4.search(325).position);
		assertEquals(2, treeOrd4.search(350).position);
		
		assertEquals(13, treeOrd4.size());
		assertEquals(1, treeOrd4.height());
		
		treeOrd4.insert(275);

		assertEquals(0, treeOrd4.search(25).position);
		assertEquals(1, treeOrd4.search(50).position);
		assertEquals(0, treeOrd4.search(75).position);
		assertEquals(0, treeOrd4.search(100).position);
		assertEquals(1, treeOrd4.search(125).position);
		assertEquals(1, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(175).position);
		assertEquals(1, treeOrd4.search(200).position);
		assertEquals(2, treeOrd4.search(225).position);
		assertEquals(2, treeOrd4.search(250).position);
		assertEquals(0, treeOrd4.search(275).position);
		assertEquals(1, treeOrd4.search(300).position);
		assertEquals(2, treeOrd4.search(325).position);
		assertEquals(3, treeOrd4.search(350).position);
		
		assertEquals(14, treeOrd4.size());
		assertEquals(1, treeOrd4.height());
		
		treeOrd4.insert(375);

		assertEquals(0, treeOrd4.search(25).position);
		assertEquals(1, treeOrd4.search(50).position);
		assertEquals(0, treeOrd4.search(75).position);
		assertEquals(0, treeOrd4.search(100).position);
		assertEquals(1, treeOrd4.search(125).position);
		assertEquals(1, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(175).position);
		assertEquals(1, treeOrd4.search(200).position);
		assertEquals(2, treeOrd4.search(225).position);
		assertEquals(2, treeOrd4.search(250).position);
		assertEquals(0, treeOrd4.search(275).position);
		assertEquals(1, treeOrd4.search(300).position);
		assertEquals(3, treeOrd4.search(325).position);
		assertEquals(0, treeOrd4.search(350).position);
		assertEquals(1, treeOrd4.search(375).position);
		
		assertEquals(15, treeOrd4.size());
		assertEquals(1, treeOrd4.height());
		
		treeOrd4.insert(205);

		assertEquals(0, treeOrd4.search(25).position);
		assertEquals(1, treeOrd4.search(50).position);
		assertEquals(0, treeOrd4.search(75).position);
		assertEquals(0, treeOrd4.search(100).position);
		assertEquals(1, treeOrd4.search(125).position);
		assertEquals(1, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(175).position);
		assertEquals(1, treeOrd4.search(200).position);
		assertEquals(2, treeOrd4.search(205).position);
		assertEquals(3, treeOrd4.search(225).position);
		assertEquals(2, treeOrd4.search(250).position);
		assertEquals(0, treeOrd4.search(275).position);
		assertEquals(1, treeOrd4.search(300).position);
		assertEquals(3, treeOrd4.search(325).position);
		assertEquals(0, treeOrd4.search(350).position);
		assertEquals(1, treeOrd4.search(375).position);
		
		assertEquals(16, treeOrd4.size());
		assertEquals(1, treeOrd4.height());
		

		treeOrd4.insert(195);

		assertEquals(0, treeOrd4.search(25).position);
		assertEquals(1, treeOrd4.search(50).position);
		assertEquals(0, treeOrd4.search(75).position);
		assertEquals(0, treeOrd4.search(100).position);
		assertEquals(1, treeOrd4.search(125).position);
		assertEquals(1, treeOrd4.search(150).position);
		assertEquals(0, treeOrd4.search(175).position);
		assertEquals(1, treeOrd4.search(195).position);
		assertEquals(0, treeOrd4.search(200).position);
		assertEquals(0, treeOrd4.search(205).position);
		assertEquals(1, treeOrd4.search(225).position);
		assertEquals(0, treeOrd4.search(250).position);
		assertEquals(0, treeOrd4.search(275).position);
		assertEquals(1, treeOrd4.search(300).position);
		assertEquals(1, treeOrd4.search(325).position);
		assertEquals(0, treeOrd4.search(350).position);
		assertEquals(1, treeOrd4.search(375).position);
		
		assertEquals(17, treeOrd4.size());
		assertEquals(2, treeOrd4.height());

	
	}

}
