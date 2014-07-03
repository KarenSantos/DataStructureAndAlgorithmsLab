package adt.btree;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class BTreeImplTest1 {
	
	BTreeImpl<Integer>  treeOrd3, treeOrd5;
	
	
	@Before
	public void setShitUp(){
		treeOrd3 = new BTreeImpl<Integer>(3);
		treeOrd5 = new BTreeImpl<Integer>(5);
		
	}

	@Test
	public void testEveryShit() {
		for(int i = 0; i < 300 ; i++){
			assertTrue(new BNodePosition<Integer>().node == treeOrd3.search(i).node);		
			assertTrue(new BNodePosition<Integer>().position == treeOrd3.search(i).position);		
			assertEquals(-1, treeOrd3.height());
		}
		
		
		treeOrd3.insert(100);
		
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(1, treeOrd3.size());
		assertEquals(0, treeOrd3.height());
		
		treeOrd3.insert(200);
		
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(1, treeOrd3.search(200).position);
		assertEquals(2, treeOrd3.size());
		assertEquals(0, treeOrd3.height());

		treeOrd3.insert(300);

		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(300).position);
		
		assertEquals(3, treeOrd3.size());
		assertEquals(1, treeOrd3.height());

		treeOrd3.insert(50);

		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(1, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(300).position);
		
		assertEquals(4, treeOrd3.size());
		assertEquals(1, treeOrd3.height());

		treeOrd3.insert(150);

		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(1, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(300).position);
		
		assertEquals(5, treeOrd3.size());
		assertEquals(1, treeOrd3.height());

		treeOrd3.insert(250);

		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(1, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(250).position);
		assertEquals(1, treeOrd3.search(300).position);
		
		assertEquals(6, treeOrd3.size());
		assertEquals(1, treeOrd3.height());


		treeOrd3.insert(350);

		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(350).position);
		
		assertEquals(7, treeOrd3.size());
		assertEquals(2, treeOrd3.height());


		treeOrd3.insert(25);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(1, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(350).position);
		
		assertEquals(8, treeOrd3.size());
		assertEquals(2, treeOrd3.height());


		treeOrd3.insert(125);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(1, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(1, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(350).position);
		
		assertEquals(9, treeOrd3.size());
		assertEquals(2, treeOrd3.height());
		
		treeOrd3.insert(225);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(1, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(1, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(225).position);
		assertEquals(1, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(350).position);
		
		assertEquals(10, treeOrd3.size());
		assertEquals(2, treeOrd3.height());
		
		treeOrd3.insert(325);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(1, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(1, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(225).position);
		assertEquals(1, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(325).position);
		assertEquals(1, treeOrd3.search(350).position);
		
		assertEquals(11, treeOrd3.size());
		assertEquals(2, treeOrd3.height());
		
		treeOrd3.insert(75);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(75).position);
		assertEquals(1, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(1, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(225).position);
		assertEquals(1, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(325).position);
		assertEquals(1, treeOrd3.search(350).position);
		
		assertEquals(12, treeOrd3.size());
		assertEquals(2, treeOrd3.height());
		
		treeOrd3.insert(175);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(75).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(175).position);
		assertEquals(1, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(225).position);
		assertEquals(1, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(325).position);
		assertEquals(1, treeOrd3.search(350).position);
		
		assertEquals(13, treeOrd3.size());
		assertEquals(2, treeOrd3.height());
		
		treeOrd3.insert(275);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(75).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(175).position);
		assertEquals(1, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(225).position);
		assertEquals(0, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(275).position);
		assertEquals(1, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(325).position);
		assertEquals(1, treeOrd3.search(350).position);
		
		assertEquals(14, treeOrd3.size());
		assertEquals(2, treeOrd3.height());
		
		treeOrd3.insert(375);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(75).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(175).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(225).position);
		assertEquals(0, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(275).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(325).position);
		assertEquals(0, treeOrd3.search(350).position);
		assertEquals(0, treeOrd3.search(375).position);
		
		assertEquals(15, treeOrd3.size());
		assertEquals(3, treeOrd3.height());
		
		
		
		// ------------------------------------------ ORDER 4 ------------------------------------------------------------------
		
		
		
		for(int i = 0; i < 300 ; i++){
			assertTrue(new BNodePosition<Integer>().node == treeOrd5.search(i).node);
			assertTrue(new BNodePosition<Integer>().position == treeOrd5.search(i).position);
			assertTrue(Arrays.equals(new BNode[0],treeOrd5.depthLeftOrder()));
			assertEquals(-1, treeOrd5.height());
		}
		
		
		treeOrd5.insert(100);
		
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
		
		treeOrd5.insert(200);
		
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(200).position);
		
		assertEquals(2, treeOrd5.size());
		assertEquals(0, treeOrd5.height());

		treeOrd5.insert(300);

		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(200).position);
		assertEquals(2, treeOrd5.search(300).position);
		
		assertEquals(3, treeOrd5.size());
		assertEquals(0, treeOrd5.height());

		treeOrd5.insert(50);

		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(100).position);
		assertEquals(2, treeOrd5.search(200).position);
		assertEquals(3, treeOrd5.search(300).position);
		
		assertEquals(4, treeOrd5.size());
		assertEquals(0, treeOrd5.height());

		treeOrd5.insert(150);

		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(100).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(300).position);
		
		assertEquals(5, treeOrd5.size());
		assertEquals(1, treeOrd5.height());

		treeOrd5.insert(250);

		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(100).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(250).position);
		assertEquals(2, treeOrd5.search(300).position);
		
		assertEquals(6, treeOrd5.size());
		assertEquals(1, treeOrd5.height());


		treeOrd5.insert(350);

		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(100).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(250).position);
		assertEquals(2, treeOrd5.search(300).position);
		assertEquals(3, treeOrd5.search(350).position);
		
		assertEquals(7, treeOrd5.size());
		assertEquals(1, treeOrd5.height());


		treeOrd5.insert(25);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(100).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(250).position);
		assertEquals(2, treeOrd5.search(300).position);
		assertEquals(3, treeOrd5.search(350).position);
		
		assertEquals(8, treeOrd5.size());
		assertEquals(1, treeOrd5.height());


		treeOrd5.insert(125);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(100).position);
		assertEquals(3, treeOrd5.search(125).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(250).position);
		assertEquals(2, treeOrd5.search(300).position);
		assertEquals(3, treeOrd5.search(350).position);
		
		assertEquals(9, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(225);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(100).position);
		assertEquals(3, treeOrd5.search(125).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(225).position);
		assertEquals(1, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(350).position);
		
		assertEquals(10, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(325);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(100).position);
		assertEquals(3, treeOrd5.search(125).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(225).position);
		assertEquals(1, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(325).position);
		assertEquals(2, treeOrd5.search(350).position);
	
		
		assertEquals(11, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(75);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(225).position);
		assertEquals(2, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(325).position);
		assertEquals(2, treeOrd5.search(350).position);
		
		assertEquals(12, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(175);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(200).position);
		assertEquals(2, treeOrd5.search(225).position);
		assertEquals(2, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(325).position);
		assertEquals(2, treeOrd5.search(350).position);
		
		assertEquals(13, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(275);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(200).position);
		assertEquals(2, treeOrd5.search(225).position);
		assertEquals(2, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(275).position);
		assertEquals(1, treeOrd5.search(300).position);
		assertEquals(2, treeOrd5.search(325).position);
		assertEquals(3, treeOrd5.search(350).position);
		
		assertEquals(14, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(375);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(200).position);
		assertEquals(2, treeOrd5.search(225).position);
		assertEquals(2, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(275).position);
		assertEquals(1, treeOrd5.search(300).position);
		assertEquals(3, treeOrd5.search(325).position);
		assertEquals(0, treeOrd5.search(350).position);
		assertEquals(1, treeOrd5.search(375).position);
		
		assertEquals(15, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(205);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(200).position);
		assertEquals(2, treeOrd5.search(205).position);
		assertEquals(3, treeOrd5.search(225).position);
		assertEquals(2, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(275).position);
		assertEquals(1, treeOrd5.search(300).position);
		assertEquals(3, treeOrd5.search(325).position);
		assertEquals(0, treeOrd5.search(350).position);
		assertEquals(1, treeOrd5.search(375).position);
		
		assertEquals(16, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		

		treeOrd5.insert(195);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(195).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(0, treeOrd5.search(205).position);
		assertEquals(1, treeOrd5.search(225).position);
		assertEquals(0, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(275).position);
		assertEquals(1, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(325).position);
		assertEquals(0, treeOrd5.search(350).position);
		assertEquals(1, treeOrd5.search(375).position);
		
		assertEquals(17, treeOrd5.size());
		assertEquals(2, treeOrd5.height());

	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testDepthLeftOrder(){
//		
// 													 								[50]
//														[20]  												    	[80]
//										[10]						[30 , 40]				    	 [65,70] 						[90]
//									[5]		 [15]			    [25]   [35]   [45]				 [55] [60] [75] 				[85] 	[95]
//
//		
// Ordem de inserção dos elementos: 50, 80, 30, 75, 95, 90, 70, 5, 10, 45, 20, 60, 85, 25, 55, 15, 40, 35, 65
		
		BNode node_50 = new BNode<Integer>(3), 
				node_20 = new BNode<Integer>(3), 
				node_80 = new BNode<Integer>(3), 
				node_10 = new BNode<Integer>(3), 
				node_30_40 = new BNode<Integer>(3),
				node_65_70 = new BNode<Integer>(3),
				node_90 = new BNode<Integer>(3),
				node_5 = new BNode<Integer>(3),
				node_15 = new BNode<Integer>(3),
				node_25 = new BNode<Integer>(3), 
				node_35 = new BNode<Integer>(3),
				node_45 = new BNode<Integer>(3), 
				node_55 = new BNode<Integer>(3),
				node_60 = new BNode<Integer>(3),
				node_75 = new BNode<Integer>(3), 
				node_85 = new BNode<Integer>(3), 
				node_95 = new BNode<Integer>(3);
		
			
				
				LinkedList<BNode> height_0 = new LinkedList<>(); height_0.addLast(node_20); height_0.addLast(node_80);
				LinkedList<BNode> height_1_1 = new LinkedList<>(); height_1_1.addLast(node_10); height_1_1.addLast(node_30_40);
				LinkedList<BNode> height_1_2 = new LinkedList<>(); height_1_2.addLast(node_65_70); height_1_2.addLast(node_90);
				LinkedList<BNode> height_2_1 = new LinkedList<>(); height_2_1.addLast(node_5); height_2_1.addLast(node_15);
				LinkedList<BNode> height_2_2 = new LinkedList<>(); height_2_2.addLast(node_25); height_2_2.addLast(node_35); height_2_2.addLast(node_45);
				LinkedList<BNode> height_2_3 = new LinkedList<>(); height_2_3.addLast(node_55); height_2_3.addLast(node_60); height_2_3.addLast(node_75);
				LinkedList<BNode> height_2_4 = new LinkedList<>(); height_2_4.addLast(node_85); height_2_4.addLast(node_95);
				
				node_50.setChildren(height_0);
				node_20.setChildren(height_1_1);
				node_80.setChildren(height_1_2);
				node_10.setChildren(height_2_1);
				node_30_40.setChildren(height_2_2);
				node_65_70.setChildren(height_2_3);
				node_90.setChildren(height_2_4);
				
				node_50.addElement(50); 
				node_20.addElement(20);  
				node_80.addElement(80);   
				node_10.addElement(10);  
				node_30_40.addElement(30); node_30_40.addElement(40);   
				node_65_70.addElement(65); node_65_70.addElement(70);    
				node_90.addElement(90); 
				node_5.addElement(5); 
				node_15.addElement(15);  
				node_25.addElement(25);  
				node_35.addElement(35);  
				node_45.addElement(45);  
				node_55.addElement(55);  
				node_60.addElement(60);  
				node_75.addElement(75); 
				node_85.addElement(85); 
				node_95.addElement(95); 

				BNode[] DepthLeftOrder = {node_50, 
						node_20, 
						node_10,
						node_5,
						node_15,
						node_30_40,
						node_25,
						node_35,
						node_45,
						node_80,
						node_65_70,
						node_55,
						node_60,
						node_75,
						node_90,
						node_85,
						node_95};
				
				treeOrd3.root = node_50;
				
				BNode[] DepthLeftOrderBTree = treeOrd3.depthLeftOrder();
				
				assertTrue(Arrays.equals(DepthLeftOrder, DepthLeftOrderBTree));
				}


		
	}

