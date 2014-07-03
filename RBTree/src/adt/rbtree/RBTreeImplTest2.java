package adt.rbtree;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import adt.bt.BTNode;

import adt.rbtree.RBNode.Colour;

public class RBTreeImplTest2 {
        
//      < --------------------------------------------------------- >
//      COMPLETOS EM:
//               -> METODOS DE PROPRIEDADES!
//               -> INSERT ( TODOS OS CASOS! )
//               -> REMOVE ( REMOCAO DE FOLHA RED! )
//               -> REMOVE ( REMOCAO DE NODE RED COM SUCESSOR RED! ( LEFT-RIGHT ))
//               -> REMOVE ( REMOCAO DE NODE RED COM SUCESSOR BLACK! ( LEFT-RIGHT ))
//               -> REMOVE ( REMOCAO DE FOLHA BLACK! )
//               -> REMOVE ( REMOCAO DE NODE BLACK COM SUCESSOR RED! ( LEFT ))
//               -> REMOVE ( REMOCAO DE NODE BLACK COM SUCESSOR BLACK! ( RIGHT ))
//      < --------------------------------------------------------- >

        RBTreeImpl<Integer> myTree;
        RBNode<Integer> NIL;
        
        @Before
        public void before() {
                myTree = new RBTreeImpl<Integer>();
                NIL = new RBNode<Integer>();
        }

        @Test
        public void testInsertCaso1() {
                //      INSERT ROOT                             -- CASO 1       ( EH ROOT )
                myTree.insert(50);
                Assert.assertTrue(myTree.getRoot().getData() == 50);
                Assert.assertTrue(myTree.getRoot().getParent() == null);
                Assert.assertTrue(myTree.getRoot().getLeft().equals( NIL ));
                Assert.assertTrue(myTree.getRoot().getRight().equals( NIL ));
                Assert.assertTrue(((RBNode<Integer>) myTree.getRoot()).getColour() == Colour.BLACK );
        }

        @Test
        public void testInsertCaso2() {
                myTree.insert(50);
                // INSERT CHILD Right           -- CASO 2       ( PARENT EH PReTO )
                myTree.insert(75);      // ADD RIGHT
                RBNode<Integer> nodeRight = (RBNode<Integer>) myTree.getRoot().getRight();
                Assert.assertTrue(nodeRight.getData() == 75);
                Assert.assertTrue(nodeRight.getParent().equals( (RBNode<Integer>) myTree.getRoot()));
                Assert.assertTrue(nodeRight.getLeft().equals( NIL ));
                Assert.assertTrue(nodeRight.getRight().equals( NIL ));
                Assert.assertTrue(nodeRight.getColour() == Colour.RED );
                
                myTree.insert(25);      // ADD LEFT
                RBNode<Integer> nodeLeft = (RBNode<Integer>) myTree.getRoot().getLeft();
                Assert.assertTrue(nodeLeft.getData() == 25);
                Assert.assertTrue(nodeLeft.getParent().equals( (RBNode<Integer>) myTree.getRoot()));
                Assert.assertTrue(nodeLeft.getLeft().equals( NIL ));
                Assert.assertTrue(nodeLeft.getRight().equals( NIL ));
                Assert.assertTrue(nodeLeft.getColour() == Colour.RED );
        }

        @Test
        public void testInsertCaso3P1() {
                myTree.insert(50);
                myTree.insert(75);
                // INSERT CHILD Right           -- CASO 3.1 ( PARENT EH RED E FAZ PERNA ) na direita
                myTree.insert(100);
                Assert.assertTrue(myTree.getRoot().getData() == 75);
                Assert.assertTrue(myTree.getRoot().getParent() == null);
                Assert.assertTrue(((RBNode<Integer>) myTree.getRoot()).getColour() == Colour.BLACK );
                RBNode<Integer> nodeLeft = (RBNode<Integer>) myTree.getRoot().getLeft();
                Assert.assertTrue(nodeLeft.getData() == 50);
                Assert.assertTrue(nodeLeft.getParent().equals( (RBNode<Integer>) myTree.getRoot()));
                Assert.assertTrue(nodeLeft.getLeft().equals( NIL ));
                Assert.assertTrue(nodeLeft.getRight().equals( NIL ));
                Assert.assertTrue(nodeLeft.getColour() == Colour.RED );
                RBNode<Integer> nodeRight = (RBNode<Integer>) myTree.getRoot().getRight();
                Assert.assertTrue(nodeRight.getData() == 100);
                Assert.assertTrue(nodeRight.getParent().equals( (RBNode<Integer>) myTree.getRoot()));
                Assert.assertTrue(nodeRight.getLeft().equals( NIL ));
                Assert.assertTrue(nodeRight.getRight().equals( NIL ));
                Assert.assertTrue(nodeRight.getColour() == Colour.RED );
        }

        @Test
        public void testInsertCaso3P2() {
                myTree.insert(50);
                myTree.insert(25);
                // INSERT CHILD Right           -- CASO 3.2 ( PARENT EH RED E FAZ PERNA ) na esquerda
                myTree.insert(0);
                Assert.assertTrue(myTree.getRoot().getData() == 25);
                Assert.assertTrue(myTree.getRoot().getParent() == null);
                Assert.assertTrue(((RBNode<Integer>) myTree.getRoot()).getColour() == Colour.BLACK );
                RBNode<Integer> nodeLeft = (RBNode<Integer>) myTree.getRoot().getLeft();
                Assert.assertTrue(nodeLeft.getData() == 0);
                Assert.assertTrue(nodeLeft.getParent().equals( (RBNode<Integer>) myTree.getRoot()));
                Assert.assertTrue(nodeLeft.getLeft().equals( NIL ));
                Assert.assertTrue(nodeLeft.getRight().equals( NIL ));
                Assert.assertTrue(nodeLeft.getColour() == Colour.RED );
                RBNode<Integer> nodeRight = (RBNode<Integer>) myTree.getRoot().getRight();
                Assert.assertTrue(nodeRight.getData() == 50);
                Assert.assertTrue(nodeRight.getParent().equals( (RBNode<Integer>) myTree.getRoot()));
                Assert.assertTrue(nodeRight.getLeft().equals( NIL ));
                Assert.assertTrue(nodeRight.getRight().equals( NIL ));
                Assert.assertTrue(nodeRight.getColour() == Colour.RED );
        }

        @Test
        public void testInsertCaso4P1() {
                myTree.insert(50);
                myTree.insert(100);
                // INSERT CHILD Right           -- CASO 4.1 ( PARENT EH RED E FAZ PERNA ) na direita
                myTree.insert(75);
                Assert.assertTrue(myTree.getRoot().getData() == 75);
                Assert.assertTrue(myTree.getRoot().getParent() == null);
                Assert.assertTrue(((RBNode<Integer>) myTree.getRoot()).getColour() == Colour.BLACK );
                RBNode<Integer> nodeLeft = (RBNode<Integer>) myTree.getRoot().getLeft();
                Assert.assertTrue(nodeLeft.getData() == 50);
                Assert.assertTrue(nodeLeft.getParent().equals( (RBNode<Integer>) myTree.getRoot()));
                Assert.assertTrue(nodeLeft.getLeft().equals( NIL ));
                Assert.assertTrue(nodeLeft.getRight().equals( NIL ));
                Assert.assertTrue(nodeLeft.getColour() == Colour.RED );
                RBNode<Integer> nodeRight = (RBNode<Integer>) myTree.getRoot().getRight();
                Assert.assertTrue(nodeRight.getData() == 100);
                Assert.assertTrue(nodeRight.getParent().equals( (RBNode<Integer>) myTree.getRoot()));
                Assert.assertTrue(nodeRight.getLeft().equals( NIL ));
                Assert.assertTrue(nodeRight.getRight().equals( NIL ));
                Assert.assertTrue(nodeRight.getColour() == Colour.RED );
        }

        @Test
        public void testInsertCaso4P2() {
                myTree.insert(50);
                myTree.insert(0);
                // INSERT CHILD Right           -- CASO 4.2 ( PARENT EH RED E FAZ PERNA ) na esquerda
                myTree.insert(25);
                Assert.assertTrue(myTree.getRoot().getData() == 25);
                Assert.assertTrue(myTree.getRoot().getParent() == null);
                Assert.assertTrue(((RBNode<Integer>) myTree.getRoot()).getColour() == Colour.BLACK );
                RBNode<Integer> nodeLeft = (RBNode<Integer>) myTree.getRoot().getLeft();
                Assert.assertTrue(nodeLeft.getData() == 0);
                Assert.assertTrue(nodeLeft.getParent().equals( (RBNode<Integer>) myTree.getRoot()));
                Assert.assertTrue(nodeLeft.getLeft().equals( NIL ));
                Assert.assertTrue(nodeLeft.getRight().equals( NIL ));
                Assert.assertTrue(nodeLeft.getColour() == Colour.RED );
                RBNode<Integer> nodeRight = (RBNode<Integer>) myTree.getRoot().getRight();
                Assert.assertTrue(nodeRight.getData() == 50);
                Assert.assertTrue(nodeRight.getParent().equals( (RBNode<Integer>) myTree.getRoot()));
                Assert.assertTrue(nodeRight.getLeft().equals( NIL ));
                Assert.assertTrue(nodeRight.getRight().equals( NIL ));
                Assert.assertTrue(nodeRight.getColour() == Colour.RED );
        }
        
        // < --------------------------- Teste Propriedades! --------------------------- >
/*                
        @Test
        public void testBlackHeight() {
                myTree.insert(50);
                myTree.insert(25);
                myTree.insert(75);
                myTree.insert(20);
                myTree.insert(30);
                Assert.assertTrue( myTree.alturaPreta() );
                ((RBNode<Integer>) myTree.getRoot().getLeft().getLeft()).setColour();
                Assert.assertFalse( myTree.alturaPreta() );
        }
*/
}