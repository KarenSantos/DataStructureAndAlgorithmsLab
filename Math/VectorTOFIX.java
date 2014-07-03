package leda.aula4;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public class VectorTOFIX<E> extends AbstractList<E> implements List<E>,
		RandomAccess, Cloneable, java.io.Serializable {
	/**
	 * The array buffer into which the components of the vector are stored. The
	 * capacity of the vector is the length of this array buffer, and is at
	 * least large enough to contain all the vector's elements.
	 * 
	 * <p>
	 * Any array elements following the last element in the Vector are null.
	 * 
	 * @serial
	 */
	protected Object[] elementData;

	/**
	 * The number of valid components in this {@code Vector} object. Components
	 * {@code elementData[0]} through {@code elementData[elementCount-1]} are
	 * the actual items.
	 * 
	 * @serial
	 */
	protected int elementCount;

	/**
	 * The amount by which the capacity of the vector is automatically
	 * incremented when its size becomes greater than its capacity. If the
	 * capacity increment is less than or equal to zero, the capacity of the
	 * vector is doubled each time it needs to grow.
	 * 
	 * @serial
	 */
	protected int capacityIncrement;

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = -2767605614048989439L;

	/**
	 * Constructs an empty vector with the specified initial capacity and
	 * capacity increment.
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the vector
	 * @param capacityIncrement
	 *            the amount by which the capacity is increased when the vector
	 *            overflows
	 * @throws IllegalArgumentException
	 *             if the specified initial capacity is negative
	 */
	public VectorTOFIX(int initialCapacity, int capacityIncrement) {
		super();
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: "
					+ initialCapacity);
		this.elementData = new Object[initialCapacity];
		this.capacityIncrement = capacityIncrement;
	}

	/**
	 * Constructs an empty vector with the specified initial capacity and with
	 * its capacity increment equal to zero.
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the vector
	 * @throws IllegalArgumentException
	 *             if the specified initial capacity is negative
	 */
	public VectorTOFIX(int initialCapacity) {
		this(initialCapacity, 0);
	}

	/**
	 * Constructs an empty vector so that its internal data array has size
	 * {@code 10} and its standard capacity increment is zero.
	 */
	public VectorTOFIX() {
		this(10);
	}

	// FIXME 1 defeito
	/**
	 * Trims the capacity of this vector to be the vector's current size. If the
	 * capacity of this vector is larger than its current size, then the
	 * capacity is changed to equal the size by replacing its internal data
	 * array, kept in the field {@code elementData}, with a smaller one. An
	 * application can use this operation to minimize the storage of a vector.
	 */
	public synchronized void trimToSize() {
		modCount++;
		int oldCapacity = elementData.length;
		if (elementCount <= oldCapacity) {
			elementData = Arrays.copyOf(elementData, elementCount);
		}
	}

	/**
	 * Increases the capacity of this vector, if necessary, to ensure that it
	 * can hold at least the number of components specified by the minimum
	 * capacity argument.
	 * 
	 * <p>
	 * If the current capacity of this vector is less than {@code minCapacity},
	 * then its capacity is increased by replacing its internal data array, kept
	 * in the field {@code elementData}, with a larger one. The size of the new
	 * data array will be the old size plus {@code capacityIncrement}, unless
	 * the value of {@code capacityIncrement} is less than or equal to zero, in
	 * which case the new capacity will be twice the old capacity; but if this
	 * new size is still smaller than {@code minCapacity}, then the new capacity
	 * will be {@code minCapacity}.
	 * 
	 * @param minCapacity
	 *            the desired minimum capacity
	 */
	public synchronized void ensureCapacity(int minCapacity) {
		modCount++;
		ensureCapacityHelper(minCapacity);
	}

	/**
	 * This implements the unsynchronized semantics of ensureCapacity.
	 * Synchronized methods in this class can internally call this method for
	 * ensuring capacity without incurring the cost of an extra synchronization.
	 * 
	 * @see #ensureCapacity(int)
	 */
	private void ensureCapacityHelper(int minCapacity) {
		int oldCapacity = elementData.length;
		if (minCapacity > oldCapacity) {
			Object[] oldData = elementData;
			int newCapacity = (capacityIncrement > 0) ? (oldCapacity + capacityIncrement)
					: (oldCapacity * 2);
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}

	/**
	 * Sets the size of this vector. If the new size is greater than the current
	 * size, new {@code null} items are added to the end of the vector. If the
	 * new size is less than the current size, all components at index
	 * {@code newSize} and greater are discarded.
	 * 
	 * @param newSize
	 *            the new size of this vector
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the new size is negative
	 */
	public synchronized void setSize(int newSize) {
		modCount++;
		if (newSize > elementCount) {
			ensureCapacityHelper(newSize);
		} else {
			for (int i = newSize; i < elementCount; i++) {
				elementData[i] = null;
			}
		}
		elementCount = newSize;
	}

	// FIXME 1 defeito
	/**
	 * Returns the number of components in this vector.
	 * 
	 * @return the number of components in this vector
	 */
	public synchronized int size() {
		return elementData.length;
	}

	/**
	 * Tests if this vector has no components.
	 * 
	 * @return {@code true} if and only if this vector has no components, that
	 *         is, its size is zero; {@code false} otherwise.
	 */
	public synchronized boolean isEmpty() {
		return elementCount == 0;
	}

	/**
	 * Returns an enumeration of the components of this vector. The returned
	 * {@code Enumeration} object will generate all items in this vector. The
	 * first item generated is the item at index {@code 0}, then the item at
	 * index {@code 1}, and so on.
	 * 
	 * @return an enumeration of the components of this vector
	 * @see Iterator
	 */
	public Enumeration<E> elements() {
		return new Enumeration<E>() {
			int count = 0;

			public boolean hasMoreElements() {
				return count < elementCount;
			}

			public E nextElement() {
				synchronized (VectorTOFIX.this) {
					if (count < elementCount) {
						return (E) elementData[count++];
					}
				}
				throw new NoSuchElementException("Vector Enumeration");
			}
		};
	}

	/**
	 * Returns {@code true} if this vector contains the specified element. More
	 * formally, returns {@code true} if and only if this vector contains at
	 * least one element {@code e} such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 * 
	 * @param o
	 *            element whose presence in this vector is to be tested
	 * @return {@code true} if this vector contains the specified element
	 */
	public boolean contains(Object o) {
		return indexOf(o, 0) >= 0;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this vector, or -1 if this vector does not contain the element. More
	 * formally, returns the lowest index {@code i} such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
	 * or -1 if there is no such index.
	 * 
	 * @param o
	 *            element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this vector, or -1 if this vector does not contain the element
	 */
	public int indexOf(Object o) {
		return indexOf(o, 0);
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this vector, searching forwards from {@code index}, or returns -1 if the
	 * element is not found. More formally, returns the lowest index {@code i}
	 * such that
	 * <tt>(i&nbsp;&gt;=&nbsp;index&nbsp;&amp;&amp;&nbsp;(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i))))</tt>
	 * , or -1 if there is no such index.
	 * 
	 * @param o
	 *            element to search for
	 * @param index
	 *            index to start searching from
	 * @return the index of the first occurrence of the element in this vector
	 *         at position {@code index} or later in the vector; {@code -1} if
	 *         the element is not found.
	 * @throws IndexOutOfBoundsException
	 *             if the specified index is negative
	 * @see Object#equals(Object)
	 */
	public synchronized int indexOf(Object o, int index) {
		if (o == null) {
			for (int i = index; i < elementCount; i++)
				if (elementData[i] == null)
					return i;
		} else {
			for (int i = index; i < elementCount; i++)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * vector, or -1 if this vector does not contain the element. More formally,
	 * returns the highest index {@code i} such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
	 * or -1 if there is no such index.
	 * 
	 * @param o
	 *            element to search for
	 * @return the index of the last occurrence of the specified element in this
	 *         vector, or -1 if this vector does not contain the element
	 */
	public synchronized int lastIndexOf(Object o) {
		return lastIndexOf(o, elementCount - 1);
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * vector, searching backwards from {@code index}, or returns -1 if the
	 * element is not found. More formally, returns the highest index {@code i}
	 * such that
	 * <tt>(i&nbsp;&lt;=&nbsp;index&nbsp;&amp;&amp;&nbsp;(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i))))</tt>
	 * , or -1 if there is no such index.
	 * 
	 * @param o
	 *            element to search for
	 * @param index
	 *            index to start searching backwards from
	 * @return the index of the last occurrence of the element at position less
	 *         than or equal to {@code index} in this vector; -1 if the element
	 *         is not found.
	 * @throws IndexOutOfBoundsException
	 *             if the specified index is greater than or equal to the
	 *             current size of this vector
	 */
	public synchronized int lastIndexOf(Object o, int index) {
		if (index >= elementCount)
			throw new IndexOutOfBoundsException(index + " >= " + elementCount);

		if (o == null) {
			for (int i = index; i >= 0; i--)
				if (elementData[i] == null)
					return i;
		} else {
			for (int i = index; i >= 0; i--)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	/**
	 * Returns the component at the specified index.
	 * 
	 * <p>
	 * This method is identical in functionality to the {@link #get(int)} method
	 * (which is part of the {@link List} interface).
	 * 
	 * @param index
	 *            an index into this vector
	 * @return the component at the specified index
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the index is out of range (
	 *             {@code index < 0 || index >= size()})
	 */
	public synchronized E elementAt(int index) {
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index + " >= "
					+ elementCount);
		}

		return (E) elementData[index];
	}

	/**
	 * Returns the last component of the vector.
	 * 
	 * @return the last component of the vector, i.e., the component at index
	 *         <code>size()&nbsp;-&nbsp;1</code>.
	 * @throws NoSuchElementException
	 *             if this vector is empty
	 */
	public synchronized E lastElement() {
		if (elementCount == 0) {
			throw new NoSuchElementException();
		}
		return (E) elementData[elementCount - 1];
	}

	/**
	 * Sets the component at the specified {@code index} of this vector to be
	 * the specified object. The previous component at that position is
	 * discarded.
	 * 
	 * <p>
	 * The index must be a value greater than or equal to {@code 0} and less
	 * than the current size of the vector.
	 * 
	 * <p>
	 * This method is identical in functionality to the
	 * {@link #set(int, Object) set(int, E)} method (which is part of the
	 * {@link List} interface). Note that the {@code set} method reverses the
	 * order of the parameters, to more closely match array usage. Note also
	 * that the {@code set} method returns the old value that was stored at the
	 * specified position.
	 * 
	 * @param obj
	 *            what the component is to be set to
	 * @param index
	 *            the specified index
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the index is out of range (
	 *             {@code index < 0 || index >= size()})
	 */
	public synchronized void setElementAt(E obj, int index) {
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index + " >= "
					+ elementCount);
		}
		elementData[index] = obj;
	}

	// FIXME 1 defeito
	/**
	 * Deletes the component at the specified index. Each component in this
	 * vector with an index greater or equal to the specified {@code index} is
	 * shifted downward to have an index one smaller than the value it had
	 * previously. The size of this vector is decreased by {@code 1}.
	 * 
	 * <p>
	 * The index must be a value greater than or equal to {@code 0} and less
	 * than the current size of the vector.
	 * 
	 * <p>
	 * This method is identical in functionality to the {@link #remove(int)}
	 * method (which is part of the {@link List} interface). Note that the
	 * {@code remove} method returns the old value that was stored at the
	 * specified position.
	 * 
	 * @param index
	 *            the index of the object to remove
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the index is out of range (
	 *             {@code index < 0 || index >= size()})
	 */
	public synchronized void removeElementAt(int index) {
		modCount++;
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index + " >= "
					+ elementCount);
		} else if (index < 0) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		int j = elementCount - index - 1;
		if (j >= 0) {
			System.arraycopy(elementData, index + 1, elementData, index, j);
		}
		elementCount--;
		elementData[elementCount] = null; /* to let gc do its work */
	}

	/**
	 * Inserts the specified object as a component in this vector at the
	 * specified {@code index}. Each component in this vector with an index
	 * greater or equal to the specified {@code index} is shifted upward to have
	 * an index one greater than the value it had previously.
	 * 
	 * <p>
	 * The index must be a value greater than or equal to {@code 0} and less
	 * than or equal to the current size of the vector. (If the index is equal
	 * to the current size of the vector, the new element is appended to the
	 * Vector.)
	 * 
	 * <p>
	 * This method is identical in functionality to the
	 * {@link #add(int, Object) add(int, E)} method (which is part of the
	 * {@link List} interface). Note that the {@code add} method reverses the
	 * order of the parameters, to more closely match array usage.
	 * 
	 * @param obj
	 *            the component to insert
	 * @param index
	 *            where to insert the new component
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the index is out of range (
	 *             {@code index < 0 || index > size()})
	 */
	public synchronized void insertElementAt(E obj, int index) {
		modCount++;
		if (index > elementCount) {
			throw new ArrayIndexOutOfBoundsException(index + " > "
					+ elementCount);
		}
		ensureCapacityHelper(elementCount + 1);
		System.arraycopy(elementData, index, elementData, index + 1,
				elementCount - index);
		elementData[index] = obj;
		elementCount++;
	}

	/**
	 * Adds the specified component to the end of this vector, increasing its
	 * size by one. The capacity of this vector is increased if its size becomes
	 * greater than its capacity.
	 * 
	 * <p>
	 * This method is identical in functionality to the {@link #add(Object)
	 * add(E)} method (which is part of the {@link List} interface).
	 * 
	 * @param obj
	 *            the component to be added
	 */
	public synchronized void addElement(E obj) {
		modCount++;
		ensureCapacityHelper(elementCount + 1);
		elementData[elementCount++] = obj;
	}

	/**
	 * Removes the first (lowest-indexed) occurrence of the argument from this
	 * vector. If the object is found in this vector, each component in the
	 * vector with an index greater or equal to the object's index is shifted
	 * downward to have an index one smaller than the value it had previously.
	 * 
	 * <p>
	 * This method is identical in functionality to the {@link #remove(Object)}
	 * method (which is part of the {@link List} interface).
	 * 
	 * @param obj
	 *            the component to be removed
	 * @return {@code true} if the argument was a component of this vector;
	 *         {@code false} otherwise.
	 */
	public synchronized boolean removeElement(Object obj) {
		modCount++;
		int i = indexOf(obj);
		if (i >= 0) {
			removeElementAt(i);
			return true;
		}
		return false;
	}

	/**
	 * Removes all components from this vector and sets its size to zero.
	 * 
	 * <p>
	 * This method is identical in functionality to the {@link #clear} method
	 * (which is part of the {@link List} interface).
	 */
	public synchronized void removeAllElements() {
		modCount++;
		// Let gc do its work
		for (int i = 0; i < elementCount; i++)
			elementData[i] = null;

		elementCount = 0;
	}

	// Positional Access Operations

	/**
	 * Returns the element at the specified position in this Vector.
	 * 
	 * @param index
	 *            index of the element to return
	 * @return object at the specified index
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the index is out of range (
	 *             {@code index < 0 || index >= size()})
	 * @since 1.2
	 */
	public synchronized E get(int index) {
		if (index >= elementCount)
			throw new ArrayIndexOutOfBoundsException(index);

		return (E) elementData[index];
	}

	/**
	 * Replaces the element at the specified position in this Vector with the
	 * specified element.
	 * 
	 * @param index
	 *            index of the element to replace
	 * @param element
	 *            element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the index is out of range (
	 *             {@code index < 0 || index >= size()})
	 * @since 1.2
	 */
	public synchronized E set(int index, E element) {
		if (index >= elementCount)
			throw new ArrayIndexOutOfBoundsException(index);

		Object oldValue = elementData[index];
		elementData[index] = element;
		return (E) oldValue;
	}

	/**
	 * Appends the specified element to the end of this Vector.
	 * 
	 * @param e
	 *            element to be appended to this Vector
	 * @return {@code true} (as specified by {@link Collection#add})
	 * @since 1.2
	 */
	public synchronized boolean add(E e) {
		modCount++;
		ensureCapacityHelper(elementCount + 1);
		elementData[elementCount++] = e;
		return true;
	}

	/**
	 * Removes the first occurrence of the specified element in this Vector If
	 * the Vector does not contain the element, it is unchanged. More formally,
	 * removes the element with the lowest index i such that
	 * {@code (o==null ? get(i)==null : o.equals(get(i)))} (if such an element
	 * exists).
	 * 
	 * @param o
	 *            element to be removed from this Vector, if present
	 * @return true if the Vector contained the specified element
	 * @since 1.2
	 */
	public boolean remove(Object o) {
		return removeElement(o);
	}

	/**
	 * Inserts the specified element at the specified position in this Vector.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * 
	 * @param index
	 *            index at which the specified element is to be inserted
	 * @param element
	 *            element to be inserted
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the index is out of range (
	 *             {@code index < 0 || index > size()})
	 * @since 1.2
	 */
	public void add(int index, E element) {
		insertElementAt(element, index);
	}

	/**
	 * Removes the element at the specified position in this Vector. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * Returns the element that was removed from the Vector.
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the index is out of range (
	 *             {@code index < 0 || index >= size()})
	 * @param index
	 *            the index of the element to be removed
	 * @return element that was removed
	 * @since 1.2
	 */
	public synchronized E remove(int index) {
		modCount++;
		if (index >= elementCount)
			throw new ArrayIndexOutOfBoundsException(index);
		Object oldValue = elementData[index];

		int numMoved = elementCount - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index,
					numMoved);
		elementData[--elementCount] = null; // Let gc do its work

		return (E) oldValue;
	}

	/**
	 * Removes all of the elements from this Vector. The Vector will be empty
	 * after this call returns (unless it throws an exception).
	 * 
	 * @since 1.2
	 */
	public void clear() {
		removeAllElements();
	}

	// Bulk Operations

	/**
	 * Returns true if this Vector contains all of the elements in the specified
	 * Collection.
	 * 
	 * @param c
	 *            a collection whose elements will be tested for containment in
	 *            this Vector
	 * @return true if this Vector contains all of the elements in the specified
	 *         collection
	 * @throws NullPointerException
	 *             if the specified collection is null
	 */
	public synchronized boolean containsAll(Collection<?> c) {
		return super.containsAll(c);
	}

	/**
	 * Appends all of the elements in the specified Collection to the end of
	 * this Vector, in the order that they are returned by the specified
	 * Collection's Iterator. The behavior of this operation is undefined if the
	 * specified Collection is modified while the operation is in progress.
	 * (This implies that the behavior of this call is undefined if the
	 * specified Collection is this Vector, and this Vector is nonempty.)
	 * 
	 * @param c
	 *            elements to be inserted into this Vector
	 * @return {@code true} if this Vector changed as a result of the call
	 * @throws NullPointerException
	 *             if the specified collection is null
	 * @since 1.2
	 */
	public synchronized boolean addAll(Collection<? extends E> c) {
		modCount++;
		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacityHelper(elementCount + numNew);
		System.arraycopy(a, 0, elementData, elementCount, numNew);
		elementCount += numNew;
		return numNew != 0;
	}

	/**
	 * Removes from this Vector all of its elements that are contained in the
	 * specified Collection.
	 * 
	 * @param c
	 *            a collection of elements to be removed from the Vector
	 * @return true if this Vector changed as a result of the call
	 * @throws ClassCastException
	 *             if the types of one or more elements in this vector are
	 *             incompatible with the specified collection (optional)
	 * @throws NullPointerException
	 *             if this vector contains one or more null elements and the
	 *             specified collection does not support null elements
	 *             (optional), or if the specified collection is null
	 * @since 1.2
	 */
	public synchronized boolean removeAll(Collection<?> c) {
		return super.removeAll(c);
	}

	/**
	 * Retains only the elements in this Vector that are contained in the
	 * specified Collection. In other words, removes from this Vector all of its
	 * elements that are not contained in the specified Collection.
	 * 
	 * @param c
	 *            a collection of elements to be retained in this Vector (all
	 *            other elements are removed)
	 * @return true if this Vector changed as a result of the call
	 * @throws ClassCastException
	 *             if the types of one or more elements in this vector are
	 *             incompatible with the specified collection (optional)
	 * @throws NullPointerException
	 *             if this vector contains one or more null elements and the
	 *             specified collection does not support null elements
	 *             (optional), or if the specified collection is null
	 * @since 1.2
	 */
	public synchronized boolean retainAll(Collection<?> c) {
		return super.retainAll(c);
	}

	/**
	 * Inserts all of the elements in the specified Collection into this Vector
	 * at the specified position. Shifts the element currently at that position
	 * (if any) and any subsequent elements to the right (increases their
	 * indices). The new elements will appear in the Vector in the order that
	 * they are returned by the specified Collection's iterator.
	 * 
	 * @param index
	 *            index at which to insert the first element from the specified
	 *            collection
	 * @param c
	 *            elements to be inserted into this Vector
	 * @return {@code true} if this Vector changed as a result of the call
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the index is out of range (
	 *             {@code index < 0 || index > size()})
	 * @throws NullPointerException
	 *             if the specified collection is null
	 * @since 1.2
	 */
	public synchronized boolean addAll(int index, Collection<? extends E> c) {
		modCount++;
		if (index < 0 || index > elementCount)
			throw new ArrayIndexOutOfBoundsException(index);

		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacityHelper(elementCount + numNew);

		int numMoved = elementCount - index;
		if (numMoved > 0)
			System.arraycopy(elementData, index, elementData, index + numNew,
					numMoved);

		System.arraycopy(a, 0, elementData, index, numNew);
		elementCount += numNew;
		return numNew != 0;
	}

	/**
	 * Compares the specified Object with this Vector for equality. Returns true
	 * if and only if the specified Object is also a List, both Lists have the
	 * same size, and all corresponding pairs of elements in the two Lists are
	 * <em>equal</em>. (Two elements {@code e1} and {@code e2} are
	 * <em>equal</em> if {@code (e1==null ? e2==null :
	 * e1.equals(e2))}.) In other words, two Lists are defined to be equal if
	 * they contain the same elements in the same order.
	 * 
	 * @param o
	 *            the Object to be compared for equality with this Vector
	 * @return true if the specified Object is equal to this Vector
	 */
	public synchronized boolean equals(Object o) {
		return super.equals(o);
	}

	/**
	 * Returns the hash code value for this Vector.
	 */
	public synchronized int hashCode() {
		return super.hashCode();
	}

	/**
	 * Returns a string representation of this Vector, containing the String
	 * representation of each element.
	 */
	public synchronized String toString() {
		return super.toString();
	}

	// FIXME 1 defeito
	/**
	 * Removes from this List all of the elements whose index is between
	 * fromIndex, inclusive and toIndex, exclusive. Shifts any succeeding
	 * elements to the left (reduces their index). This call shortens the
	 * ArrayList by (toIndex - fromIndex) elements. (If toIndex==fromIndex, this
	 * operation has no effect.)
	 * 
	 * @param fromIndex
	 *            index of first element to be removed
	 * @param toIndex
	 *            index after last element to be removed
	 */
	protected synchronized void removeRange(int fromIndex, int toIndex) {
		modCount++;
		int numMoved = elementCount;
		System.arraycopy(elementData, toIndex, elementData, fromIndex, numMoved);

		// Let gc do its work
		int newElementCount = elementCount - (toIndex - fromIndex);
		while (elementCount != newElementCount)
			elementData[--elementCount] = null;
	}

	/**
	 * Save the state of the {@code Vector} instance to a stream (that is,
	 * serialize it). This method is present merely for synchronization. It just
	 * calls the default writeObject method.
	 */
	private synchronized void writeObject(java.io.ObjectOutputStream s)
			throws java.io.IOException {
		s.defaultWriteObject();
	}
}
