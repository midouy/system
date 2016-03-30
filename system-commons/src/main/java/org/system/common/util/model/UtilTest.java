package org.system.common.util.model;


import org.system.common.util.commons.DataGetter;
import org.system.common.util.commons.DataShower;

public class UtilTest {

	public static void main(String[] args) {
		
		//Node root = DataGetter.randomIntLinkedList(10, 50);
		//DataShower.show(root);
		
		
		BinaryTree bt = DataGetter.randomIntSortedBinaryTree(10,40);
		DataShower.show(bt, ShowType.ALL);
	}

}
