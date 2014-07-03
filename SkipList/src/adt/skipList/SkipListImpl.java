package adt.skipList;

public class SkipListImpl<V> implements SkipList<V> {

	protected SkipNode<V> root;
	protected int level;
	protected int maxLevel;

	//SET THIS VALUE TO TRUE IF YOU ARE IMPLEMENTING MAX_LEVEL = LEVEL
	//SET THIS VALUE TO FALSE IF YOU ARE IMPLEMENTING MAX_LEVEL != LEVEL
	protected boolean useMaxLevelAsLevel = true;
	protected double probability = 0.5; 
	protected SkipNode<V> NIL;
	
	public SkipListImpl(int maxLevel) {
		if(useMaxLevelAsLevel){
			this.level = maxLevel;
		}else{
			this.level = 1;
		}
		this.maxLevel = maxLevel;
		root = new SkipNode(Integer.MIN_VALUE, maxLevel, new Integer(Integer.MIN_VALUE));
		NIL = new SkipNode(Integer.MAX_VALUE, maxLevel, new Integer(Integer.MAX_VALUE));
		connectRootToNil();
	}
	
	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL
	 * Caso esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com 
	 * level=1 e o metodo deve conectar apenas o forward[0].  
	 */
	private void connectRootToNil(){
	  for (int i = 0; i < level; i++){
		  root.forward[i] = NIL;
	  }
	}
	
	/**
	 * Metodo que gera uma altura aleatoria para ser atribuida a um novo no no metodo
	 * insert(int,V) 
	 */
	private int randomLevel(){
		int randomLevel = 1;
		while(Math.random() <= probability && randomLevel < maxLevel){
			randomLevel = randomLevel + 1;
		}
		return randomLevel;
	}
	
	@Override
	public void insert(int key, V newValue) {
		
		SkipNode<V>[] update = new SkipNode[maxLevel];
		SkipNode<V> x = root;
		
		for (int i = level-1; i >= 0; i--) {
			while (x.getForward(i).getKey() < key){
				x = x.getForward(i);
			}
			update[i] = x;
		}
		
		x = x.getForward(0);
		if (x.getKey() == key){
			x.satteliteData = newValue;
		}
		else {
			int v = randomLevel();
			if (v > level) {
				for (int i = level; i < v; i++) {
					update[i] = root;
				}
				level = v;
			}
			x = new SkipNode<V>(key, v, newValue);
			for (int i = 0; i < v; i++) {
				x.forward[i] = update[i].getForward(i);
				update[i].forward[i] = x;
			}
		}
	}

	@Override
	public void insert(int key, V newValue, int height) {
		
		if (height > 0 && height <= maxLevel) {
			
			SkipNode<V>[] update = new SkipNode[maxLevel];
			SkipNode<V> x = root;
			
			for (int i = level-1; i >= 0; i--) {
				while (x.getForward(i).getKey() < key){
					x = x.getForward(i);
				}
				update[i] = x;
			}
			
			x = x.getForward(0);
			if (x.getKey() == key){
				x.satteliteData = newValue;
			}
			else {
				if (height > level) {
					for (int i = level; i < height; i++) {
						update[i] = root;
					}
					level = height;
				}
				x = new SkipNode<V>(key, height, newValue);
				for (int i = 0; i < height; i++) {
					x.forward[i] = update[i].getForward(i);
					update[i].forward[i] = x;
				}
			}
		}
	}

	@Override
	public void remove(int key) {

		SkipNode<V>[] update = new SkipNode[maxLevel];
		SkipNode<V> x = root;
		
		for (int i = level-1; i >= 0; i--) {
			while (x.getForward(i).getKey() < key){
				x = x.getForward(i);
			}
			update[i] = x;
		}
		
		x = x.getForward(0);
		if (x.getKey() == key){
			for (int i = 0; i < level; i++) {
				if (!(update[i].getForward(i).equals(x))) {
					break;
				}
				update[i].forward[i] = x.getForward(i);
				
				while (!useMaxLevelAsLevel && level > 1 && root.getForward(level-1).equals(NIL)) {
					level--;
				}
			}
		}
	}

	@Override
	public int height() {
		int resp = 0;
		
		for (int i = level-1; i >= 0; i--) {
			if (!(root.getForward(i).equals(NIL))) {
				resp = i+1;
			}
			if (resp != 0) {
				break;
			}
		}
		return resp;
	}

	@Override
	public SkipNode<V> search(int key) {
		
		SkipNode<V> resp = null;
		SkipNode<V> x = root;
		
		for (int i = level-1; i >= 0; i--) {
			while (x.getForward(i).getKey() < key){
				x = x.getForward(i);
			}
		}
		x = x.getForward(0);
		if (x.getKey() == key){
			resp = x;
		}
		return resp;
	}

	@Override
	public int size(){
		
		int resp = 0;
		SkipNode<V> x = root;
		
		while (!(x.getForward(0).equals(NIL))) {
			x = x.getForward(0);
			resp++;
		}
		return resp;
	}

	@Override
	public SkipNode<V>[] toArray() {
		
		SkipNode<V>[] resp = new SkipNode[size()];
		SkipNode<V> x = root;
		int index = 0;
		
		while (!(x.getForward(0).equals(NIL))) {
			x = x.getForward(0);
			resp[index] = x;
			index++;
		}
		return resp;
	}
	
}
